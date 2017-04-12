import java.util.*;

public class Bizz {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % 7 == 0) {
				if (i % 4 == 0) {
					System.out.println("BizzFuzz");
				} else {
					System.out.println("Fuzz");
				}
			} else if (i % 4 == 0) {
				System.out.println("Bizz");
			} else {
				System.out.println(i);
			}
		}
	}
}
