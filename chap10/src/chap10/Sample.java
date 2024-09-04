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
		
		//if (st instanceof Student)
		
		NoticeImpl bbs = new NoticeImpl();
		bbs.setIdx(1);
		bbs.setName("홍길동");
		bbs.setUserId("user1");
		bbs.setPwd("123");
		bbs.setEmail("aa@navber.com");
		bbs.setTitle("제목");
		bbs.setContent("글내용");
		bbs.setDisplayDate("2024-10-01");
		bbs.setRegDate("2024-09-04");
		
		String [] bbsContent = {
				String.valueOf(bbs.getIdx()),
				bbs.getName(),
				bbs.getUserId(),
				bbs.getPwd(),
				bbs.getEmail(),
				bbs.getTitle(),
				bbs.getContent(),
				bbs.getDisplayDate(),
				bbs.getRegDate()
		};
		
		bbs.regist(bbsContent);
		bbs.getBbsList(0, 0, null, null);
		bbs.view(bbs.idx);
		bbs.delete(0);
		//	bbs.getBbsList(1, 0, null, null);
		
		
		
		EventImpl ev = new EventImpl();

		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("검색어를 입력하세요: ");
//        
//		String searchKeyword = sc.nextLine(); 
//        
//		ev.setSearchCategory(searchKeyword);
//		sc.close();
		
		ev.getBbsList(2, 1, "title", "벤트");
		
	}

}
