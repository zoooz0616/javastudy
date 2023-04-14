package ch08.sec12;

import ch08.sec11.exam02.Bus;
import ch08.sec11.exam02.Taxi;
import ch08.sec11.exam02.Vehicle;

public class InstanceofExample {

	public static void main(String[] args) {
		Taxi taxi = new Taxi();
		Bus bus = new Bus();
		
		ride(taxi);
		System.out.println();
		ride(bus);
	}
	
	public static void ride(Vehicle vehicle) {
		if (vehicle instanceof Bus) {
			Bus bus = (Bus) vehicle;
			bus.checkFare();
		}
		vehicle.run();
	}
	
	

}
