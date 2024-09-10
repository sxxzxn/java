package chap12;

public class Child2<T, V> extends Parent<T> {
	V v;
	public V getV() {
		return this.v;
	}
	public void setV(V v) {
		this.v = v;
	}
}
