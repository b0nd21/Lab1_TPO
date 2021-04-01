import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Double[][] paths = new Double[][]{
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}};
        System.out.println(Arrays.toString(Dijkstra.findShortestPaths(paths, 0)));
    }
}
