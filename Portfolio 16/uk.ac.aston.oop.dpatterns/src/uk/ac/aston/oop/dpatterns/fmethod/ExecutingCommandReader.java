package uk.ac.aston.oop.dpatterns.fmethod;

public class ExecutingCommandReader extends AbstractCommandReader {
	
	private int x = 0;
	private int y = 0;
	
	@Override
	protected Runnable createMovementCommand(int dx, int dy) {
		return new ExecutingCommand(this, dx, dy);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY (int y) {
		this.y = y;
	}
}
