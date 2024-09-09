package chap12;

import java.util.ArrayList;
import java.util.List;

public class Goods<T> {

	private T t;
	
	public T get() {
		return this.t;
	}
	public void set(T t) {
		this.t = t;
	}
	
	
//	public List getList(T[] t) {
//		ArrayList<E> arrList = null;
//		
//		return arrList.add(t);
//	}
}
