package chap12;

public class Goods2 <T extends Fruit> {
	private T t;
	public T get () {
		return this.t;
	}
	public void set (T t) {
		this.t = t;
	}

}
