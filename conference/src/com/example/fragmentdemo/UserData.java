package com.example.fragmentdemo;

public class UserData {

	private String userName;
	private String userPwd;
	//private String Name;
	//private String Title;
	//private String Mail;
	private int userId;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	/*public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		this.Title = title;
	}
	public String getMail() {
		return Mail;
	}

	public void setMail(String mail) {
		this.Mail = mail;
	}*/
	public UserData(String userName, String userPwd, int userId,String name, String title, String mail) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userId = userId;
		
		/*this.Name=name;
		this.Title=title;
		this.Mail=mail;*/
	}

	public UserData(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		
		/*this.Name=null;
		this.Title=null;
		this.Mail=null;*/
	}

}
