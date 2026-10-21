package lab1week5;

public class Package {
    private String nameSender;
    private String addressSender;
    private String citySender;
    private String stateSender;
    private int zipCodeSender;
    private String nameReceiver;
    private String addressReceiver;
    private String cityReceiver;
    private String stateReceiver;
    private int zipCodeReceiver;
    
    private double packageWeight;
    private double costPerOunce;

    public Package(String nameSender, String addressSender, String citySender, String stateSender, int zipCodeSender, String nameReceiver, String addressReceiver, String cityReceiver, String stateReceiver, int zipCodeReceiver, double packageWeight, double costPerOunce) {
        this.nameSender = nameSender;
        this.addressSender = addressSender;
        this.citySender = citySender;
        this.stateSender = stateSender;
        this.zipCodeSender = zipCodeSender;
        this.nameReceiver = nameReceiver;
        this.addressReceiver = addressReceiver;
        this.cityReceiver = cityReceiver;
        this.stateReceiver = stateReceiver;
        this.zipCodeReceiver = zipCodeReceiver;
        this.packageWeight = packageWeight;
        this.costPerOunce = costPerOunce;
    }
    
    public double calculateCost() {
        return packageWeight * costPerOunce;
    }

    public String getNameSender() {
        return nameSender;
    }

    public String getAddressSender() {
        return addressSender;
    }

    public String getCitySender() {
        return citySender;
    }

    public String getStateSender() {
        return stateSender;
    }

    public int getZipCodeSender() {
        return zipCodeSender;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public String getCityReceiver() {
        return cityReceiver;
    }

    public String getStateReceiver() {
        return stateReceiver;
    }

    public int getZipCodeReceiver() {
        return zipCodeReceiver;
    }

    public double getPackageWeight() {
        return packageWeight;
    }

    public double getCostPerOunce() {
        return costPerOunce;
    }
    
    public void print() {
    System.out.println("==========================================");
    System.out.println("          *** STANDARD PACKAGE ***        ");
    System.out.println("==========================================");
    System.out.println("Sender name        : " + nameSender);
    System.out.println("Sender address     : " + addressSender);
    System.out.println("Sender city        : " + citySender);
    System.out.println("Sender state       : " + stateSender);
    System.out.println("Sender zip code    : " + zipCodeSender);
    System.out.println("------------------------------------------");
    System.out.println("Recipient name     : " + nameReceiver);
    System.out.println("Recipient address  : " + addressReceiver);
    System.out.println("Recipient city     : " + cityReceiver);
    System.out.println("Recipient state    : " + stateReceiver);
    System.out.println("Recipient zip code : " + zipCodeReceiver);
    System.out.println("------------------------------------------");
    System.out.println("Weight             : " + packageWeight);
    System.out.println("Per Ounce          : " + costPerOunce);
    System.out.println("Calculate cost     : " + calculateCost());
    System.out.println("==========================================\n");
}
    
}
