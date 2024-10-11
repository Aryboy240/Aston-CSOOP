boolean stop = true;

void setup(){
  // The inital setup of the program
  size (400,400);
  textSize(75);
  fill(0);
  textAlign(RIGHT);
}

void mousePressed(){
  // When the mouse is pressed it inverts the value for "stop"
  stop = !stop;
}

void draw(){
  if (stop){
    // STOP
    background(255,0,0);
    text("STOP",200,200);
  }
  else{
    // WALK
    background(0,255,0);
    text("WALK",200,200);
  }
}
