package ch09.test.test4;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car();
		Car.Tire tire = car.new Tire();
		Car.Engine engine = new Car.Engine();
	}

}
