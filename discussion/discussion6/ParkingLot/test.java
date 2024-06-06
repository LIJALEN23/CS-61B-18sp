package ParkingLot;

public class test {
    public static void main(String[] args) {
        ParkingLot parkingLotA = new ParkingLot(5, 5, 5);
        Car benz = new Car(ParkingSpaceType.COMPACT);
        Car bmw = new Car(ParkingSpaceType.COMPACT);
        Car su7 = new Car(ParkingSpaceType.REGULAR);
        Car track = new Car(ParkingSpaceType.REGULAR);
        Car special = new Car(ParkingSpaceType.HANDICAPPED);

        parkingLotA.parkCar(benz);
        parkingLotA.parkCar(bmw);
        parkingLotA.parkCar(special);
        parkingLotA.parkCar(su7);
        parkingLotA.parkCar(track);

        parkingLotA.freeSpace(6);

    }
}
