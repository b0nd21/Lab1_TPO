

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Dijkstra {


    public static Double[] findShortestPaths(Double[][] paths, int from) {
        if (from < 0 || from > paths.length) {
            throw new IllegalArgumentException("Illegal from param!");
        }

        if (paths.length == 0) {
            throw new IllegalArgumentException("Illegal array size!");
        }

        for (Double[] path : paths) {
            if (path.length != paths.length) {
                throw new IllegalArgumentException("Illegal array format!");
            }
        }

        int count = 0;
        for (int i = 0; i < paths.length; i++) {
            for (int j = 0; j < paths[i].length; j++) {
                if (paths[i][j] < 0) {
                    throw new IllegalArgumentException("Paths must not be negative!");
                }
                if (!paths[i][j].equals(paths[j][i])){
                    throw new IllegalArgumentException("Graph must not be oriented!");
                }
                if (paths[i][j] != Double.POSITIVE_INFINITY) {
                    count++;
                }
            }
        }
        if(count < 2) {
            throw new IllegalArgumentException("Graph nodes are not connected!");
        }
        Double[] result = new Double[paths.length];
        Arrays.fill(result, Double.POSITIVE_INFINITY);
        result[from] = 0.0;
        LinkedHashSet<Integer> visitOrder =  new LinkedHashSet<>();;
        visitOrder.add(from);
        result = recount(paths, result.clone(), from);
        int minValueIndex = findMinValueIndex(result, visitOrder, from);

        while (visitOrder.size() < paths.length) {
            visitOrder.add(minValueIndex);
            result = recount(paths, result.clone(), minValueIndex);
            minValueIndex = findMinValueIndex(result, visitOrder, minValueIndex);
        }
        return result;
    }

    private static Double[] recount(Double[][] paths, Double[] result, int from){
        for (int j = 0; j < paths.length; j++) {
            if (paths[from][j] < Double.POSITIVE_INFINITY) {
                double countedPath = result[from] + paths[from][j];
                result[j] = Math.min(countedPath, result[j]);
            }
        }
        return result;
    }

    private static int findMinValueIndex(Double[] arr, Set<Integer> visited, int exceptOf) {
        Double value = Double.POSITIVE_INFINITY;
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != exceptOf && arr[i] < value && !visited.contains(i)) {
                value = arr[i];
                index = i;
            }
        }
        return index;
    }

}