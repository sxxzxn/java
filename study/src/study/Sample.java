package study;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		NoticeImpl bbs = new NoticeImpl();
//		bbs.getBbsList(0, 0, null, null);
//		bbs.view(0);
		//일반 게시판
		//일반 게시글
		
		
		EventImpl ev = new EventImpl();
		ev.getBbsList(10, 10, null, null);
		//이벤트게시판+ 검색 + 페이징

	}

}
