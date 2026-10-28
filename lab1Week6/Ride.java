package lab1week6;

public class Ride {

    private String passengerName;
    private String pickup;
    private String destination;
    private double distanceKm;
    private int durationMin;
    private double pricePerKm;

    public Ride(String passengerName, String pickup, String destination, double distanceKm, int durationMin, double pricePerKm) {
        this.passengerName = passengerName;
        this.pickup = pickup;
        this.destination = destination;

        if (distanceKm < 0) {
            System.out.println("Distance must be positive; it is being set to 1!");
            this.distanceKm = 1;
        } else {
            this.distanceKm = distanceKm;
        }

        if (durationMin < 0) {
            System.out.println("Minute must be positive; it is being set to 1!");
            this.durationMin = 1;
        } else {
            this.durationMin = durationMin;
        }

        if (pricePerKm < 0) {
            System.out.println("Price Per km must be positive; it is being set to 1!");
            this.pricePerKm = 1;
        } else {
            this.pricePerKm = pricePerKm;
        }

    }

    public double calculateFare() {
        return distanceKm * pricePerKm;
    }

    @Override
    public String toString() {
        String details = "--- " + this.getClass().getSimpleName() + " DETAILS ---\n"
                + "Passenger Name: " + passengerName + "\n"
                + "Pickup: " + passengerName + "\n"
                + "Destination: " + destination + "\n"
                + "Distance: " + distanceKm + " km\n"
                + "Duration: " + durationMin + " min\n"
                + "Price Per Km: " + pricePerKm + " TL";

        if (this.getClass() == Ride.class) {
            details += "\nTotal Fare: " + calculateFare() + " TL";
        }

        return details;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getPickup() {
        return pickup;
    }

    public String getDestination() {
        return destination;
    }

    public double getDistanceKm() {
        return distanceKm;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public double getPricePerKm() {
        return pricePerKm;
    }

}
