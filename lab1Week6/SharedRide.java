package lab1week6;

public class SharedRide extends EconomyRide {

    private int passengerCount;

    public SharedRide(int passengerCount, double pricePerMinute, String passengerName, String pickup, String destination, double distanceKm, int durationMin, double pricePerKm) {
        super(pricePerMinute, passengerName, pickup, destination, distanceKm, durationMin, pricePerKm);

        if (passengerCount < 1 || passengerCount > 4) {
            System.out.println(getPassengerName() + " --> Count must be between 1 and 4. It is set to 1");
            this.passengerCount = 1;
        } else {
            this.passengerCount = passengerCount;
        }
    }

    @Override
    public double calculateFare() {
        return (super.calculateFare() / passengerCount) * 1.10;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Passenger Count: " + passengerCount + "\n"
                + "Total Fare (Per Person): " + calculateFare() + " TL";
    }

}
