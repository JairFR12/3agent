public class RegresionLineal {

    public float[] calcularRegresionLineal(float[] x, float[] y) {
        float beta0 = 0; // Inicialización de beta0
        float beta1 = 0; // Inicialización de beta1
        float alpha = 0.001F; // Tasa de aprendizaje
        int maxIteraciones = 100; // Número máximo de iteraciones
        int n = x.length;

        for (int iteracion = 0; iteracion < maxIteraciones; iteracion++) {
            float[] yPredichos = new float[n];
            float sumaErrores = 0;
            for (int i = 0; i < n; i++) {
                yPredichos[i] = beta0 + beta1 * x[i];
                sumaErrores += (yPredichos[i] - y[i]) * (yPredichos[i] - y[i]);
            }

            float gradienteBeta0 = 0;
            float gradienteBeta1 = 0;
            for (int i = 0; i < n; i++) {
                gradienteBeta0 += (yPredichos[i] - y[i]); // Parcial con respecto a beta0
                gradienteBeta1 += (yPredichos[i] - y[i]) * x[i]; // Parcial con respecto a beta1
            }
            gradienteBeta0 *= 2.0f / n;
            gradienteBeta1 *= 2.0f / n;

            beta0 -= alpha * gradienteBeta0; // Actualización de beta0
            beta1 -= alpha * gradienteBeta1; // Actualización de beta1
        }

        return new float[]{beta0, beta1}; // Devuelve los coeficientes beta0 y beta1
    }
}
