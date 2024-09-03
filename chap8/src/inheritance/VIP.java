package inheritance;

public class VIP extends Customer {
	int agenId;
	double saleRatio;
	
	public VIP(int customerID, String customerName, int agenId ) {
		super(customerID, customerName);
		customerGrade = "VIP";
		bounsRatio = 0.5;
		saleRatio = 0.1;
	//	System.out.println("VIP() 호출");
		
	}
	public int getAgenId() {
		return this.agenId;
	}
	@Override
	public int calcPrice(int price) {
		bounsPoint += price * bounsRatio;
		return price -(int)(price * saleRatio);
	}
	
	
	public String showVIPInfo() {
		return super.showCustomerInfo()+ "담당 상담원 ID는 " + agenId + "입니다.";
	}
	
	
	
	

}
