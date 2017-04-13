import java.util.*;

public class Maps {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int C = in.nextInt();
		int R = in.nextInt();
		int[][] map = new int[C][C];
		for (int r = 0; r < R; r++) {
			int A = in.nextInt() - 1;
			int B = in.nextInt() - 1;
			int T = in.nextInt();
			map[A][B] = T;
			map[B][A] = T;
		}
		int start = in.nextInt() - 1;
		int end = in.nextInt() - 1;
		int bestPath = -1;
		LinkedList<Integer> costQueue = new LinkedList<>();
		costQueue.add(0);
		LinkedList<Integer> nodeQueue = new LinkedList<>();
		nodeQueue.add(start);
		boolean[] marked = new boolean[C];
		while (!costQueue.isEmpty()) {
			int indexToUse = 0;
			for (int i = 1; i < nodeQueue.size(); i++) {
				if (costQueue.get(i) < costQueue.get(indexToUse)) {
					indexToUse = i;
				}
			}
			int cost = costQueue.remove(indexToUse);
			int node = nodeQueue.remove(indexToUse);
			if (marked[node]) {
				continue;
			} else if (node == end) {
				bestPath = cost;
				break;
			} else {
				marked[node] = true;
			}
			for (int i = 0; i < C; i++) {
				if (map[i][node] > 0 && !marked[i]) {
					int nodeCost = cost + map[i][node];
					costQueue.add(nodeCost);
					nodeQueue.add(i);
				}
			}
		}
		System.out.println(bestPath);
	}
}