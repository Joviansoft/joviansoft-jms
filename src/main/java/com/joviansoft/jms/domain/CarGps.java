package com.joviansoft.jms.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
/**
 * 警车轨迹数据领域模型 
 * @author bigbao
 *
 */
public class CarGps  implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonProperty("HH") //呼号 
	private String hh;
	
	@JsonProperty("TITLE") //车牌号
	private String cph;
	
	@JsonProperty("SPEED") //速度 
	private double sd;
	
	@JsonProperty("DIRECT") //方向 
	private double fx;
	
	@JsonProperty("X") //坐标x
	private double x;
	
	@JsonProperty("Y") //坐标y 
	private double y;
	
	@JsonProperty("GPSTIME") //方向 
	private String gpstime;
	
	@JsonProperty("XXLX") //信息来源 
	private String xxlx;
	
	@JsonProperty("CMD") //Command 
	private String cmd = "00080";
	
	@JsonProperty("STATUS") //状态 
	private String status = "2";

	@JsonProperty("TYPE") //类型 
	private String type="3";
	
	public String getHh() {
		return hh;
	}
	public void setHh(String hh) {
		this.hh = hh;
	}
	public String getCph() {
		return cph;
	}
	public void setCph(String cph) {
		this.cph = cph;
	}
	
	public double getSd() {
		return sd;
	}
	public void setSd(double sd) {
		this.sd = sd;
	}
	public double getFx() {
		return fx;
	}
	public void setFx(double fx) {
		this.fx = fx;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getGpstime() {
		return gpstime;
	}
	public void setGpstime(String gpstime) {
		this.gpstime = gpstime;
	}
	public String getXxlx() {
		return xxlx;
	}
	public void setXxlx(String xxlx) {
		this.xxlx = xxlx;
	}
	//HH, CPH, X, Y, SD, FX, GPSTIME, XXLX
}
