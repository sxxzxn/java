package study;

public class NoticeImpl implements BasicBbsif {

	int pageSize;
	int pageNo;
	String searchCategory;
	String searchWord;
	String name;
	String pwd;
	String userId;
	String email;
	String title;
	String content;
	String regDate;
	String displayDate;
	int idx;

	@Override
	public void getBbsList(int pageSize, int pageNo, String searchCategory, String searchWord) {
		String[][] arr = { { "1", "공지사항1", "출퇴근찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "2", "공지사항2", "출근1찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "3", "공지사항3", "출근2찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "4", "공지사항4", "출근3찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "5", "공지사항5", "출근4찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "6", "공지사항6", "출근5찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "7", "공지사항7", "출근6찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "8", "공지사항8", "출근7찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "9", "공지사항9", "출근찍8기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "10", "공지사항10", "출근찍1기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "11", "공지사항11", "출근찍기2", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "12", "공지사항12", "출근찍기1", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "13", "공지사항13", "출근찍기1", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" },
				{ "14", "공지사항14", "출근찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" }

		};
		System.out.println("글번호 \t 제목 \t 내용 \t 아이디 \t 이름  \t 이메일 \t\t 등록일 \t\t 수정일");
		for (String[] arrItem : arr) { // 변수 : 배열 -> 변수에 배열을 담아서
			for (String list : arrItem) { // 여기선 위에 변수가 배열로 들어간다!
				System.out.print(list + "\t");
			}
			System.out.println(" "); // 게시글 하나 출력 후 줄변경
		}
		// 배열로 만들어서 넣고
		// 제목 부분 출력
		// for 문 사용
		// 출력
		// 끝단
	}

	@Override
	public void regist(String[] arrInput) {
		// TODO Auto-generated method stub
		// 배열로 만들어서
		// for 문으로 넣어주고
		// 출력
	}

	@Override
	public void view(int bbsIdx) {
		// TODO Auto-generated method stub
		// 배열로 만들고
		String [] arr = { "1", "공지사항1", "출퇴근찍기", "user1", "수진", "ssj@naver.com", "2024-09-01", "2024-09-02" };
		for(String content : arr) {
			System.out.print(content);
		}
		// for문으로 돌면서
		// 출력
	}

	@Override
	public void delete(int bbsIdx) {
		System.out.println("게시글 삭제 : " + bbsIdx);

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSearchCategory() {
		return searchCategory;
	}

	public void setSearchCategory(String searchCategory) {
		this.searchCategory = searchCategory;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getDisplayDate() {
		return displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

}
