package uk.ac.aston.oop.dpatterns.fmethod;

import java.lang.Runnable;

public class DryRunCommand implements Runnable {
	
	private String message;
	
	public DryRunCommand(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		System.out.println(this.message);
	}
}
