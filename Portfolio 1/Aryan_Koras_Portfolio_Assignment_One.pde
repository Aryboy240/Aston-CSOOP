float ran;
float ran2;
float ran3;
float move;
float move2;
float move3;
int speed;
int speed2;
int speed3;

void setup (){
  size(1280,720);
  
  // Sets speed of blocks
  speed = 20;
  speed2 = 25;
  speed3 = 30;
  
  rectMode(CENTER);
  
  // Sets random position of blocks
  ran = random(1280);
  ran2 = random(1280);
  ran3 = random(1280);
}

void draw(){
  background(255);
  
  // Car
  fill(0,255,0);
  stroke(0);
  rect(mouseX,mouseY,100,50);
  ellipse(mouseX-40,mouseY+25,40,40);
  ellipse(mouseX+40,mouseY+25,40,40);
  
  // Falling block 1
  fill(255,0,0);
  stroke(255, 0, 0);
  rect(ran, move, 25, 50);
  
  // Block 2
  fill(0,0,255);
  stroke(255, 0, 0);
  rect(ran2, move2, 25, 50);
  
  // Block 3
  fill(255,150,0);
  stroke(255, 0, 0);
  rect(ran3, move3, 25, 50);
  
  // Makes the blocks fall
  move = move + speed;
  move2 = move2 + speed2;
  move3 = move3 + speed3;
  
  // Checks if it hits the bottom of the screen
  if(move>720)
  {
    ran= random(1280);
    move = 0;
  }
  if(move2>720){
    ran2 = random(1280);
    move2 = 0;
  }
  if(move3>720){
    ran3 = random(1280);
    move3 = 0;
  }
  
  // Collision detection
  if(mouseX>ran-25 && mouseX<ran+10)
  {
    if(mouseY>move-50 && mouseY<move+50){
      background(0);
      textSize(128);
      fill(255,0,0);
      textAlign(CENTER);
      text("GAME OVER", 640, 360);
      noLoop();
    }
  }
  if(mouseX>ran2-25 && mouseX<ran2+10)
  {
    if(mouseY>move2-50 && mouseY<move2+50){
      background(0);
      textSize(128);
      fill(255,0,0);
      textAlign(CENTER);
      text("GAME OVER", 640, 360);
      noLoop();
    }
  }
  if(mouseX>ran3-25 && mouseX<ran3+10)
  {
    if(mouseY>move3-50 && mouseY<move3+50){
      background(0);
      textSize(128);
      fill(255,0,0);
      textAlign(CENTER);
      text("GAME OVER", 640, 360);
      noLoop();
    }
  }
}
