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
		
		
		Customer c = new Customer(1010,"수진");
		c.bounsPoint = 100;
		Customer v = new VIP(12,"하니",121);
		v.bounsPoint = 100;
		
		int price = 10000;
		System.out.println(c.CustomerName+"님이 지불할 금액은 "+c.calcPrice(price));
		System.out.println(v.CustomerName+"님이 지불할 금액은 "+v.calcPrice(price));

		Customer vc = new VIP(200,"코코",3000);
		vc.calcPrice(2000);
		vc.bounsPoint =1000;
		System.out.println(vc.CustomerName+"님이 지불할 금액은 "+vc.calcPrice(price));
		
	}

}
