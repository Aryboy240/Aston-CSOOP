package uk.ac.aston.oop.dpatterns.fmethod;

import java.lang.Runnable;

public class ExecutingCommand implements Runnable {
	
	private ExecutingCommandReader reader;
	private int dx;
	private int dy;
	
	public ExecutingCommand(ExecutingCommandReader reader, int dx, int dy) {
		this.reader = reader;
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
    public void run() {
        reader.setX(reader.getX() + dx);
        reader.setY(reader.getY() + dy);

        System.out.println("Executing Move: dx = " + reader.getX() + ", dy = " + reader.getY());
    }
}
