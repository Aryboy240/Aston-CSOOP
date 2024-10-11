class Car {
  private float x;
  private float y;
  private float r;
  private float g;
  private float b;
  private float theSize;
  private int score;


  public Car(float xp, float yp, float size) {
    theSize = size;
    setPosition(xp);
    y = yp;
    score = 0;
    r = random(0, 255);
    g = random(0, 255);
    b = random(0, 255);
  }

  public void display() {
    // offset to draw the wheels
    float wheelOffset = theSize / 4;
    rectMode(CENTER);
    // draw the chassis
    stroke(0);
    fill(r, g, b);
    rect(x, y, theSize, theSize/2);
    // draw the wheels
    fill(0);
    rect(x - wheelOffset, y - wheelOffset, wheelOffset, wheelOffset/2);
    rect(x + wheelOffset, y - wheelOffset, wheelOffset, wheelOffset/2);
    rect(x - wheelOffset, y + wheelOffset, wheelOffset, wheelOffset/2);
    rect(x + wheelOffset, y + wheelOffset, wheelOffset, wheelOffset/2);
    textSize(20);
    textAlign(CENTER);
    text(score, x, y + 6);
  }

  public void move() {
    x = x + random(0, 10);
  }

  public float getPosition() {
    // return the X position of the front of the car
    return x + theSize/2;
  }

  public void setPosition(float newPos) {
    x = newPos - theSize/2;
  }

  public void increaseScore() {
    int newScore;
    int distance;

    // Calculates the scores for each car in a linear itteration
    for (int x = 0; x < numberOfCars; x++) {
      distance = round(track.getFinishPosition()) - round(cars[x].getPosition());
      newScore = 100 - distance;

      // Adds the score sumation to the total score of the cars (Won't allow if negative)
      if (newScore > 0) {
        if (distance <= 0) {
          newScore = 100;
          cars[x].setScore(newScore);
        } else {
          cars[x].setScore(newScore);
        }
      } else {
        newScore = 0;
        cars[x].setScore(newScore);
      }
    }
  }

  public int getScore() {
    return score;
  }

  public void setScore(int newScore) {
    score += newScore;
  }
}
