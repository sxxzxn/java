package inheritance;

public class Customer {
	protected int customerID;
	protected String CustomerName;
	protected String customerGrade;
	int bounsPoint;
	double bounsRatio;
	
	public Customer(int customerID, String CustomerName) {
		this.customerID = customerID;
		this.CustomerName = CustomerName;
		customerGrade = "S";
		bounsRatio =0.01;
		//System.out.println("Customer() 호출");
	}
	public int calcPrice(int price) {
		bounsPoint += price * bounsRatio;
		return price;
	}

	public String showCustomerInfo() {
		return CustomerName + "님 등급은 "+ customerGrade +"입니다."+ "보너스 포인트는 "+ bounsPoint+"입니다.";
	}
	
	
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerGrade() {
		return customerGrade;
	}
	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
	public int getBounsPoint() {
		return bounsPoint;
	}
	public void setBounsPoint(int bounsPoint) {
		this.bounsPoint = bounsPoint;
	}
	public double getBounsRatio() {
		return bounsRatio;
	}
	public void setBounsRatio(double bounsRatio) {
		this.bounsRatio = bounsRatio;
	}
}
