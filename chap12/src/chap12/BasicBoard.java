package chap12;

public class BasicBoard<T>  { // board 인터페이스 상속받기

	public T[] getList() {
		T[] bbsList = null;
		for (int i=0; i<100; i++) {
			bbsList[0] = (T) "";
		}
		return bbsList;
	}
}
