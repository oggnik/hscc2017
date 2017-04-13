import java.util.Scanner;

public class trash {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		in.nextLine(); // throw away newline
		String friend = in.nextLine();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (in.nextLine().equals(friend)) {
				count++;
			}
		}
		System.out.println(count);
	}
}