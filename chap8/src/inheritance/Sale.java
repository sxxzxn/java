package inheritance;

public class Sale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Customer c = new Customer();
//		c.setCustomerID(1010);
//		c.setCustomerName("수진");
//		c.bounsPoint = 1000;

//		Customer v = new VIP();
//		v.setCustomerID(12);
//		v.setCustomerName("하니");
//		v.bounsPoint = 2000;
//		
////		System.out.println(c.showCustomerInfo());
//		System.out.println(v.showCustomerInfo());

		Customer c = new Customer(1010, "수진");
		c.bounsPoint = 100;

		Customer v = new VIP(12, "하니", 121);  // VIP 객체를 Customer 타입으로 참조
		v.bounsPoint = 100;

		// 다운캐스팅 시도
		VIP vs = null;
		if (v instanceof VIP) {  // v가 VIP의 인스턴스인지 확인
		    vs = (VIP) v;  // 안전한 다운캐스팅
		}
		if (vs != null) {
		    vs.agenId = 100;  // VIP의 필드 사용
		    System.out.println("(다운캐스팅) 상담아이디 :"+vs.agenId);  // 100 출력
		}

		int price = 10000;
		System.out.println(c.CustomerName + "님이 지불할 금액은 " + c.calcPrice(price));
		System.out.println(v.CustomerName + "님이 지불할 금액은 " + v.calcPrice(price));

		Customer vc = new VIP(200, "코코", 3000);
		vc.calcPrice(2000);
		vc.bounsPoint = 1000;
		System.out.println(vc.CustomerName + "님이 지불할 금액은 " + vc.calcPrice(price));
	}

}
