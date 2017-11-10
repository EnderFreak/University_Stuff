// NoFinally.java
//
// When an exception is thrown, execution of the associated try block is immediately
// terminted and Java goes in search of an appropriate exception handler. Control
// does not return to the try block!
//
// In this example, we are manipulating a switch. Our goal is to make sure that
// the switch is turned off when the program finishes. If you run the program, you'll
// see that this doesn't work because, when the exception occurs, controls goes back
// to the main method and the "switch off" statements never get executed.


//package exceptions;

class OnOffException1 extends Exception {}

class OnOffException2 extends Exception {}


// the switch class, including methods to turn the switch on and off
class Switch {
  	private boolean state = false;

  	public boolean read() {
  		return state;
  	}

  	public void on() {
  		state = true;
  	}

  	public void off() {
  		state = false;
  	}
}


// The switch test. An exception is generated in the try clause when f() is
// executed. Control never returns to the method
class SwitchTest{

	public static void f() throws OnOffException2 {
		throw new OnOffException2();
	}

	public void run(Switch mySwitch) throws OnOffException2{

		try {
			mySwitch.on();
			if(mySwitch.read() == false)
				throw new OnOffException1();
			f();
			System.err.println("Turning switch off in try block...");
			mySwitch.off();
		}

		catch(OnOffException1 e) {
			System.err.println("OnOffException1");
			System.err.println("Turning switch off in ex 1 catch block...");
			mySwitch.off();
		}

		System.err.println("Turning switch off at bottom of run method...");
		mySwitch.off();
	}

}





public class testrevision {

  	public static void main(String[] args){

		Switch mySwitch = new Switch();
		SwitchTest switchTest = new SwitchTest();

		try {
			switchTest.run(mySwitch);
		}
		catch (OnOffException2 e){ // catch exception here
			System.err.println("Caught exception2 in main method");
		}


		System.err.println("State of Switch: " + mySwitch.read());

  }
}


