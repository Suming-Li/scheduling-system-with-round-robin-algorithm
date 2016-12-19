package main;

import threads.*;

public class Main {
	public static void main(String[] args) {
		// Multithreading "CPU" & "Task" run
		CPU.getInstance().start();
		
		new Timer();
		
		new ReadKeyboard();

		new ReadKeyboard();
		
	}
}

    
