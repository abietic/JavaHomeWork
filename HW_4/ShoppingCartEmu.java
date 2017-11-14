import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCartEmu {

	public static class Books{
		String BookName;
		Double BookPrice;
		Integer PurchaseAmount;
		public Books(String BN , double BP , int PA) {
			this.BookName = BN;
			this.BookPrice = BP;
			this.PurchaseAmount = PA;
		}
	}
	public static Double getSum(HashMap<String , Books> books) {
		Set<java.util.Map.Entry<String,Books>> index = books.entrySet();
		double sum = 0;
		for (java.util.Map.Entry<String, Books> entry : index) {
			sum += entry.getValue().BookPrice * entry.getValue().PurchaseAmount;
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		HashMap<String, Books> books = new HashMap<>();
		for (int i = 0 ; i < 5 ; i ++) {
			String bn = null;
			double bp = 0;
			int pa = 0;
			bn = in.next();
			bp = in.nextDouble();
			pa = in.nextInt();
			if (bn == null || bp <= 0 || pa < 0) {
				return;
			}
			books.put(bn, new Books(bn, bp, pa));
		}
		System.out.println(getSum(books));
	}

}
