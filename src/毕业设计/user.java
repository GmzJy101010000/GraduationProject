package ±œ“µ…Ëº∆;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

class user {
  private String username;
  private String pwd;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
  public user(String  a,String b){
	  this.username=a;
	  this.pwd=b;
  }
}
