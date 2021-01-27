package Session1;

public class Activity1_1_1 {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;

	Activity1_1_1() {
		tyres = 4;
		doors = 4;
	}

	public void displayCharacteristics() {
		System.out.println("The Color of the car is " + color);
		System.out.println("The transmission type is " + transmission);
		System.out.println("Make of the car is " + make);
		System.out.println("Number of tyres are " + tyres);
		System.out.println("Number of doors are " + doors);
	}

	public void accelarate() {
		System.out.println("Car is moving forward.");
	}

	public void brake() {
		System.out.println("Car has stopped.");
	}

}