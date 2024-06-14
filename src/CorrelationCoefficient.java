public class CorrelationCoefficient {

    public static float calculateCorrelationCoefficient(float[] x, float[] y) {
        int n = x.length;

        float sumXY = 0;
        float sumX = 0;
        float sumY = 0;
        float sumXSquare = 0;
        float sumYSquare = 0;

        for (int i = 0; i < n; i++) {
            sumXY += x[i] * y[i];
            sumX += x[i];
            sumY += y[i];
            sumXSquare += x[i] * x[i];
            sumYSquare += y[i] * y[i];
        }

        float numerator = n * sumXY - sumX * sumY;
        float denominator = (float) Math.sqrt((n * sumXSquare - sumX * sumX) * (n * sumYSquare - sumY * sumY));

        return numerator / denominator;
    }
}

