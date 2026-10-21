package lab1week5;

public class TwoDayPackage extends Package {

    private double flatFee;

    public TwoDayPackage(String nameSender, String addressSender, String citySender, String stateSender, int zipCodeSender, String nameReceiver, String addressReceiver, String cityReceiver, String stateReceiver, int zipCodeReceiver, double packageWeight, double costPerOunce, double flatFee) {
        super(nameSender, addressSender, citySender, stateSender, zipCodeSender, nameReceiver, addressReceiver, cityReceiver, stateReceiver, zipCodeReceiver, packageWeight, costPerOunce);
        this.flatFee = flatFee;
    }

    @Override
    public double calculateCost() {
        return super.calculateCost() + flatFee;
    }

    @Override
    public void print() {
        System.out.println("==========================================");
        System.out.println("          *** TWO DAY PACKAGE ***         ");
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
        System.out.println("Flat Fee           : " + flatFee);
        System.out.println("Calculate cost     : " + calculateCost());
        System.out.println("==========================================\n");
    }
}
