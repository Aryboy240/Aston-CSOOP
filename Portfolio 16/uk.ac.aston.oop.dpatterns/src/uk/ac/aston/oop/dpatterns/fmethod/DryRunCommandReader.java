package uk.ac.aston.oop.dpatterns.fmethod;

public class DryRunCommandReader extends AbstractCommandReader {
	
	 protected Runnable createMovementCommand(int dx, int dy) {
        String message = "Move " + dx + " horizontally and " + dy + " vertically";
        return new DryRunCommand("Dry Run: " + message);
	 }
	
}
