package uk.ac.aston.oop.uml.media;

public class Video extends Item {
	
	private String director;

    public Video(String title, String director, int playMinutes) {
        super(title, playMinutes);
        this.director = director;
    }
	
	public String getDirector() {
		return this.director;
	}
	
	@Override
    public String toString() {
        return "Director: " + director + "\n" + super.toString();
    }
}
