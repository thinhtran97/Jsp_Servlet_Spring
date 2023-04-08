package model;

public class Account {
	private int role;
	private String name, adress, phone;
	private int check;
	private String usr, pwd;
	
    public Account( ) {
    	
	}
    

	public Account(int role, String name, String adress, String phone, int check, String usr, String pwd) {
		super();
		this.role = role;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.check = check;
		this.usr = usr;
		this.pwd = pwd;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

}
