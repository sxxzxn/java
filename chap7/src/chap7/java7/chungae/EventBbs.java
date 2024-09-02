package chap7.java7.chungae;

public class EventBbs {
	
	EventBbs() {}
	EventBbs(int bno, String uName, String Pwd, String pNo, String email, String addr1, String addr2){
		this.bbsNo =bno;
		this.userName = uName;
		this.pwd=Pwd;
		this.phoneNo=pNo;
		this.email=email;
		this.addr1=addr1;
		this.addr2=addr2;
		
	}
	int bbsNo;
	String userName;
	String phoneNo;
	String email;
	String addr1;
	String addr2;
	String pwd;
	
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	

}
