import sun.net.www.content.text.PlainTextInputStream;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * Created by dmtsc on 4/13/2017.
 */
public class CornMazeTestGenerator {
    static int DESIRED_COUNT = 2000 - 1; //because I am lazy.
    static int CHANCE_FOR_FORK = 100;

    public static void main(String[] args) {
        TestCase testCase = new TestCase();
        Stack<Integer> rands = new Stack<Integer>();

        int ENTROPY = DESIRED_COUNT + DESIRED_COUNT / 2;
        for(int i = 1; i < ENTROPY; i++) {
            rands.push(i);
        }
        Collections.shuffle(rands);

        Stack<Integer> current_leaves = new Stack<>();
        testCase.first = rands.pop();
        current_leaves.push(testCase.first);

        while(!current_leaves.isEmpty()) {
            //making it act like a queue.
            int currentleaf = current_leaves.lastElement();
            current_leaves.remove(current_leaves.size() - 1);

            //Sometimes we want to stop at a specific count
            //for the sake of creating a good test case.
            if(testCase.edges.size() == DESIRED_COUNT){
                //We have enough things to choose from already;
                current_leaves.push(currentleaf);
                Collections.shuffle(current_leaves);
                testCase.last = current_leaves.pop();
                break;
            }

            //chance to be a dead end. 50/50.
            if(new Random().nextInt(100) < CHANCE_FOR_FORK) {
                int nextLeaf = rands.pop();
                testCase.createEdge(currentleaf, nextLeaf);
                current_leaves.push(nextLeaf);
            } else {
                //don't create an edge.
            }

            //if this is the last edge, make it the goal.
            if(current_leaves.isEmpty()) {
                testCase.last = currentleaf;
                break;
            }
        }

        System.out.print(testCase.toString());

        System.out.println("---");

        Main.start(new ByteArrayInputStream(testCase.toString().getBytes(StandardCharsets.UTF_8)));
    }

    static class TestCase {
        //int numberOfEntries;
        List<Pair> edges = new ArrayList<>();
        int first;
        int last;

        public void createEdge(int currentleaf, int nextLeaf) {
            edges.add(new Pair(currentleaf, nextLeaf));
        }

        class Pair {
            int one;
            int other;

            public Pair(int currentleaf, int nextLeaf) {
                this.one = currentleaf;
                this.other = nextLeaf;
            }
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(edges.size()).append("\n")
                    .append(this.first).append(" ").append(this.last).append("\n");

            for (Pair pair : edges) {
                sb.append(pair.one).append(" ").append(pair.other).append("\n");
            }

            return sb.toString();
        }
    }
}
