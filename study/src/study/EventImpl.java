package study;

import java.util.ArrayList;
import java.util.List;

public class EventImpl extends NoticeImpl implements BasicBbsif {

	String startday;
	String endDay;
	String dDay;

	@Override
	public void getBbsList(int pageSize, int pageNo, String searchCategory, String searchWord) {
		String[][] arr = { 
				{ "1", "운동", "런닝", "2024-09-01", "2024-09-02", "2024-09-10" },
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

		List<String[]> List = new ArrayList<>();

	    for (String[] item : arr) {
	        if (searchWord == null || searchWord.isEmpty()) {
	        	List.add(item);
	        } else if ("title".equals(searchCategory) && item[1].contains(searchWord)) {
	        	List.add(item);
	        } else if ("content".equals(searchCategory) && item[2].contains(searchWord)) {
	        	List.add(item);
	        }
	    }

	    // 필터링된 결과가 없으면 메시지를 출력하고 종료
	    if (List.isEmpty()) {
	        System.out.println("검색된 내용이 없습니다.");
	        return;
	    }

	    System.out.println("----------------------------이벤트 리스트-----------------------------");
	    System.out.println("글번호    이벤트제목  내용\t  시작일\t\t  종료일\t\t  추첨일");

	    int totalItems = List.size();
	    int totalPages = (int) Math.ceil((double) totalItems / pageSize);

	    // 현재 페이지 번호가 범위를 벗어나지 않도록 보정
	    if (pageNo > totalPages) pageNo = totalPages;
	    if (pageNo < 1) pageNo = 1;

	    int start = (pageNo - 1) * pageSize;
	    int end = Math.min(start + pageSize, totalItems);

	    for (int i = start; i < end; i++) {
	        String[] item = List.get(i);
	        for (String field : item) {
	            System.out.print(field + "\t");
	        }
	        System.out.println();
	    }

	    // 페이지 네비게이션 출력
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
	    System.out.println("---------------------------------------------------------------------");
	    System.out.println("PageSize : " + pageSize + "  " + "pageNo : " + pageNo + "  " + "searchCategory : " + searchCategory + "  " + "searchWord :" + searchWord );
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
