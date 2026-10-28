package lab1week6;

public class PremiumRide extends Ride {

    private double comfortFee;
    private double surgeMultiplier;

    public PremiumRide(double comfortFee, int surgeMultiplier, String passengerName, String pickup, String destination, double distanceKm, int durationMin, double pricePerKm) {
        super(passengerName, pickup, destination, distanceKm, durationMin, pricePerKm);
        this.comfortFee = comfortFee;

        if (surgeMultiplier < 1.0 || surgeMultiplier > 3.0) {
            System.out.println(passengerName + " --> The multiplier must be between 1.0 and 3.0! It is set to 1.");
            this.surgeMultiplier = 1.0;
        } else {
            this.surgeMultiplier = surgeMultiplier;
        }
    }

    @Override
    public double calculateFare() {
        return (super.calculateFare() + comfortFee) * surgeMultiplier;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Comfort Fee: " + comfortFee + " TL\n"
                + "Surge Multiplier: " + surgeMultiplier + "\n"
                + "Total Fare: " + calculateFare() + " TL";
    }

}
