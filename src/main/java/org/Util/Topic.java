package org.Util;

public class Topic {
	String author;
	int id;
	String title;
	String createtime;
	String header;
	public Topic(){
		
	}
	public Topic(String author, int id, String title, String createtime, String header) {
		super();
		this.author = author;
		this.id = id;
		this.title = title;
		this.createtime = createtime;
		this.header = header;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	
}
