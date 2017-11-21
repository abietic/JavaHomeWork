import java.util.Random;

public class Ticket {

	static public int TicketNumber = 100;
	static public Object mutex = new Object();
	static public class TicketSeller extends Thread{
		public int num;
		public TicketSeller(int num) {
			// TODO Auto-generated constructor stub
			this.num = num;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				synchronized (mutex) {
					if (TicketNumber == 0) {
						return;
					}
					System.out.println(this.num + "-------" + TicketNumber);
					TicketNumber--;
				}
				try {
					sleep((long) (100 * Math.random()));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread[] threads = new TicketSeller[5];
		for (int i = 0 ; i < 5 ; i ++) {
			threads[i] = new TicketSeller(i + 1);
		}
		for (int i = 0 ; i < 5 ; i ++) {
			threads[i].start();
		}
	}

}
