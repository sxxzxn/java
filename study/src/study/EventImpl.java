package study;

public class EventImpl extends NoticeImpl implements BasicBbsif {

	String startday;
	String endDay;
	String dDay;

	@Override
	public void getBbsList(int pageSize, int pageNo, String searchCategory, String searchWord) {
		String[][] arr = { { "1", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "2", "야구", "선수", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "3", "측구", "손흥민", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "4", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "5", "집", "가고싶다", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "6", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "7", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "8", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "9", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "10", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "11", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "12", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "13", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "14", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "15", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "16", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "17", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "18", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
				{ "19", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },

		};
		
		int totalItem = arr.length;
		int totalPage = (int)Math.ceil(totalItem / pageSize);
		
		int startPage =  (pageNo - 1) * pageSize;
		int endPage = Math.min(startPage + pageSize, arr.length);
		
		System.out.println("글번호 \t 제목 \t 내용 \t이벤트시작일\t이벤트종료일 \t 추첨일");
		
		for (String[] event : arr) {
			if (searchCategory == null || searchCategory.isEmpty()) {
				for (String ev : event) {
					System.out.print(ev + "\t");
				}
			} else if ("title".equals(searchCategory)) {
				if (arr[1][1].contains(searchWord)) {
					for (String ev : event) {
						System.out.print(ev + "\t");
					}
				}

			} else if ("content".equals(searchCategory)) {
				if (arr[1][2].contains(searchWord)) {
					for (String ev : event) {
						System.out.print(ev + "\t");
					}
				}
			}

			System.out.println("");// 게시글 하나 출력 후 줄바꿈
		}
		// 전체 게시글수
		// 전체페이지
		// 시작페이지
		// 종료페이지

		// for 전체페이지보다 작으면
		// if 시작 페이지보다는 크고 종료페이지보단 작을때
		// if 키워드 카테고리 선택값 없을때
		// else if 카테고리 제목일때
		// 해당하면 출력

		// 없으면 검색내용x

		// else 카테고리 내용일때
		// 해당하면 출력

		// 없으면 검색내용x

		// 페이징 부분 출력

	}



	@Override
	public void regist(String[] arrInput) {

	}

	@Override
	public void view(int bbsIdx) {

	}

	@Override
	public void delete(int bbsIdx) {

	}

	public String getStartday() {
		return startday;
	}

	public void setStartday(String startday) {
		this.startday = startday;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getdDay() {
		return dDay;
	}

	public void setdDay(String dDay) {
		this.dDay = dDay;
	}
}
