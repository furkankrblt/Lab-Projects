package lab1week6;

public class EconomyRide extends Ride {

    private double pricePerMinute;

    public EconomyRide(double pricePerMinute, String passengerName, String pickup, String destination, double distanceKm, int durationMin, double pricePerKm) {
        super(passengerName, pickup, destination, distanceKm, durationMin, pricePerKm);
        this.pricePerMinute = pricePerMinute;
    }

    @Override
    public double calculateFare() {
        if (super.calculateFare() + getDurationMin() * pricePerMinute < 50) {
            return 50;
        } else {
            return super.calculateFare() + getDurationMin() * pricePerMinute;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Price Per Minute: " + pricePerMinute + " TL\n"
                + "Total Fare: " + calculateFare() + " TL";
    }
}
