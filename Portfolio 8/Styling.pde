import java.util.HashMap;
String ipsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. \nPraesent pretium erat lorem, sit amet euismod diam pulvinar sed. \nPraesent luctus tincidunt dolor in vulputate. \nSuspendisse ut nibh quis dolor vulputate mattis id et tellus. \nNunc eu nisl libero. Ut est velit, tincidunt at pulvinar quis, venenatis sit amet nulla. \nVestibulum maximus nisl vel mi tincidunt, vel posuere erat dapibus. \nVivamus dictum urna sit amet urna rutrum, ut efficitur nibh luctus. Fusce vel ex mauris. \nMaecenas luctus euismod enim, congue sagittis leo condimentum at. \nDonec tempus metus sed risus venenatis sagittis.";
String[] styleNames = {"dark", "light", "red", "blue"};
StyleCollection styles;
Style currentStyle;

// Different Button styles
Style d;
Style l;
Style r;
Style b;

Button button[];


public void setup() {
  size(800, 600);
  setupStyles(1);
  button = new Button[4];
}

public void draw() {
  background(currentStyle.getBG());
  fill(currentStyle.getStroke());
  textSize(currentStyle.getTSize());
  textAlign(CORNER);
  text(ipsum, 50, 100);
  setupButtons();
}

public void setupStyles(int h) {
  styles = new StyleCollection();
  Style dark = new Style(styleNames[0], color(0, 0, 0), color(255,255,255), color(0,0,0), 20);
  styles.addStyles(styleNames[0], dark);
  Style light = new Style(styleNames[1], color(255, 255, 255), 0, color(255,255,255), 20);
  styles.addStyles(styleNames[0], light);
  Style red = new Style(styleNames[2], color(255,216,216), color(148,19,19), color(255,216,216), 20);
  styles.addStyles(styleNames[0], red);
  Style blue = new Style(styleNames[3], color(216,216,255), color(69,69,176), color(216,216,255), 20);
  styles.addStyles(styleNames[0], blue);
  
  d = dark;
  l = light;
  r = red;
  b = blue;

  switch (h){
  case 1:
    currentStyle = dark;
    break;
  case 2:
    currentStyle = light;
    break;
  case 3:
    currentStyle = red;
    break;
  case 4:
    currentStyle = blue;
    break;
  }
}

public void setupButtons() {
  int x = -15;
  for (int i = 0; i < 4; i++) {
    button[i] = new Button(x = x + 150, 500, 100, 50);
    button[i].setText(styleNames[i]);
    button[i].display(i);
  }
}

void mousePressed() {
  for (int i = 0; i < 4; i++) {
    if (button[i].isInside(mouseX, mouseY)) {
      String t = button[i].getText();
      switch(t){
      case "dark":
        setupStyles(1);
        break;
      case "light":
        setupStyles(2);
        break;
      case "red":
        setupStyles(3);
        break;
      case "blue":
        setupStyles(4);
        break;
      }
    }
  }
}
