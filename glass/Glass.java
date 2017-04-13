import java.util.*;
public class Glass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int[][] V = new int[M+1][M+1];
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= M; j++) {
				V[i][j] = in.nextInt();
			}
		}
		Glass glass = new Glass(V);
		int T = in.nextInt();
		for (int t = 0; t < T; t++) {
			System.out.println(glass.getOptimizedGlass(in.nextInt(), in.nextInt()));
		}
	}

	private int[][] V;
	private int[][] memo;

	public Glass(int[][] V) {
		this.V = V;
		this.memo = new int[V.length][V.length];
		this.memo[1][1]= this.V[1][1];
	}

	// Optimized code (should run quickly)
	public int getOptimizedGlass(int width, int height) {
		if (memo[width][height] > 0) {
			return memo[width][height];
		}
		int bestValue = V[width][height];
		// cut width
		for (int i = 1; i < width; i++) {
			int potentialBestValue = getOptimizedGlass(i, height) + getOptimizedGlass(width - i, height);
			if (potentialBestValue > bestValue) {
				bestValue = potentialBestValue;
			}
		}

		// cut height
		for (int i = 1; i < height; i++) {
			int potentialBestValue = getOptimizedGlass(width, i) + getOptimizedGlass(width, height - i);
			if (potentialBestValue > bestValue) {
				bestValue = potentialBestValue;
			}
		}
		memo[width][height] = bestValue;
		return bestValue;
	}

	// Brute force implementation (should time out)
	public int getBruteForceGlass(int width, int height) {
		if (width == height && height == 1) {
			return V[width][height];
		}
		int bestValue = V[width][height];
		// cut width
		for (int i = 1; i < width; i++) {
			int potentialBestValue = getBruteForceGlass(i, height) + getOptimizedGlass(width - i, height);
			if (potentialBestValue > bestValue) {
				bestValue = potentialBestValue;
			}
		}

		// cut height
		for (int i = 1; i < height; i++) {
			int potentialBestValue = getOptimizedGlass(width, i) + getOptimizedGlass(width, height - i);
			if (potentialBestValue > bestValue) {
				bestValue = potentialBestValue;
			}
		}
		return bestValue;
	}
}