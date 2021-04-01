import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class DijkstraTest {
    private static final Double inf = Double.POSITIVE_INFINITY;

    @Test
    public void testBigArray() {
        Double[][] paths = new Double[][]{
                {0.0, 10.0, 30.0, 50.0, 10.0},
                {10.0, 0.0, inf, 40.0, inf},
                {30.0, inf, 0.0, 20.0, 10.0},
                {50.0, 40.0, 20.0, 0.0, 30.0},
                {10.0, inf, 10.0, 30.0, 0.0}};
        Double[] expected = new Double[]{0.0, 10.0, 20.0, 40.0, 10.0};
        Assertions.assertArrayEquals(expected, Dijkstra.findShortestPaths(paths, 0));
    }

    @Test
    public void testSmallArray() {
        Double[][] paths = new Double[][]{
                {0.0, 10.0},
                {10.0, 0.0}};
        Double[] expected = new Double[]{0.0, 10.0};

        Assertions.assertArrayEquals(expected, Dijkstra.findShortestPaths(paths, 0));

        Double[] expected1 = new Double[]{10.0, 0.0};
        Assertions.assertArrayEquals(expected1, Dijkstra.findShortestPaths(paths, 1));
    }

    @Test
    public void testZeroSmallArray() {
        Double[][] paths = new Double[][]{
                {0.0, 0.0},
                {0.0, 0.0}};
        Double[] expected = new Double[]{0.0, 0.0};
        Assertions.assertArrayEquals(expected ,Dijkstra.findShortestPaths(paths, 0));

        Double[] expected1 = new Double[]{0.0, 0.0};
        Assertions.assertArrayEquals(expected1, Dijkstra.findShortestPaths(paths, 1));
    }

    @Test
    public void testNotSymmetricArray() {
        Double[][] paths = new Double[][]{
                {0.0, 10.0, 30.0, 50.0, 10.0},
                {inf, 0.0, inf, inf, inf},
                {inf, inf, 0.0, inf, 10.0},
                {inf, 40.0, 20.0, 0.0, inf},
                {10.0, inf, 10.0, 30.0, 0.0}};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Dijkstra.findShortestPaths(paths, 0));
    }

    @Test
    public void testNegativePaths() {
        Double[][] paths = new Double[][]{
                {0.0, 10.0, 30.0, -50.0, -10.0},
                {10.0, 0.0, inf, inf, inf},
                {30.0, inf, 0.0, -20.0, 10.0},
                {-50.0, inf, -20.0, 0.0, 30.0},
                {-10.0, inf, 10.0, 30.0, 0.0}};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Dijkstra.findShortestPaths(paths, 0));
    }

    @Test
    public void testInvalidArrayLength() {
        Double[][] paths = new Double[][]{
                {0.0, 10.0, 30.0, 50.0, 10.0},
                {inf, 0.0, inf},
                {inf},
                {},
                {10.0, inf, 10.0, 30.0, 0.0, 0.0, 182.0, 51.0}};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Dijkstra.findShortestPaths(paths, 0));
    }

    @Test
    public void testZeroArrayLength() {
        Double[][] paths = new Double[0][0];
        Assertions.assertThrows(IllegalArgumentException.class, () -> Dijkstra.findShortestPaths(paths, 0));
    }

    @Test
    public void testInfArray() {
        Double[][] paths = new Double[][]{
                {inf, inf},
                {inf, inf}};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Dijkstra.findShortestPaths(paths, 0));
    }

    @Test
    public void testNegativeFromValue() {
        Double[][] paths = new Double[][]{
                {0.0, 10.0, 30.0, 50.0, 10.0},
                {10.0, 0.0, inf, 40.0, inf},
                {30.0, inf, 0.0, 20.0, 10.0},
                {50.0, 40.0, 20.0, 0.0, 30.0},
                {10.0, inf, 10.0, 30.0, 0.0}};
        Assertions.assertThrows(IllegalArgumentException.class, () -> Dijkstra.findShortestPaths(paths, -1));
    }
}