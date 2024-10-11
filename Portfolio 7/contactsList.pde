import java.util.ArrayList;
import java.util.Scanner;

ArrayList<Contact> contacts;
String filename;
Scanner in;
int index = 1;
Button previous;
Button forward;

void setup() {
  size(1200, 750);
  previous = new Button(100, 500, 200, 175, "Previous");
  forward = new Button(width-300, 500, 200, 175, "Forward");
  // create the empty list that will hold all the data items
  contacts = new ArrayList<Contact>();
  // initialise the input file name
  filename = sketchPath() + "/Contacts.csv";
  // get a scanner to read from the input file
  in = InputReader.getScanner(filename);
  // now read the entire data file into our list
  readList();
}

void draw() {
  background(255);
  // get the data item from this index in the list
  Contact contact = contacts.get(index);

  // build the text for the label
  String list = "Name: " + contact.getfName() + " " + contact.getlName() + "\n" + "Email: " + contact.getEmail() + "\n" + "Phone Number: " + contact.getNumber();
  // Adds the text
  fill(0);
  textSize(50);
  textAlign(CENTER);
  text(list, 600, 150);

  // Make the buttons
  previous.display();
  forward.display();
}

void readList() {
  // while there is more data to read
  while (in.hasNext()) {
    // read the next line of data
    String line = in.nextLine();
    // split the line into individual fields
    String[] parts = line.split(",");
    // get the name of this data item
    String fname = parts[0];
    String lname = parts[1];
    String email = parts[2];
    String number = parts[3];
    // construct a DataItem object to hold these values
    Contact contact = new Contact(fname, lname, email, number);
    // add this data item to our list of data items
    contacts.add(contact);
  }
}

void mousePressed() {
  if (previous.isInside(mouseX, mouseY)) {
    if (index > 1) {
      index--;
    }
  }

  if (forward.isInside(mouseX, mouseY)) {
    if (index < contacts.size()-1) {
      index++;
    }
  }
}
