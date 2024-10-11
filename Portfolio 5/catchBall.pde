Ball ball;
Ball ball2;
Catcher woweee;

void setup() {
  size(800, 600);
  rectMode(CENTER);
  ball = new Ball(5, 30);
  ball2 = new Ball(5, 30);
  woweee = new Catcher(10, 140, 20);
}

void draw() {
  background(0);
  showScore();  // display the score at the top of the screen
  woweee.display();  // call the function to display the catcher
  ball.display(); // call the function to display the ball
  ball2.display();
  woweee.move();  // call the function to move the catcher
  ball.move(); // call the function to move the ball
  ball2.move();
  woweee.checkCaught();  // check if the ball is touching the catcher
}

void showScore() {
  fill(255);
  textSize(20);
  text("Score: " + woweee.getScore(), 10, 50);
}

void keyPressed() {
  if (key == 'z' || key == 'x' || key == 's') {
    woweee.setCatcherControl(key);  // z, x, and s keys control movement
  }
}
