package com.joviansoft.jms.domain;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bjlxdm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("BJLXDM")
	private String bjlxdm;
	@JsonProperty("BJLXMC")
	private String bjlxmc;
	public String getBjlxmc() {
		return bjlxmc;
	}

	public void setBjlxmc(String bjlxmc) {
		this.bjlxmc = bjlxmc;
	}

	public String getBjlxdm() {
		return bjlxdm;
	}

	public void setBjlxdm(String bjlxdm) {
		this.bjlxdm = bjlxdm;
	}
}
