public class Style{
  private int fillColour;
  private int strokeColour;
  private int bgColour;
  private int textSize;
  private String name;
  
  public Style(String label, int bgColour, int stroke, int fill, int tSize){
    this.fillColour = fill;
    this.strokeColour = stroke;
    this.bgColour = bgColour;
    this.textSize = tSize;
    this.name = label;
  }
  
  public String getName(){
    return name;
  }
  
  public int getFill(){
    return fillColour;
  }
  
  public int getStroke(){
    return strokeColour;
  }
  
  public int getTSize(){
    return textSize;
  }
  
  public int getBG(){
    return bgColour;
  }
}
