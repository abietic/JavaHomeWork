import java.util.InputMismatchException;
import java.util.Scanner;

public class GetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int sum = 0 , temp = 0;
		while (true) {
			temp = 0;
			try {
				temp = in.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
//				System.out.println(e.getMessage());
				in.next();
			}
			if (temp == 999) {
				break;
			}
			sum += temp;
		}
		System.out.println(sum);
	}

//	public class MyIgnor extends InputMismatchException {
//		
//	}
}
