public class Button {
  private int x;
  private int y;
  private int w;
  private int h;
  private String text;

  public Button(int xp, int yp, int wp, int hp, String insideText){
    x = xp;
    y = yp;
    w = wp;
    h = hp;
    text = insideText;
  }
  
  public void display(){
    fill(255,0,0);
    rect(x,y,w,h);
    textAlign(CENTER);
    fill(0);
    textSize(40);
    text(text,x+w/2,(y+(h/2))+10);
  }
  
  public boolean isInside(float rx, float ry){
    if ((rx < (x+w) && (rx > x)) && ((ry < (y+h)) && (ry > y))){
      return true;
    }
    else{
      return false;
    }
  }
}
