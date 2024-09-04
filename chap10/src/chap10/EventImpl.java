package chap10;

public class EventImpl extends NoticeImpl {
	String startEvent;
	String endEvent;
	String dDay;

	@Override
	public void getBbsList(int pageSize, int pageNo, String searchCategory, String searchWord) {
		// TODO Auto-generated method stub
		String[][] arr = { { "1", "이벤트강지", "강아 내용", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "2", "이벤트22", "22 내용", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "3", "이벤트가", "가벤트", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "4", "이벤트시작", "기아", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "5", "이벤트종료", "타이거즈", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "6", "이벤트집", "1등", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "7", "이벤트빵", "소금빵", "2024-09-01", "2024-09-05", "2024-09-10" },
				{ "8", "이벤트커피", "라떼", "2024-09-01", "2024-09-05", "2024-09-10" } };

		System.out.println("----------------------------이벤트 리스트-----------------------------");
		System.out.println("글번호    이벤트제목  내용\t  시작일\t\t  종료일\t\t  추첨일");

		int totalItems = arr.length;
		int totalPages = (int) Math.ceil(totalItems / pageSize);

		int start = (pageNo - 1) * pageSize;
		int end = Math.min(start + pageSize, arr.length);
		
		for (int i = 0; i < arr.length; i++) {
			// i가 출력할 범위 내에 있는지 확인
			if (i >= start && i < end) {
				// 검색어가 없는 경우 모든 항목 출력
				if (searchWord == null || searchWord.isEmpty()) {
					for (String item : arr[i]) {
						System.out.print(item + "\t");
					}
					System.out.println();
				}
				// title 검색
				else if ("title".equals(searchCategory)) {
					if (arr[i][1].contains(searchWord)) {
						for (String item : arr[i]) {
							System.out.print(item + "\t");
						}
						System.out.println();
					}else{
						System.out.println("검색된 내용이 없습니다.");
					}
				}
				// content 검색
				else if ("content".equals(searchCategory)) {
					if (arr[i][2].contains(searchWord)) {
						for (String item : arr[i]) {
							System.out.print(item + "\t");
						}
						System.out.println();
					}else{
						System.out.println("검색된 내용이 없습니다.");
					}
				}
			}
		}
		//<122343>
		System.out.print(" \t <\t\t");
		for (int i = 1; i <= totalPages; i++) {
			if(i == pageNo) {
				System.out.print(i+"  ");
			}else {
				System.out.print(i+"  ");
			}
			
		}
		
		System.out.print("\t\t>");
		System.out.println();
		// 게시판 끝
		System.out.println("---------------------------------------------------------------------");
		System.out.println("PageSize : " + pageSize + "  " + "pageNo : " + pageNo + "  " + "searchCategory : " + searchCategory + "  " + "searchWord :" + searchWord );
	}


	@Override
	public void view(int bbsIdx) {

	}

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
