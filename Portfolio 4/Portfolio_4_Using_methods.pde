float ballX; // X coordinate of the ball
float ballY; // Y coordinate of the ball
float ballWidth; // diameter of the ball
float speedX = 0; // speed of movement in X direction
float speedY = 0; // speed of movement in Y direction
float holeX;
float holeY;
float holeWidth;

void setup() {
size(600, 600);
// reset ball parameters, position and size
ballX = 20;
ballY = height/2;
ballWidth = 60;
// initialize the speed to random values
initializeSpeed ();
// initialize black hole
initializeHole();
}

void draw() {
background(127);
// draw the ball
drawColourCircle(ballX, ballY, ballWidth, color(255,0,0));
// move the ball
moveBall();
// bounce the ball ( if necessary)
bounceBall();
// Makes black hole
drawColourCircle(holeX, holeY, holeWidth, color(0));
// Checking black hole collision
if (checkCollide(ballX, ballY, ballWidth, holeX, holeY, holeWidth)) {
  initializeHole();
  initializeSpeed();
}
}

void initializeSpeed(){
  if (speedX <= 0 && speedY <= 0){
    speedX = random(5,10);
    speedY = random(5,10);
  }
  else if (speedX <= 0 && speedY >= 0) {
    speedX = random(5,10);
    speedY = random(-10,-5);
  }
  else if (speedX >= 0 && speedY >= 0){
    speedX = random(-10,-5);
    speedY = random(5,10);
  }
  else{
    speedX = random(-10,-5);
    speedY = random(-10,-5);
  }
}

void drawColourCircle(float pBallX, float pBallY, float pBallWidth, color pBallColour){
  fill (pBallColour);
  ellipse(pBallX, pBallY, pBallWidth, pBallWidth);
}

void moveBall(){
  // Move ball in x-axis
  if ((ballX+ballWidth/2) > width){
    ballX = width-ballWidth/2;
    ballX += speedX;
  }
  else if ((ballX+ballWidth/2) < 0){
    ballX = 0+ballWidth/2;
    ballX += speedX;
  }
  else{
    ballX += speedX;
  }

  // Move ball in y-axis
  if ((ballY+ballWidth/2) > height){ //<>//
    ballY = height-ballWidth/2;
    ballY += speedY;
  }
  else if ((ballY+ballWidth/2) < 0){
    ballY = 0+ballWidth/2;
    ballY += speedY;
  }
  else{
    ballY += speedY;
  }
}

void bounceBall(){
  // Bounce ball horizontally
  if ((ballX+ballWidth/2) >= width || (ballX-ballWidth/2) <= 0){
    speedX *= -1;
  }

  // Bounce ball vertically
  if ((ballY+ballWidth/2) >= height || (ballY-ballWidth/2) <= 0){
    speedY *= -1;
  }
}

void keyPressed(){
  switch (key){
    case('x'):
      if (speedX > 0){
        speedX = random(5,10);
      }
      else{
        speedX = random(-10,-5);
      }
      print("\nX = ",speedX);
      break;
    case('y'):
      if (speedY > 0){
        speedY = random(5,10);
      }
      else{
        speedY = random(-10,-5);
      }
      print("\nY = ",speedY);
      break;
  }
}

void initializeHole(){
  holeX = random(0,width);
  holeY = random(0, height);
  holeWidth = random(100,300);
}

float distance(float x1, float x2, float y1, float y2){
  float side1 = x1-x2;
  float side2 = y1-y2;
  return sqrt((side1*side1)+(side2*side2));
}

boolean checkCollide(float rx, float ry, float rd, float bx, float by, float bd){
  if (distance(rx, bx, ry, by) <= ((bd/2) + (rd/2))){
    return true;
  }
  else{
    return false;
  }
}
