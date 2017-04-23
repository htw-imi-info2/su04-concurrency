package no01_threads_basics;
/**
 * Examine this with the debugger.
 * @author bkleinen
 *
 */
public class JustMain {

	public static void main(String[] args) {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			};
			System.out.println(".");	
		}
	}
}
