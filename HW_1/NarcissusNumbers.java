
public class NarcissusNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int testNumber = 100;
		int tempNum = 0 , sum = 0;
		String distructedNum;
		while (testNumber < 1001) {
			distructedNum =  Integer.toString(testNumber);
			sum = 0;
			for (int i = 0 ; i < 3 ; i ++) {
				tempNum = (int)(distructedNum.charAt(i) - '0');
				sum += tempNum * tempNum * tempNum;
			}
			if (testNumber == sum) {
				System.out.println(testNumber);
			}
			testNumber++;
		}
	}

}
