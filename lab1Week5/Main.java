package lab1week5;

public class Main {

    public static void main(String[] args) {
        Package p1 = new Package(
                "Ahmet Yılmaz",
                "Atatürk Cad. No:15",
                "Ankara",
                "Türkiye",
                6100,
                "Mehmet Kaya",
                "Bagdat Cad. No:42",
                "İstanbul",
                "Türkiye",
                34710,
                10,
                2.5);

        Package p2 = new TwoDayPackage(
                "Zeynep Demir",
                "Istasyon Sok. No:8",
                "Izmir", "Turkiye",
                35220, "Ayse Sahin",
                "Cumhuriyet Meydani No:3",
                "Bursa",
                "Turkiye",
                16050,
                10.0,
                2.5,
                2.5);

        Package p3 = new OvernightDayPackage(
                "Furkan Karabulut",
                "Kurultay Mah. Tohma Çayı Cad. No:6/1",
                "Sivas",
                "Türkiye",
                58800,
                "Hasan Şahin",
                "Pınarönü Mah. No:31",
                "Hatay",
                "Türkiye",
                31000,
                10.0,
                2.5,
                3.0);
        
        p1.print();
        p2.print();
        p3.print();
    }

}
