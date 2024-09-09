package chap12;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// 형 지정 안하면 JVM이 형변환
//		MyClass my1 = new MyClass();
//		my1.set("a");
//		System.out.println(my1.get());
		
		
		// 형 지정시 잘못된 타입 들어오면 오류
//		MyClass <String> my2 = new MyClass<String>();
//		my2.set(1);
//		System.out.println(my2.get());
		
		// String 가 자동으로 들어감
//		MyClass <String> my2 = new MyClass<>();
//		my2.set("수진");
//		System.out.println(my2.get());

		//강한 타입 체크( 맞지 않는 타입 들어올경우 동작x)
//		MyClass <String> my2 = new MyClass<>();


		// 다양하게 사용 가능 -> 다형성
		
//		Generic2<String, Integer> fruits = new Generic2<String, Integer>(); 
//		fruits.setKey("사과");
//		fruits.setValue(10000);
//		String key1 = fruits.getKey();
//		int value = fruits.getValue();
//		System.out.println("key1 : " + key1 + ", value : "+ value);
//			
//		Generic2<Integer, String> error = new Generic2<Integer, String>(); 
//		error.setKey(404);
//		error.setValue("Not Found");
//		int key2 = error.getKey();
//		String value2 = error.getValue();
//		System.out.println("key2 : " + key2 + ", value2 : "+ value2);
//		
//		Generic2<String, Void> g3 = new Generic2<String, Void>(); 
//		g3.setKey("키값만 사용");
//		String key3 = g3.getKey();
//		System.out.println("key3 : " + key3 );
		
		
//		Goods<Fruit> gd1 = new Goods<Fruit>();
//		gd1.set(new Fruit());
//		Fruit apple = gd1.get();
//		
//		Goods<Pencil> gd2 = new Goods<Pencil>();
//		gd2.set(new Pencil());
//		Pencil pencil = gd2.get();
		
		
//		List arrPencil = gd2.getList(null);
//		arrPencil.forEach(null
//				
//				);
		
		// r과일
		Goods2<Apple> goods = new Goods2<>(); // 내가 정의한 클래스내 메서드 사용
		//Goods2<Pencil> gd2 = new Goods2<Pencil>(); // 과일 클래스를 상속 받지 않아서 Pencil 사용 불가임
	}

}
