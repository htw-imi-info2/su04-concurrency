package threads;

public class JustMain {

	public JustMain() {
		// TODO Auto-generated constructor stub
	}

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
