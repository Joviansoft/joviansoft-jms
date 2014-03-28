

select JJDBH, replace(BJDH, substr(BJDH, 4,4), '****') BJDH, replace(bjrxm, substr(bjrxm, 2,1), '*') BJRXM, 

replace(SFDZ, substr(SFDZ, 4,2), '**')  SFDZ, BJNR, BJLB, BJLX, BJXL, ZDDWXZB, ZDDWYZB, SDDWXZB, SDDWYZB, to_char(BJSJ,'yyyy-mm-dd hh:mi:ss') BJSJ from bf_110 where  

to_char(bjsj, 'yyyy-mm-dd') = '2013-10-13' order by bjsj



select HH, replace(CPH, substr(CPH, 2,2), '**')  CPH, X, Y, SD, FX, to_char(gjxx.rksj, 'yyyy-mm-dd hh:mi:ss') GPSTIME , XXLX from qwbb_jc_gps_xx jcxx, qwbb_jc_wb_gj gjxx 

where jcxx.hh=gjxx.gpsid and to_char(gjxx.rksj, 'yyyy-mm-dd') = '2013-12-04'

 and jcxx.ssdw like '%定海%' and jcxx.bm is not null

 
 ---最后生成的sql脚本需要修改一下表名 为CAR_GPS