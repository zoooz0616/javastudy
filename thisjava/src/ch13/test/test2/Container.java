package ch13.test.test2;

public class Container<T> {
	T t;
	
	public void set(T t) {
		this.t =t;
	}
	
	public T get() {
		return t;
	}
}
