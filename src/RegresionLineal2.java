public class RegresionLineal2 {

    public double[] calculateGradientDescent(float[] x, float[] y, double learningRate, int maxIterations, double minError) {
       //Inicializando con valores aleatorios
        double beta0 = Math.random() * 8 + 1;
        double beta1 = Math.random() * 8 + 1;
        double error = Double.MAX_VALUE;

        for (int iteration = 0; iteration < maxIterations && error > minError; iteration++) {
            double gradientBeta0 = calculateGradientBeta0(x, y, beta0, beta1);
            double gradientBeta1 = calculateGradientBeta1(x, y, beta0, beta1);

            beta0 -= learningRate * gradientBeta0;
            beta1 -= learningRate * gradientBeta1;

            error = calculateError(x, y, beta0, beta1);
        }

        return new double[]{beta0, beta1};
    }

    private double calculateGradientBeta0(float[] x, float[] y, double beta0, double beta1) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += y[i] - beta0 - (beta1 * x[i]);
        }
        return -2.0 * sum / x.length;
    }

    private double calculateGradientBeta1(float[] x, float[] y, double beta0, double beta1) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum += (y[i] - beta0 - (beta1 * x[i])) * x[i];
        }
        return -2.0 * sum / x.length;
    }

    private double calculateError(float[] x, float[] y, double beta0, double beta1) {
        double sum = 0;
        for (int i = 0; i < x.length; i++) {
            double predicted = beta0 + beta1 * x[i];
            sum += Math.pow((y[i] - predicted), 2);
        }
        return sum / x.length;
    }
}
