class Button {
  float x;
  float y;
  float w;
  float h;
  String label;
  
  public Button(float xp, float yp, float wd, float ht) {
    x = xp;
    y = yp;
    w = wd;
    h = ht;
  }
  
  public boolean isInside(float mx, float my) {
    if (mx >= x && mx <= x + w && my >= y && my <= y + h) {
      return true;
    } else {
      return false;
    }
  }
  
  public void setText(String t) {
    label = t;
  }
  
  public void display(int i) {
    textAlign(CENTER);
    switch(i) {
    case 0:
      fill(d.getFill());
      stroke(d.getStroke());
      rect(x, y, w, h);
      fill(d.getStroke());
      text(label, x+50, y+30);
      break;
    case 1:
      fill(l.getFill());
      stroke(l.getStroke());
      rect(x, y, w, h);
      fill(l.getStroke());
      text(label, x+50, y+30);
      break;
    case 2:
      fill(r.getFill());
      stroke(r.getStroke());
      rect(x, y, w, h);
      fill(r.getStroke());
      text(label, x+50, y+30);
      break;
    case 3:
      fill(b.getFill());
      stroke(b.getStroke());
      rect(x, y, w, h);
      fill(b.getStroke());
      text(label, x+50, y+30);
      break;
    }
  }
  
  public String getText(){
    return label;
  }
}
