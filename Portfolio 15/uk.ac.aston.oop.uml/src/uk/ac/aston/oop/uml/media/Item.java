package uk.ac.aston.oop.uml.media;

public abstract class Item {
	
	private String title;
    private int playMinutes;
    private String comment = "";
    private boolean owned;

    public Item(String title, int playMinutes) {
        this.title = title;
        this.playMinutes = playMinutes;
    }
	
	public String getComment(){
		return this.comment;
	}
	
	public void setComment(String c){
		this.comment = c;
	}
	
	public boolean isOwned(){
		return this.owned;
	}
	
	public void setOwned(boolean o){
		this.owned = o;
	}
	
	public int getPlayMinutes(){
		return playMinutes;
	}
	
	public String toString() {
		if (owned)
		{
			return "*" + title + ":" + playMinutes + "-" + comment;
		}
		else
		{
			return title + ":" + playMinutes + "-" + comment;
		}
	}
}
