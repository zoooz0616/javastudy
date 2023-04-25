package ch15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
	public static void main(String[] args) {
		
		TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());
		treeSet.add(new Fruit("포도",3000));
		treeSet.add(new Fruit("사과", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		for(Fruit f:treeSet) {
			System.out.println(f);
		}
	}
}
