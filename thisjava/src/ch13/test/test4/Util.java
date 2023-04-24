package ch13.test.test4;

public class Util{
	public static <K,V>V getValue(Pair<K,V> p, K k) {
		if (p.getKey()==k) {
			return p.getValue();
			
		}else {
			return null;
		}
		
	}
}
