package uk.ac.aston.oop.rdd.sim;

import java.util.HashSet;
import java.util.Set;

public class Field {

	private Grid grid;

	private Set<Animal> contents = new HashSet<>();

	public Field(int nRows, int nColumns) {
		this.grid = new Grid(nRows, nColumns);
	}

	public Grid getGrid() {
		return grid;
	}

	public void add(Animal a, int row, int column) {
		GridCell cell = grid.get(row, column);

		cell.getContents().add(a);
		contents.add(a);
		a.setCell(cell);
		a.setField(this);
	}

	public void remove(Animal a) {
		GridCell cell = a.getCell();
		if (cell != null) {
			cell.getContents().remove(a);
			contents.remove(a);
			a.setCell(null);
			a.setField(null);
		}
	}

	public Set<Animal> getContents() {
		return contents;
	}

	public int getCount(Class<?> klass) {
		int count = 0;

		for (Animal a : contents) {
			if (a.getClass().equals(klass)) {
				count++;
			}
		}

		return count;
	}

}
