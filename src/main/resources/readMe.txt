1.运行说明： 执行run.bat批处理文件,将运行消息推送服务,运行需要JVM环境。

此程序本身会作为一个consumer， 订阅推送的消息。 在控制台会显示所有推送的信息内容.

在控制台输入"q" ,然后回车，可以退出程序。 


2.配置说明


 1）消息相关配置
    消息服务器配置文件为applicationContext.xml 
    a) 消息服务器地址配置（brokerURL）：
    找到以下section，将服务器地址修改成自己的ActiveMQ的服务器地址和端口。
	<bean id="targetConnectionFactory" class="org.apache.activemq.ActiveMQConnectionFactory">
		<property name="brokerURL" value="tcp://192.168.1.99:61616" />
	</bean>
    b)110报警案件消息主题名配置
	找到以下Section，可以修改案件消息主题名,默认为"anjian"。

	<bean id="case110TopicDestination" class="org.apache.activemq.command.ActiveMQTopic">
		<constructor-arg value="anjian" />
	</bean>
    c) 案件数据推送速度
	找到以下section，修改pushSpeed的值，数值为大于0的整数，1表示标准速度，2表示2倍速， 24倍速会将一天内数据在1小时内发送完毕。
	<!-- 110报警Demo推送服务。 -->
	<bean id="case110PushService" class="com.joviansoft.jms.service.Case110DemoPushService">
		<property name="destination" ref="case110TopicDestination" />
		<property name="pushSpeed" value="24"/>
	</bean>
	
	d)轨迹消息主题名配置：
	找到以下section， 可以对主题名"topic-gps-car"进行修改
	<!--警车轨迹主题 -->
	<bean id="carGpsTopicDestination" class="org.apache.activemq.command.ActiveMQTopic">
		<constructor-arg value="topic-gps-car" />
	</bean>

 	e) 轨迹数据推送速度
	找到以下section，修改pushSpeed的值，值的定义通案件速度，1表示正常速度。
	<!-- 警车GPS轨迹 Demo推送服务。 -->
	<bean id="carGpsPushService" class="com.joviansoft.jms.service.CarTraceDemoPushService">
		<property name="destination" ref="carGpsTopicDestination" />
		<property name="pushSpeed" value="1"/>
	</bean>
	
 2）数据相关配置
	为了安装运行方便，此程序采用内置的内存数据库，程序启动后会自动启动创建demo所需的数据库表以及表中的数据.数据库脚本文件在database目录下。
  hsqldb-dataload-case.sql（案件数据脚本），hsqldb-dataload-gps.sql（轨迹数据脚本），hsqldb-schema.sql（数据库结构脚本）。
  如果需要更新demo的数据，可以替换  hsqldb-dataload.sql文件。


jar包可以直接用winrar打开，用notepad打开需要编辑的文件。或者将修改好的文件直接用winrar打开后，拖入jar文件相应的目录中即可，修改后保存即可。


3.客户端调用接口说明

连接参数：
  brokerURL  tcp://192.168.1.99:61616（为服务端所配置的连接URL）
  Topic: anjian（案件主题名 ）
  		 topic-gps-car(车辆轨迹主题名)


1）案件数据格式：
返回格式为JSON。以下为各key对应的内容。
	@JsonProperty("JJDBH") //接警单编号  JJDBH
	@JsonProperty("BJDH") //报警电话  BJDH
	@JsonProperty("BJRXM") //报警人  BJRXM
	@JsonProperty("SFDZ")  // 案发地址 SFDZ
	@JsonProperty("BJNR")  // 案件内容 BJNR
	@JsonProperty("BJLB") // 报警类别  BJLB
	@JsonProperty("BJLX")  // 报警类型  BJLX
	@JsonProperty("BJXL")  // 报警细类 BJXL
	@JsonProperty("BJSJ") //报警时间	  BJSJ
	@JsonProperty("ZDDWXZB") // 自动定位x坐标 
	@JsonProperty("ZDDWYZB") // 自动定位y坐标
	@JsonProperty("BJLXMC")  // 报警类型名称
	@JsonProperty("SDDWXZB") //手动定位x坐标 
	@JsonProperty("SDDWYZB") // 手动定位y坐标 

json字符串示例：
{"JJDBH":"33090013110814361627","BJDH":"15168081272","BJRXM":null,"SFDZ":"临城329国道沈白线路上",
"BJNR":"报警人称：工地货车泥土装载过量，泥土都掉在地上，导致道路通行有障碍。","BJLB":"caseType110300000",
"BJLX":"caseType110309900","BJXL":null,"BJSJ":"2013-11-08 02:36:00.000000","ZDDWXZB":122.190753,
"ZDDWYZB":30.000836,"BJLXMC":"其它交通管理","SDDWXZB":null,"SDDWYZB":"0.0E0"}
2）轨迹数据格式：
   jsonProperty 括号内是相关的key值
	@JsonProperty("HH")  //呼号 
	@JsonProperty("TITLE") //车牌号
	@JsonProperty("SPEED") //速度 
	@JsonProperty("DIRECT") //方向 
	@JsonProperty("X") //坐标x
	@JsonProperty("Y") //坐标y 
	@JsonProperty("GPSTIME") //方向 
	@JsonProperty("TYPE") //类型 
	

数据示例:
{"X":122.21625,"x":122.21625,"HH":"330921000058085493","TITLE":"消防车",
"SPEED":3.0,"DIRECT":214.0,"Y":30.249683,
"GPSTIME":"2013-11-01 05:21:34.000000","TYPE":"0"}