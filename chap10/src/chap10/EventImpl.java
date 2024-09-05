package chap10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EventImpl extends NoticeImpl {
	String startEvent;
	String endEvent;
	String dDay;

	String[][] arr = { { "1", "이벤트강지", "강아 내용", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "2", "이벤트22", "22 내용", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "3", "이벤트가", "가벤트", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "4", "이벤트시작", "기아", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "5", "이벤트종료", "타이거즈", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "6", "이벤트집", "1등", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "7", "이벤트빵", "소금빵", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "8", "이벤트빵", "소금빵", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "9", "이벤트빵", "소금빵", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "10", "이벤트강지", "강아 내용", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "11", "이벤트22", "22 내용", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "12", "이벤트가", "가벤트", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "13", "이벤트시작", "기아", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "14", "이벤트종료", "타이거즈", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "15", "이벤트집", "1등", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "16", "이벤트빵", "소금빵", "2024-09-01", "2024-09-05", "2024-09-10" },
			{ "17", "이벤트커피", "라떼", "2024-09-01", "2024-09-05", "2024-09-10" } };

	// 게시글 등록
	public void regist(String[] arrInput) {
		// TODO Auto-generated method stub
//		  int addSize = arr.length + 1;
//		    String[][] addArr = new String[addSize][];
//		    
//		    for (int i = 0; i < arr.length; i++) {
//		    	addArr[i] = arr[i];
//		    }
//		    
//		    addArr[addSize - 1] = arrInput;
//		    
//		    arr = addArr;
//
//		    for (String[] list : arr) {
//		        for (String borderlist : list) {
//		            System.out.print(borderlist + " ");
//		        }
//		        System.out.println("");
//		    }


		
		
		ArrayList<String[]> list = new ArrayList<>(Arrays.asList(arr));
		list.add(arrInput);
		System.out.println("이벤트 등록 완료");
		arr = list.toArray(new String[0][]);

		// 결과 출력
		System.out.println("전체 이벤트글");
		for (String[] item : arr) {
			System.out.println(Arrays.toString(item));
		}
	}

	// 게시글 등록 받아오기
	public void addEvent() {
		Scanner sc = new Scanner(System.in);

		System.out.println("글번호 :");
		String idx = sc.nextLine();

		System.out.println("제목을 입력하세요:");
		String title = sc.nextLine();

		System.out.println("내용:");
		String content = sc.nextLine();

		System.out.println("이벤트 시작일 (YYYY-MM-DD):");
		String startEvent = sc.nextLine();

		System.out.println("이벤트 종료일 (YYYY-MM-DD):");
		String endEvent = sc.nextLine();

		System.out.println("이벤트 추첨일 (YYYY-MM-DD):");
		String dDay = sc.nextLine();

		String[] newEvent = { idx, title, content, startEvent, endEvent, dDay };
		regist(newEvent);

	}

	@Override
	public void getBbsList(int pageSize, int pageNo, String searchCategory, String searchWord) {
		// TODO Auto-generated method stub
		System.out.println("----------------------------이벤트 리스트-----------------------------");
		System.out.println("글번호    이벤트제목  내용\t  시작일\t\t  종료일\t\t  추첨일");

		List<String[]> searchResults = new ArrayList<>();

		for (String[] item : arr) {
			boolean matches = false;

			if (searchWord == null || searchWord.isEmpty()) {
				matches = true;
			} else if ("title".equals(searchCategory)) {
				if (item[1].contains(searchWord)) {
					matches = true;
				}
			} else if ("content".equals(searchCategory)) {
				if (item[2].contains(searchWord)) {
					matches = true;
				}
			}
			// 조거건에 맞는거
			if (matches) {
				searchResults.add(item);
			}
		}

		// 페이징 시작
		int totalItems = searchResults.size();
		int totalPages = (int) Math.ceil((double) totalItems / pageSize);

		int start = (pageNo - 1) * pageSize;
		int end = Math.min(start + pageSize, totalItems);

		boolean find = false;
		for (int i = start; i < end; i++) {
			String[] item = searchResults.get(i);
			for (String value : item) {
				System.out.print(value + "\t");
			}
			System.out.println();
			find = true;
		}

		if (!find) {
			System.out.println("검색된 내용이 없습니다.");
		}
		
		
		

		System.out.print(" \t <\t\t");
		for (int i = 1; i <= totalPages; i++) {
			if (i == pageNo) {
				System.err.print(i + "  ");
			} else {
				System.out.print(i + "  ");
			}
		}
		System.out.print("\t\t>");
		System.out.println();

		// End of the listing
		System.out.println("---------------------------------------------------------------------");
		System.out.println("PageSize : " + pageSize + "  " + "pageNo : " + pageNo + "  " + "searchCategory : "
				+ searchCategory + "  " + "searchWord :" + searchWord);
		System.out.println("---------------------------------------------------------------------");
	}

	// 게시글 조회
	@Override
	public void view(int bbsIdx) {
		System.out.println("--------------------------게시글 조회----------------------------------");
		for (String[] list : arr) {
			if (list[0].equals(String.valueOf(bbsIdx))) {
				for (String borderlist : list) {
					System.out.print(borderlist + "\t");
				}
				System.out.println("");
				
				System.out.println("-----------------------------------------------------------------");
				return;
			}
		}
		System.out.println(bbsIdx + "번 게시글을 찾을 수 없습니다.");
		System.out.println("---------------------------------------------------------------------");

	}

	// 삭제
	@Override
	public void delete(int bbsIdx) {

		// 배열을 ArrayList로 변환
		ArrayList<String[]> list = new ArrayList<>(Arrays.asList(arr));

		// 삭제할 항목을 찾고 제거
		list.removeIf(item -> Integer.parseInt(item[0]) == bbsIdx);
		System.out.println(bbsIdx + " 게시글을 삭제했습니다.");

		// ArrayList를 다시 배열로 변환
		arr = list.toArray(new String[0][]);

		// 결과 출력
		System.out.println("삭제 후 게시판:");
		for (String[] item : arr) {
			
			
			System.out.println(Arrays.toString(item));
		}
	}

	// 수정
	public void change(int bbsIdx, String content) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0].equals(String.valueOf(bbsIdx))) {
				arr[i][2] = content;
				System.out.println(bbsIdx + "번 게시글 수정");
				return;
			}
		}
	}

	//메뉴판
//	public void dispalyMenu() {
//		System.out.println("*****************이벤트 게시판*************");
//		System.out.println("원하는 번호를 입력하세요");
//		System.out.print("1. 전체 게시판 출력  ");
//		System.out.println("2. 번호로 게시글 찾기  ");
//		System.out.print("3. 인덱스 번호로 게시글 삭제  ");
//		System.out.println("4. 게시글 수정  ");
//		System.out.print("5. 게시글등록  ");
//		System.out.println("6. 종료");
//		System.out.println("****************************************");
//	}

	public String getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(String startEvent) {
		this.startEvent = startEvent;
	}

	public String getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(String endEvent) {
		this.endEvent = endEvent;
	}

	public String getdDay() {
		return dDay;
	}

	public void setdDay(String dDay) {
		this.dDay = dDay;
	}

}
