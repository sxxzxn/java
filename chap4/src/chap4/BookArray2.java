package chap4;

public class BookArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] libary = new Book[5];

		libary[0] = new Book("듄1", "수진");
		libary[1] = new Book("듄2", "하니");
		libary[2] = new Book("듄3", "코코");
		libary[3] = new Book("듄4", "몽글이");
		libary[4] = new Book("듄5", "ㅇ집");
	
	
		for(int i=0; i<libary.length; i++) {
			libary[i].showBookInfo();
		}
		for(int i=0; i<libary.length; i++) {
			System.out.println(libary[i]);
		}
	}
	

}
