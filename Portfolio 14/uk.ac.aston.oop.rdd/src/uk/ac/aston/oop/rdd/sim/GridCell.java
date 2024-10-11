package uk.ac.aston.oop.rdd.sim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GridCell {

    private final int row;
    private final int column;
    private final Grid grid;
    private final List<Actor> contents;

    public GridCell(Grid grid, int row, int column) {
        this.grid = grid;
        this.row = row;
        this.column = column;
        this.contents = new ArrayList<>();
    }

    public List<Actor> getContents() {
        return contents;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Grid getGrid() {
        return grid;
    }

    public List<GridCell> getAdjacent() {
        List<GridCell> results = new ArrayList<>();

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i == row && j == column) {
                    continue; // Skip the current cell
                }

                if (i >= 0 && i < grid.getHeight() && j >= 0 && j < grid.getWidth()) {
                    results.add(grid.get(i, j));
                }
            }
        }

        return results;
    }

    public List<GridCell> getFreeAdjacent() {
        List<GridCell> freeAdjacent = new ArrayList<>();

        for (GridCell adjacent : getAdjacent()) {
            if (adjacent.getContents().isEmpty()) {
                freeAdjacent.add(adjacent);
            }
        }

        return freeAdjacent;
    }

    public GridCell getRandomFreeAdjacent(Random rnd) {
        List<GridCell> freeAdjacent = getFreeAdjacent();

        if (freeAdjacent.isEmpty()) {
            return null;
        }

        int randomIndex = rnd.nextInt(freeAdjacent.size());
        return freeAdjacent.get(randomIndex);
    }
}