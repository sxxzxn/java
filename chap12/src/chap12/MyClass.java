package chap12;

public class MyClass<T> {
// 생성한 쪽에서 T 지정
	private T t;
	public T get() {
		return this.t = t;
	}
	
	public void set(T t) {
		this.t = t;
	}
}
