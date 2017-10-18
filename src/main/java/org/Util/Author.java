package org.Util;

public class Author {
int id;
String name;
String pass;
String telphone;
public String getTelphone() {
	return telphone;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
public Author(){
	
}
public Author(int id, String name, String pass,String telphone) {
	super();
	this.id = id;
	this.name = name;
	this.pass = pass;
	this.telphone=telphone;
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
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}

}
