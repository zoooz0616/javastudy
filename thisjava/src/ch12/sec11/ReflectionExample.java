package ch12.sec11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ReflectionExample {
	public static void main(String[] args) {
		Class clz =Car.class;
		System.out.println(clz);
		Constructor[] cons = clz.getDeclaredConstructors();
		for(Constructor con:cons) {
			System.out.println(con.getName());
		}
		
		Method[] methods = clz.getDeclaredMethods();
		for(Method method:methods) {
			System.out.println(method.getName());
		}
	}
}

@Data
@AllArgsConstructor
class Car{
	private String modelString;
	private String ownerString;
}