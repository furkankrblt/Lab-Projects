package lab1week6;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Ride> rides = new ArrayList<>();

        System.out.println("WARNINGS");

        Ride r1 = new Ride("Muhammed", "Tokat", "Artvin", 10.0, 10, 10.0);
        Ride r2 = new Ride("Invalid User", "A", "B", -5.0, -10, -20.0);

        EconomyRide r3 = new EconomyRide(4.0, "Furkan", "Sivas", "Ankara", 30.0, 20, 10.0);
        EconomyRide r4 = new EconomyRide(2.0, "Ahmet", "Campus", "Dorm", 1.0, 2, 10.0);

        PremiumRide r5 = new PremiumRide(50.0, 2, "Hayri", "Kayseri", "Kırıkkale", 50.0, 10, 10.0);
        PremiumRide r6 = new PremiumRide(50.0, 5, "Invalid Premium", "X", "Y", 20.0, 15, 10.0);

        SharedRide r7 = new SharedRide(2, 2.0, "Kerem", "Sivas", "Ankara", 30.0, 20, 10.0);
        SharedRide r8 = new SharedRide(10, 2.0, "Berkay", "Nigde", "Kayseri", 30.0, 20, 10.0);

        rides.add(r1);
        rides.add(r2);
        rides.add(r3);
        rides.add(r4);
        rides.add(r5);
        rides.add(r6);
        rides.add(r7);
        rides.add(r8);

        System.out.println("\n=== ALL RIDE DETAILS AND FARES ===\n");

        for (Ride ride : rides) {
            System.out.println(ride.toString());
            System.out.println();
        }
    }
}
