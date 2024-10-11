import java.util.HashMap;

public class PhoneMap {
  private HashMap<String, Phone> phoneMap;

  public PhoneMap() {
    this.phoneMap = new HashMap<>();
  }

  public void addPhone(Phone phone) {
    // Concatenate brand and model name to create a key
    String key = phone.getBrand() + phone.getModel();
    phoneMap.put(key, phone);
  }

  public Phone getPhone(String brand, String model) {
    // Concatenate brand and model name to retrieve the key
    String key = brand + model;
    return phoneMap.get(key);
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    for (String key : phoneMap.keySet()) {
      Phone thisPhone = phoneMap.get(key);
      // Update result for this phone
      result.append(thisPhone).append("\n");
    }
    return result.toString();
  }

  public void displayAllPhones() {
    System.out.println("All Phones:");
    for (Phone phone : phoneMap.values()) {
      System.out.println(phone); // Assuming Phone class has a meaningful toString() method
    }
  }
}
