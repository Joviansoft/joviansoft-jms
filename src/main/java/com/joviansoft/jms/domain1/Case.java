package com.joviansoft.jms.domain1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class Case implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("JJDBH")
	private String jjdbh; //接警单编号  JJDBH
	
	@JsonProperty("BJDH")
	private String bjdh; //报警电话  BJDH
	
	@JsonProperty("BJRXM")
	private String bjrxm; //报警人  BJRXM
	
	@JsonProperty("SFDZ")
	private String sfdz; // 案发地址 SFDZ
	
	@JsonProperty("BJNR")
    private String bjnr; // 案件内容 BJNR
	
	@JsonProperty("BJLB")
    private String bjlb; // 报警类别  BJLB
	
	@JsonProperty("BJLX") 
	private String bjlx; // 报警类型  BJLX
	
	@JsonProperty("BJXL") 
	private String bjxl; // 报警细类 BJXL
	
	@JsonProperty("BJSJ")
    private String bjsj; //报警时间	  BJSJ
	
	@JsonProperty("ZDDWXZB")
	private double zddwxzb; // 自动定位x坐标 
	
	@JsonProperty("ZDDWYZB")
	private double zddwyzb; // 自动定位y坐标
	
	@JsonProperty("BJLXMC") 
	private String bjlxmc;  // 报警类型名称
	
	@JsonProperty("SDDWXZB")
	private String sddwzbx; //手动定位x坐标 
	
	@JsonProperty("SDDWYZB") 
	private String sddwyzb; // 手动定位y坐标 
	
	
	
	//JJDBH, BJDH, BJRXM, SFDZ, BJNR, BJLB, BJLX, BJXL, ZDDWXZB, ZDDWYZB, SDDWXZB, SDDWYZB, BJSJ

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getJjdbh() {
		return jjdbh;
	}

	public void setJjdbh(String jjdbh) {
		this.jjdbh = jjdbh;
	}

	public String getBjdh() {
		return bjdh;
	}

	public void setBjdh(String bjdh) {
		this.bjdh = bjdh;
	}

	public String getBjrxm() {
		return bjrxm;
	}

	public void setBjrxm(String bjrxm) {
		this.bjrxm = bjrxm;
	}

	public String getSfdz() {
		return sfdz;
	}

	public void setSfdz(String sfdz) {
		this.sfdz = sfdz;
	}

	public String getBjnr() {
		return bjnr;
	}

	public void setBjnr(String bjnr) {
		this.bjnr = bjnr;
	}

	public String getBjlb() {
		return bjlb;
	}

	public void setBjlb(String bjlb) {
		this.bjlb = bjlb;
	}

	public String getBjsj() {
		return bjsj;
	}

	public void setBjsj(String bjsj) {
		this.bjsj = bjsj;
	}

	public double getZddwxzb() {
		return zddwxzb;
	}

	public void setZddwxzb(double zddwxzb) {
		this.zddwxzb = zddwxzb;
	}

	public double getZddwyzb() {
		return zddwyzb;
	}

	public void setZddwyzb(double zddwyzb) {
		this.zddwyzb = zddwyzb;
	}

	public String getBjlx() {
		return bjlx;
	}

	public void setBjlx(String bjlx) {
		this.bjlx = bjlx;
	}

	public String getBjxl() {
		return bjxl;
	}

	public void setBjxl(String bjxl) {
		this.bjxl = bjxl;
	}

	public String getBjlxmc() {
		return bjlxmc;
	}

	public void setBjlxmc(String bjlxmc) {
		this.bjlxmc = bjlxmc;
	}

	public String getSddwzbx() {
		return sddwzbx;
	}

	public void setSddwzbx(String sddwzbx) {
		this.sddwzbx = sddwzbx;
	}

	public String getSddwyzb() {
		return sddwyzb;
	}

	public void setSddwyzb(String sddwyzb) {
		this.sddwyzb = sddwyzb;
	}
}
