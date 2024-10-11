package uk.ac.aston.oop.rdd.sim;

public class Grid {

    private final int width;
    private final int height;
    private final GridCell[][] rows;

    public Grid(int height, int width) {
        this.height = height;
        this.width = width;
        this.rows = new GridCell[height][];
        
        for (int i = 0; i < height; i++) {
            rows[i] = new GridCell[width];
            for (int j = 0; j < width; j++) {
                rows[i][j] = new GridCell(this, i, j);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public GridCell get(int row, int column) {
        if (row >= 0 && row < height && column >= 0 && column < width) {
            return rows[row][column];
        } else {
            return null;
        }
    }
}