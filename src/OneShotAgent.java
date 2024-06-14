import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class OneShotAgent extends Agent {
  protected void setup() {
    System.out.println("Agent "+ getLocalName() + " started.");
    addBehaviour(new MyOneShotBehaviour());
  } 

  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
        DataSet dataSet = new DataSet();
        float[] x = dataSet.getX();
        float[] y = dataSet.getY();

        RegresionLineal2 gradientDescent = new RegresionLineal2();
        double[] coefficients = gradientDescent.calculateGradientDescent(x, y, 0.000008, 1000000, 5.3);
        System.out.println("Coeficiente beta0: " + coefficients[0]);
        System.out.println("Coeficiente beta1: " + coefficients[1]);

        float correlation = CorrelationCoefficient.calculateCorrelationCoefficient(dataSet.getX(), dataSet.getY());
        System.out.println("Coeficiente de correlación: ");
        System.out.println(correlation);
        System.out.println("Coeficiente de Determinación");
        System.out.println(correlation * correlation);


        double beta0 = coefficients[0];
        double beta1 = coefficients[1];
        double[] valoresX = {35, 40, 45};
        for (double valorX : valoresX) {
            double prediccion = beta0 + beta1 * valorX;
            System.out.println("Para x = " + valorX + ", la predicción es: " + prediccion);
        }
        }



      public int onEnd() {
       myAgent.doDelete();
       return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}  
