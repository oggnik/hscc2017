import java.util.*;
public class Lemonade {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int[] V = new int[L+1];
		for (int i = 1; i <= L; i++) {
			V[i] = in.nextInt();
		}
		Lemonade lemonade = new Lemonade(V);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			System.out.println(lemonade.getOptimizedLemonade(in.nextInt()));
		}
	}

	private int[] V;
	private int[] memo;

	public Lemonade(int[] V) {
		this.V = V;
		this.memo = new int[V.length];
		this.memo[1]= this.V[1];
	}

	// Optimized code (should run quickly)
	public int getOptimizedLemonade(int oz) {
		if (memo[oz] > 0) {
			return memo[oz];
		}
		int bestValue = V[oz];
		for (int i = 1; i < oz; i++) {
			int potentialBestValue = getOptimizedLemonade(i) + V[oz - i];
			if (potentialBestValue > bestValue) {
				bestValue = potentialBestValue;
			}
		}
		memo[oz] = bestValue;
		return bestValue;
	}

	// Brute force implementation (should time out)
	public int getButeForceLemonade(int oz) {
		if (oz == 1) {
			return V[1];
		}
		int bestValue = V[oz];
		for (int i = 1; i < oz; i++) {
			int potentialBestValue = getButeForceLemonade(i) + V[oz - i];
			if (potentialBestValue > bestValue) {
				bestValue = potentialBestValue;
			}
		}
		return bestValue;
	}
}