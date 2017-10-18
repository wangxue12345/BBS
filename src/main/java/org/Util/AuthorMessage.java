package org.Util;

public class AuthorMessage {
int id;
String name;
String nickname;
String idcard;
int sex;
String telphone;
String img;
String header;
public String getHeader() {
	return header;
}
public void setHeader(String header) {
	this.header = header;
}
public AuthorMessage(){
	
}
public AuthorMessage(int id, String name, String nickname, String idcard, int sex, String telphone, String img) {
	super();
	this.id = id;
	this.name = name;
	this.nickname = nickname;
	this.idcard = idcard;
	this.sex = sex;
	this.telphone = telphone;
	this.img = img;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}
public String getTelphone() {
	return telphone;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

}
