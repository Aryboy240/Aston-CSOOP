package uk.ac.aston.oop.rdd.sim;

import java.util.Random;

public interface Actor {
    GridCell getCell();
    void setCell(GridCell cell);
    Field getField();
    void setField(Field field);
    void act(Random rnd);
}
