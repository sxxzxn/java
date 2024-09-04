package chap10;

public interface BasicBbsif {
	public abstract void getBbsList(int pageSize, int pageNo, String searchCategory, String searchWord);
	public abstract void regist(String [] arrInput);
	public abstract void view(int bbsIdx);
	public abstract void delete(int bbsIdx);

}
