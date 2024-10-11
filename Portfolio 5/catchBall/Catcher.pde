class Catcher{
  // Catcher variables
  private float catcherX; // x coordinate of the catcher
  private float catcherY; // y coordinate of the catcher
  private float catcherWidth; // width of the catcher
  private float catcherSpeed; // speed of the catcher
  private float catcherHeight; // height of the catcher
  private char catcherControl; // key pressed to control the catcher
  private int catcherScore;  // the number of balls caught
  
  public Catcher(float cSpeed, float cWidth, float cHeight){
    catcherX = width/2; // catcher starts in the center
    catcherY = height - 100; // just up from the bottom
    catcherSpeed = cSpeed; // slow speed of the catcher (1)
    catcherWidth = cWidth; // width of the catcher (140)
    catcherHeight = cHeight; // height of the catcher (20)
    catcherScore = 0; // number of balls caught
  }

public void display() {
  fill(255, 0, 0);
  rect(catcherX, catcherY, catcherWidth, catcherHeight);
}

public void move() {
  if (catcherControl == 'x') { // x moves right
    catcherX = catcherX + catcherSpeed;
  } else if (catcherControl == 'z') { // z moves left
    catcherX = catcherX - catcherSpeed;
  }
}

public void checkCaught() {
  if (ball.getX() > (catcherX - catcherWidth/2) && 
    ball.getX() < (catcherX + catcherWidth/2) &&
    ball.getY() + ball.getWidth()/2 >= catcherY - catcherHeight/2 &&
    ball.getY() - ball.getWidth()/2 <= catcherY + catcherHeight/2) {
    increaseScore();
    ball.resetBall();
  }
  if (ball2.getX() > (catcherX - catcherWidth/2) && 
    ball2.getX() < (catcherX + catcherWidth/2) &&
    ball2.getY() + ball2.getWidth()/2 >= catcherY - catcherHeight/2 &&
    ball2.getY() - ball2.getWidth()/2 <= catcherY + catcherHeight/2) {
    increaseScore();
    ball2.resetBall();
  }
}

public void increaseScore() {
  catcherScore ++;
}

public int getScore(){
  return catcherScore;
}

public void setCatcherControl(char k){
  catcherControl = k;
}

}
