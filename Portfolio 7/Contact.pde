public class Contact {
  private String firstName;
  private String lastName;
  private String email;
  private String number;

  public Contact(String fName, String lName, String mail, String phoneNum){
    firstName = fName;
    lastName = lName;
    email = mail;
    number = phoneNum;
  }

  public String getfName() {
    return firstName;
  }

  public String getlName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }
  
  public String getNumber(){
    return number;
  }
}
