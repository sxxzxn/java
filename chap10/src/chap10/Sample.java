package chap10;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) {
		// 부모클래스 변수 = new 부모클래스();
		// 부모 클래스 병수 = new 자식클래스();
//		Human st = new Student();
//		Human job = new Job();
//	
//		st.eat();
//		st.sleep();
//		//st.goToSchool();
//		
//		job.eat();
//		job.sleep();
//		//job.goToJob();

		// if (st instanceof Student)

//		NoticeImpl bbs = new NoticeImpl();
//		bbs.setIdx(1);
//		bbs.setName("홍길동");
//		bbs.setUserId("user1");
//		bbs.setPwd("123");
//		bbs.setEmail("aa@navber.com");
//		bbs.setTitle("제목");
//		bbs.setContent("글내용");
//		bbs.setDisplayDate("2024-10-01");
//		bbs.setRegDate("2024-09-04");
//		
//		String [] bbsContent = {
//				String.valueOf(bbs.getIdx()),
//				bbs.getName(),
//				bbs.getUserId(),
//				bbs.getPwd(),
//				bbs.getEmail(),
//				bbs.getTitle(),
//				bbs.getContent(),
//				bbs.getDisplayDate(),
//				bbs.getRegDate()
//		};
//		
//		bbs.regist(bbsContent);
//		bbs.getBbsList(0, 0, null, null);
//		bbs.view(bbs.idx);
//		bbs.delete(0);
		// bbs.getBbsList(1, 0, null, null);

		EventImpl ev = new EventImpl();
//		Scanner sc = new Scanner(System.in);
//	exit:
//	  while(true) {
//		ev.dispalyMenu();
//		String selectMenu = sc.nextLine();
//		
//		switch(selectMenu) {
//		case"1":ev.getBbsList(2, 5, "title", "벤트");
//			break;
//		case"2":ev.view(0);
//			break;
//		case"3":ev.delete(0);
//			break;
//		case"4":ev.change(0, selectMenu);
//			break;
//		case"5":ev.addEvent();
//		break;
//		case"6":
//			System.out.println("종료되었습니다.");
//			break exit;
//		}
//		
//	  }	
//		sc.close();

		
//		ev.addEvent();
		
		BasicBbsif bbs = new NoticeImpl();
		NoticeImpl bbs2 = new NoticeImpl();
		bbs = new EventImpl();
		
		// 선언만으로는 값이 할당되지 않음
		int a; // 값 할당x 메모리에 안올라감
		int b = 0; // 값 할당 스택
		Integer d = null; // 참조자료형 -> null가능
		System.out.println(b);
		System.out.println(d);
		System.out.println(d);
		
//		ev.getBbsList(10, 2, null, null);
//		ev.view(3);
//		ev.change(3, "집에보내줘");
//		ev.view(3);
//
//		ev.delete(2);
//		ev.view(2);
		

	}

}
