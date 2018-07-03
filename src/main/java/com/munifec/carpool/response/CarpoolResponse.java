package com.munifec.carpool.response;

import java.io.Serializable;
import java.util.Map;

public class CarpoolResponse implements Serializable {

	private static final long serialVersionUID = 8157053752573982468L;

	private int status;
	private String message;
	private Map<String, Object> data;
	private Map<String, Object> page;

	public CarpoolResponse(int status, String message, Map<String, Object> data, Map<String, Object> page) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
		this.page = page;
	}

	public CarpoolResponse(int status, String message, Map<String, Object> data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, Object> getPage() {
		return page;
	}

	public void setPage(Map<String, Object> page) {
		this.page = page;
	}

}
