// Number of rows to draw
int numRows;
// Number of rectangles starting at bottom
int rowLength;
// X coord of 1st rectangle in bottom row
int startX;
// Y coord of 1st rectangle in bottom row
int startY;
// Width of rectangles
int rectWidth;
// Height of rectangles
int rectHeight;
// When isColour is false, all rectangles are filled in white
// Otherwise, a random fill colour is chosen.
boolean isColour;

void setup(){
  size(900,400);
  stroke(0); //pen colour black
  numRows = 1; // Initally 1 row of rectangles
  rowLength = 10; //10 rectangles in first row.
  startX = 50;
  startY = 350;
  rectWidth = 75; // Each rectangle is 75 pixels wide.
  rectHeight = 30; // Each rectangle is 30 pixels high.
  isColour = false;
}

void draw(){
  background(125);
  
  // Random fill colour for triangle
  if (isColour){
    fill(random(255),random(255),random(255));
  }
  else{
    fill(255);
  }
  
  // O(n^2) time complexity algorithm to draw rectangle triangle.
  for (int y = 1; y <= numRows; y++){
    for (int x = 0; x <= rowLength; x++){
      rect(startX, startY, rectWidth, rectHeight);
      startX = startX + rectWidth;
    }
    startY = startY - rectHeight;
    rowLength--;
    startX = 50;
    if (y == numRows){
      startY = 350;
      rowLength = 10;
    }
  }
}

void mousePressed(){
  // Increase row
  if (numRows < 11){
    numRows++;
  }
  else{
    numRows = 1;
    isColour = !isColour;
  }
}
