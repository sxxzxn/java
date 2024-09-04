package chap10;

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
		// TODO Auto-generated method stub
		String[] arr = { this.title, this.content, this.regDate, this.displayDate};
		System.out.println("-------------------게시글 리스트------------------");
		System.out.println("글제목\t 글내용\t   작성일\t           등록일\t");
		for(String arrItem : arr) {
			System.out.print(arrItem+"\t");
		}
		System.out.println("");
		System.out.println("----------------------------------------------- ");

		//System.out.println("PageSize : "+pageSize+ "pageNo :"+ pageNo +"searchCategory :"+searchCategory+"searchWord :"+searchWord );
	}

	@Override
	public void regist(String[] arrInput) {
		// TODO Auto-generated method stub
		for(String item : arrInput) {
			System.out.println("arrInput : "+item);
		}
		System.out.println("공지사항 등록");

	}

	@Override
	public void view(int bbsIdx) {
		System.out.println("-----------------게시글 조회---------------");
		System.out.println("글번호\t 글내용\t");
		String[] viewarr = {String.valueOf(this.idx), this.content}; 
		for(String viewItem : viewarr) {
			System.out.print(viewItem+"    \t");
		}
		System.out.println("");
		System.out.println("------------------------------------------- ");
	}

	@Override
	public void delete(int bbsIdx) {
		System.out.println("게시글 삭제 : "+bbsIdx);
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
