import java.util.Scanner;

private String filename;
private PhoneList allPhones;
private PhoneMap myPhoneMap;
private Scanner in;

void setup() {
  filename = sketchPath() + "/phoneData.csv";
  allPhones = new PhoneList();
  myPhoneMap = new PhoneMap();
  in = InputReader.getScanner(filename);
  readData();
  
  // ArrayList Sort
  allPhones.sort();
  
  // ArrayList list
  println(allPhones.toString());
  
  println("---------------------------------------------");
  
  // ArrayList searches
  Phone iPhone = allPhones.findByName("Apple", "iPhone 7 Plus");
  println("\nThe iPhone you searched for:");
  println(iPhone);
  
  Phone test = allPhones.findByName("test", "test");
  println("\nTest search:");
  println(test);
  
  println("\n---------------------------------------------");
  
  // ArrayList list sort (For phones that cost > 600 euros)
  println("\nPhones that cost over 600 euros:\n");
  println(allPhones.expensive(600));
  
  println("\n---------------------------------------------");

  // HashMap list
  println("\nAll the phones from the HashMap:\n");
  println(myPhoneMap.toString());
  
  println("\n---------------------------------------------");
  
  // HashMap searchs
  Phone samsung = allPhones.findByName("Samsung", "Galaxy C9 Pro");
  println("\nThe samsung phone you searched for:");
  println(samsung);
  
  Phone hashTest = allPhones.findByName("hashTest", "hashTest");
  println("\nhashTest search:");
  println(hashTest);
}

void readData() {
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
  println("Total number of movies is " + allPhones.getNumberOfPhones());
  println("---------------------------------------------");
}
