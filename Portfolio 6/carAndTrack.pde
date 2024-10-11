/* Basically, how I want the score system to work is to have it set 100 //<>//
 to each car once one reaches the end and then minus the distance (x)
 off that score depending how far away the other cars were from the finish line.
 This will mean the car that won got the full 100 points and the other ones get a
 fraction of it depending on how close they were to the finish line.
 When the user presses 's' it will increment a 'run'.
 There will be 5 'runs' in total and after those 5 runs, the game will end
 and the scores will be compared to determine the winner.
 To ensure that a draw is possible, I'll use integers instead of floats
 for the scores due to the decreased accuracy (nearly impossible otherwise).
 */


Car[] cars;
int numberOfCars = 9;
int rounds = 0;
float carPosY = 60;
RaceTrack track;
boolean raceOver;

void setup() {
  size(1000, 600);
  track = new RaceTrack();
  cars = new Car[numberOfCars];

  // Creates new instances of cars until stopping condition is met
  for (int i = 0; i < numberOfCars; i++) {
    cars[i] = new Car(track.getStartPosition(), carPosY, 60);
    carPosY += 60;
  }
  raceOver = false;
}

void draw() {
  background(70);
  track.display();
  //Checks if the game hsa ended before displaing anything
  for (int i = 0; i < numberOfCars; i++) {
    if (rounds < 5)
    {
      cars[i].display();
    }
    if (!raceOver) {
      if (cars[i].getPosition() >= track.getFinishPosition()) {
        cars[i].increaseScore();
        raceOver = true;
        rounds++;
        if (rounds >= 5) {
          bestScore();
        } else {
          println("Press 's' to restart");
        }
      } else {
        cars[i].move();
      }
    }
  }
}

public void bestScore() {
  int maxScore = 0;
  int maxHold = 0;
  int car1 = 0;
  int car2 = 0;

  // Linear search conducted in the array to find the highest score (Checks if drawn too)
  for (int currentPointer = 0; currentPointer < numberOfCars; currentPointer++) {
    if (cars[currentPointer].getScore() > maxScore) {
      maxScore = cars[currentPointer].getScore();
      car1 = currentPointer;
    } else if (cars[currentPointer].getScore() == maxScore) {
      maxHold = cars[currentPointer].getScore();
      car2 = currentPointer;
    }
  }
  if (maxHold < maxScore) {
    determinWin(car1, car2, 1); //Win
  } else {
    determinWin(car1, car2, 2); //Draw
  }
}


void determinWin(int car1, int car2, int winCondition) {
  int scoreH = 100;
  //Win
  if (winCondition == 1) {
    background(0);
    fill(0, 255, 0);
    textSize(50);
    textAlign(CENTER);
    text("Car number " + (car1 + 1) + " wins!", width/2, scoreH);
    fill(255, 255, 255);
    text("Scores:", width/2, scoreH + 100);
    textSize(25);
    for (int i = 0; i < numberOfCars; i++) {
      scoreH += 40;
      text("Car " + (i + 1) + " - " + cars[i].getScore(), width/2, scoreH + 100);
    }
    noLoop();
  }
  // Draw
  else if (winCondition == 2) {
    background(0);
    fill(255, 165, 0);
    textSize(50);
    textAlign(CENTER);
    text("Car number " + (car1 + 1) + " Draws with", width/2, scoreH);
    text("Car number " + (car2 + 1) + "!", width/2, scoreH + 50);
    fill(255, 255, 255);
    text("Scores:", width/2, scoreH + 100);
    textSize(25);
    for (int i = 0; i < numberOfCars; i++) {
      scoreH += 40;
      text("Car " + (i + 1) + " - " + cars[i].getScore(), width/2, scoreH + 100);
    }
    noLoop();
  }
  // This part shouldn't execute
  else {
    background(0);
    fill(255, 0, 0);
    textSize(100);
    textAlign(CENTER);
    text("Game brokey ;-;", width/2, height/2);
    noLoop();
  }
}

void keyPressed() {
  if (key == 's' && raceOver) {
    float startLine = track.getStartPosition();
    for (int i = 0; i < numberOfCars; i++) {
      cars[i].setPosition(startLine);
    }
    raceOver = false;
  }
}
