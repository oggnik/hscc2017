import java.io.InputStream;
import java.util.*;

public class CornMaze {

    public static void main(String[] args) {
        start(System.in);
    }

    public static void start(InputStream in) {
          /*
         * Read in the data from System.in
         */
        Scanner s = new Scanner(in);
        int totalPaths = s.nextInt();
        int startFork = s.nextInt();
        int endFork = s.nextInt();

        Map<Integer, List<Integer>> paths = new HashMap<>();
        for(int i = 0; i < totalPaths; i++) {
            int start = s.nextInt();
            int end = s.nextInt();

            //We need to create the collection or add to it.
            if(!paths.containsKey(start)) {
                List<Integer> endpoints = new ArrayList<>();
                endpoints.add(end);
                paths.put(start, endpoints);
            } else {
                paths.get(start).add(end);
            }

            //We don't know the direction of the path here,
            // so lets insert it in the other direction as well.
            if(!paths.containsKey(end)) {
                List<Integer> endpoints = new ArrayList<>();
                endpoints.add(start);
                paths.put(end, endpoints);
            } else {
                paths.get(end).add(start);
            }
        }

        /*
        Navigate the maze
         */

        navigateMap(paths, startFork, endFork, new Stack<>());
    }


    private static void navigateMap(Map<Integer, List<Integer>> maze, int currentPosition, int endPosition, Stack<Integer> currentRoute) {
        if(currentPosition == endPosition) {
            //we are done.
            printRoute(currentRoute, endPosition);
        } else {
            for(Integer next : maze.get(currentPosition)) {
                if(currentRoute.contains(next)) continue; //don't backtrack

                currentRoute.push(currentPosition);

                Stack<Integer> newRoute = new Stack<>();
                newRoute.addAll(currentRoute);

                navigateMap(maze, next, endPosition, newRoute);
            }
        }
    }

    private static void printRoute(Stack<Integer> currentRoute, int end) {
        for(Integer fork : currentRoute) {
            System.out.println(fork);
        }
        System.out.println(end);
    }
}











