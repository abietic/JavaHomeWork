import java.util.InputMismatchException;
import java.util.Scanner;

public class GetPositiveSum {

	public static int testNum(int inputNum) throws NegtiveNumException {
		if (inputNum < 0) {
			throw new NegtiveNumException(inputNum);
		}
		return inputNum;
	}
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
				//System.out.println(e.getMessage());
				in.next();
			}
			if (temp == 999) {
				break;
			}
			try {
				sum += testNum(temp);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
		System.out.println(sum);
	}
	static class NegtiveNumException extends Exception {
		public NegtiveNumException(int erroNum) {
			super("The number " + erroNum + " < 0");
		}
	}

}
