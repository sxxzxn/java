package chap14;

public class MyRClass extends RuntimeException {
	MyRClass() {}
	MyRClass(String s) {
		super(s);
	}
	
	MyClass<Integer> mys = new MyClass<Integer>();
	MyClass2<String, Integer> mys2 = new MyClass2<String, Integer>();
	
	class MyClass<T>{
		private T t;
		public T get() {
			return this.t;
		}
		public void set (T t) {
			this.t=t;
		}
	}
	
	
	class MyClass2<K,V>{
		private K k1;
		private V v1;
		public void setKey(K k) {
			this.k1 = k;
		}
//		
//		public void setKey(V v) {
//			
//		}
		
	}
}
