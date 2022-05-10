package object_oriented_design.ParkingLot;

public class Question {
	
	public static void main(String[] args) {
		ParkingLot lot = new ParkingLot();
		
		Vehicle v = null;
		while (v == null || lot.parkVehicle(v)) {
			lot.print();
			int r = randomIntInRange(0, 10);
			if (r < 2) {
				v = new Bus();
			} else if (r < 4) {
				v = new Motorcycle();
			} else {
				v = new Car();
			}
			System.out.print("\nParking a ");
			v.print();
			System.out.println("");
		}
		System.out.println("Parking Failed. Final state: ");
		lot.print();
	}
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

}
