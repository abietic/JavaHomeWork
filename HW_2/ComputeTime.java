
public class ComputeTime {

	public static int atoi (String s) {
		int res = 0;
		for (int i = 0 ; i < s.length() ; i++) {
			res += s.charAt(i) - '0';
			res *= 10;
		}
		res /= 10;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Common transportation = (Common) Class.forName(args[0]).newInstance();
			int A = atoi(args[1]) , B = atoi(args[2]) , C = atoi(args[3]);
			System.out.println("The transportation is : " + args[0]);
			System.out.println("The calculation result is : " + transportation.calculate(A, B, C));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
