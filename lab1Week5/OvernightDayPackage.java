package lab1week5;

public class OvernightDayPackage extends Package {

    private double additionalFee;

    public OvernightDayPackage(String nameSender, String addressSender, String citySender, String stateSender, int zipCodeSender, String nameReceiver, String addressReceiver, String cityReceiver, String stateReceiver, int zipCodeReceiver, double packageWeight, double costPerOunce, double additionalFee) {
        super(nameSender, addressSender, citySender, stateSender, zipCodeSender, nameReceiver, addressReceiver, cityReceiver, stateReceiver, zipCodeReceiver, packageWeight, costPerOunce);
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + (getPackageWeight() * additionalFee);
    }

    @Override
    public void print() {
        System.out.println("==========================================");
        System.out.println("         *** OVERNIGHT PACKAGE ***        ");
        System.out.println("==========================================");
        System.out.println("Sender name        : " + getNameSender());
        System.out.println("Sender address     : " + getAddressSender());
        System.out.println("Sender city        : " + getCitySender());
        System.out.println("Sender state       : " + getStateSender());
        System.out.println("Sender zip code    : " + getZipCodeSender());
        System.out.println("------------------------------------------");
        System.out.println("Recipient name     : " + getNameReceiver());
        System.out.println("Recipient address  : " + getAddressReceiver());
        System.out.println("Recipient city     : " + getCityReceiver());
        System.out.println("Recipient state    : " + getStateReceiver());
        System.out.println("Recipient zip code : " + getZipCodeReceiver());
        System.out.println("------------------------------------------");
        System.out.println("Weight             : " + getPackageWeight());
        System.out.println("Per Ounce          : " + getCostPerOunce());
        System.out.println("Additional Fee     : " + additionalFee);
        System.out.println("Calculate cost     : " + calculateCost());
        System.out.println("==========================================\n");
    }
}
