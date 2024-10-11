import java.util.Scanner;

public class phoneMain {
  private static String filename;
  private static PhoneList allPhones;
  private static PhoneMap myPhoneMap;
  private static Scanner in;

  public static void main(String[] args) {
    filename = (System.getProperty("user.dir")) + "\\phoneData.csv";
    allPhones = new PhoneList();
    myPhoneMap = new PhoneMap();
    in = InputReader.getScanner(filename);
    Scanner userInput = new Scanner(System.in);
    readData();

    // ArrayList Sort
    allPhones.sort();

    // ArrayList list
    System.out.println(allPhones.toString());

    System.out.println("---------------------------------------------");
    // ArrayList searches
    Phone iPhone = allPhones.findByName("Apple", "iPhone 7 Plus");
    System.out.println("\nThe iPhone you searched for:");
    System.out.println(iPhone);

    Phone test = allPhones.findByName("test", "test");
    System.out.println("\nTest search:");
    System.out.println(test);

    System.out.println("\n---------------------------------------------");

    // ArrayList list sort (For phones that cost > 600 euros)
    System.out.println("\nPhones that cost over 600 euros:\n");
    System.out.println(allPhones.expensive(600));

    System.out.println("\n---------------------------------------------");

    // ArrayList list filter for certain price range
    System.out.println("Please enter the lower bound: ");
    String lower = userInput.nextLine();
    System.out.println("Please enter the upper bound: ");
    String upper = userInput.nextLine();
    userInput.close();

    System.out.println("\n---------------------------------------------");

    System.out.println(
        "\nPhones that cost between " + Integer.parseInt(lower) + " - " + Integer.parseInt(upper) + " euros:\n");
    System.out.println(allPhones.findPhonesInPriceRange(Integer.parseInt(lower), Integer.parseInt(upper)));

    /*
     * 
     * HashMap list
     * 
     * println("\nAll the phones from the HashMap:\n");
     * println(myPhoneMap.toString());
     * 
     * println("\n---------------------------------------------");
     * 
     * // HashMap searchs
     * Phone samsung = allPhones.findByName("Samsung", "Galaxy C9 Pro");
     * println("\nThe samsung phone you searched for:");
     * println(samsung);
     * 
     * Phone hashTest = allPhones.findByName("hashTest", "hashTest");
     * println("\nhashTest search:");
     * println(hashTest);
     * 
     */
  }

  static void readData() {
    String header = in.nextLine();
    while (in.hasNext()) {
      String csv = in.nextLine();
      String[] data = csv.split(",");
      Phone phone = new Phone(data[0]);
      phone.setModel(data[1]);
      phone.setAnnounced(data[8]);
      phone.setWeight_g(Float.parseFloat(data[11]));
      phone.setInternal_memory(data[21]);
      phone.setApprox_price_EUR(Integer.parseInt(data[36]));
      allPhones.addPhone(phone);
      myPhoneMap.addPhone(phone);
    }
    System.out.println("Total number of phones: " + allPhones.getNumberOfPhones());
    System.out.println("---------------------------------------------");
  }

}