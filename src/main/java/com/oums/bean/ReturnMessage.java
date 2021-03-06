package com.oums.bean;

public class ReturnMessage {

	private String messageType;
	private String content;
	private Object object;
	private boolean flat;
	//页面总大小
	private int pageCount;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public ReturnMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReturnMessage [messageType=" + messageType + ", content=" + content + ", object=" + object + ", flat="
				+ flat + ", pageCount=" + pageCount + "]";
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isFlat() {
		return flat;
	}
	public void setFlat(boolean flat) {
		this.flat = flat;
	}
	
}
