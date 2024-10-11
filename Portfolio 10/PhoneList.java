import java.util.ArrayList;
import java.util.Collections;

public class PhoneList {

  private ArrayList<Phone> listOfPhones;

  public PhoneList() {
    listOfPhones = new ArrayList<Phone>();
  }

  public void addPhone(Phone phone) {
    listOfPhones.add(phone);
  }

  public int getNumberOfPhones() {
    return listOfPhones.size();
  }

  public void sort() {
    Collections.sort(listOfPhones);
  }

  public Phone findByName(String brand, String model) {
    for (int index = 0; index < listOfPhones.size(); index++) {
      Phone thisPhone = listOfPhones.get(index);
      if ((thisPhone.getBrand().equals(brand)) && ((thisPhone.getModel().equals(model)))) {
        return thisPhone;
      }
    }
    return null;
  }

  public PhoneList expensive(int price) {
    PhoneList list = new PhoneList();
    for (int index = 0; index < listOfPhones.size(); index++) {
      Phone thisPhone = listOfPhones.get(index);
      if (thisPhone.getApprox_price_EUR() > price) {
        list.addPhone(thisPhone);
      }
    }
    return list;
  }

  public String toString() {
    String result = "";
    for (int index = 0; index < listOfPhones.size(); index++) {
      Phone phone = listOfPhones.get(index);
      result = result + phone.toString();
      result = result + "\n";
    }
    return result;
  }

  public PhoneList findPhonesInPriceRange(int lower, int upper) {
    PhoneList list = new PhoneList();
    for (int index = 0; index < listOfPhones.size(); index++) {
      Phone thisPhone = listOfPhones.get(index);
      if ((thisPhone.getApprox_price_EUR() >= lower) && (thisPhone.getApprox_price_EUR() <= upper)) {
        list.addPhone(thisPhone);
      }
    }
    return list;
  }
}
