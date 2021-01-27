package Session1;

public class Activity1_1 {

	public static void main(String[] args) {
		Activity1_1_1 car = new Activity1_1_1();

		car.make = 2014;
		car.color = "Black";
		car.transmission = "Manual";

		car.displayCharacteristics();
		car.accelarate();
		car.brake();
	}

}
