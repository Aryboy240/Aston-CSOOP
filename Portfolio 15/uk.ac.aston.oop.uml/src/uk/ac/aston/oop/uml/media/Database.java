package uk.ac.aston.oop.uml.media;

import java.util.ArrayList;

public class Database {
	
	private ArrayList<Item> items;

	// Constructor
	public Database(){
		this.items = new ArrayList<>();
	}

	public static void main(String[] args){
		Database database = new Database();

        Video video = new Video("The best movie ever", "Aryan Kora", 120);
        CD cd = new CD("The best movie ever (NOW ON CD)", "Aryan Kora", 12, 60);

        database.addItem(video);
        database.addItem(cd);

        database.print();
	}

	public void addItem(Item i){
		items.add(i);
	}

	public void print(){
		for (Item item : items) {
            System.out.println(item.toString());
		}
	}
		
}
