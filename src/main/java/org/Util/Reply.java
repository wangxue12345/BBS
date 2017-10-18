package org.Util;

public class Reply {
int id;
String reply_author;
String reply_content;
String reply_date;

String header;
int topic_id;
String topic_title;
Topic topic;
public Topic getTopic() {
	return topic;
}


public void setTopic(Topic topic) {
	this.topic = topic;
}


public Reply(Topic topic,int id, String reply_author, String reply_content, String reply_date, int topic_id,String topic_title) {
	super();
	this.id = id;
	this.reply_author = reply_author;
	this.reply_content = reply_content;
	this.reply_date = reply_date;
	this.topic_id = topic_id;
	this.topic_title=topic_title;
	this.topic=topic;
}


public String getHeader() {
	return header;
}
public void setHeader(String header) {
	this.header = header;
}

public String getTopic_title() {
	return topic_title;
}
public void setTopic_title(String topic_title) {
	this.topic_title = topic_title;
}
public Reply(){
	
}




public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getReply_author() {
	return reply_author;
}
public void setReply_author(String reply_author) {
	this.reply_author = reply_author;
}
public String getReply_content() {
	return reply_content;
}
public void setReply_content(String reply_content) {
	this.reply_content = reply_content;
}
public String getReply_date() {
	return reply_date;
}
public void setReply_date(String reply_date) {
	this.reply_date = reply_date;
}
public int getTopic_id() {
	return topic_id;
}
public void setTopic_id(int topic_id) {
	this.topic_id = topic_id;
}




}
