public class Cos {

    public static double calculateCos(double x, double accuracy) {
        if (x == Double.POSITIVE_INFINITY || x == Double.NEGATIVE_INFINITY || x == Double.MAX_VALUE || x == Double.MIN_VALUE){
            throw new IllegalArgumentException("Illegal input value!");
        }
        if (accuracy >= 1 || accuracy <= 0){
            throw new IllegalArgumentException("Illegal accuracy value!");
        }
        x = x * Math.PI / 180;

        double n, m, sign, result;
        result = 1;

        if (x > 0)
            while (x > 2 * Math.PI) {
                x = x - 2 * Math.PI;
            }
        else
            while (x < 2 * Math.PI) {
                x = x + 2 * Math.PI;
            }

        n = 2;
        m = 1;
        sign = -1;
        while (m > accuracy) {
            m = m * x * x / ((n - 1) * n);
            result = result + sign * m;
            sign = - sign;
            n = n + 2;
        }
        return result;

    }

}
