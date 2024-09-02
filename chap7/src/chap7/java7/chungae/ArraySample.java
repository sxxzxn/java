package chap7.java7.chungae;

import java.util.ArrayList;
import java.util.Scanner;

public class ArraySample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		ArrayList<BooksInfo> bookList = new ArrayList<BooksInfo>();
//		bookList.add(new BooksInfo("삼체", "ㅎ")); 
//		bookList.add(new BooksInfo("개미", "베르나르 베르베르"));
//		bookList.add(new BooksInfo("어린왕자", "생택쥐베리"));
//
//		
//		for (int i=0; i<bookList.size(); i++) {
//			BooksInfo bi = bookList.get(i);
//			bi.showBookInfo();
//		}
		
		EventBbs [] arrEventList = new EventBbs[5];
		arrEventList[0] = new EventBbs(1,"user1","1234","010-4230-0031","user1@naver.com","서울시 강남구 논현동 1번길", "101호");
		arrEventList[1] = new EventBbs(2,"user2","1234","010-4230-0032","user1@naver.com","인천시 남구 현동 1번길", "102호");
		arrEventList[2] = new EventBbs(3,"user3","1234","010-4230-0033","user1@naver.com","대전시 유성구 논현동 1번길", "103호");
		arrEventList[3] = new EventBbs(4,"user4","1234","010-4230-0034","user1@naver.com","부산 1번길", "104호");
		arrEventList[4] = new EventBbs(5,"user5","1234","010-4230-0035","user1@naver.com","경기 1번길", "105호");
		System.out.print("글번호 \t");
		System.out.print("작성자 \t");
		System.out.print("비밀번호 \t");
		System.out.print("연락처 \t  \t");
		System.out.print("이메일 \t \t \t");
		System.out.println("주소");
		System.out.println("===================================================================================");
		for(EventBbs bbs : arrEventList) {
			
			System.out.print(bbs.getBbsNo()+ "\t");
			System.out.print(bbs.getUserName()+ "\t");
			System.out.print(bbs.getPwd()+ "\t");
			System.out.print(bbs.getEmail()+ "\t");
			System.out.print(bbs.getPhoneNo()+ "\t");
			System.out.println(bbs.getAddr1()+" "+bbs.getAddr2() );
		}
		
		Scanner sc = new Scanner(System.in) ;
		String name = sc.next();
		
		switch(name) {
		case"1": System.out.println("1. 이전페이지 : ");
		break;
		case"2":System.out.println("2. 다음페이지 : ");
		break;
		case"3":System.out.println("3. 글등록 : ");
		break;
		}
		
		EventBbs [] arrEventList2 = new EventBbs[10];
		System.arraycopy(arrEventList, 0, arrEventList2, 0, 5);
		// 서로 영향 x, 값 할당, 깊은복사
		
		EventBbs[] arrEventList3 = new EventBbs[5];
		arrEventList3 = arrEventList;
		//주소값 할당 얇은 복사
		

	}

}
