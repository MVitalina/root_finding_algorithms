public abstract class Poly {
    public Poly() {}

    public abstract double [] poly();

    public abstract double f(double x);

    public abstract void printSolution();

}

class Poly8 extends Poly{

    @Override
    public double[] poly() { //inverse order
        return new double[]{
                3, 131, 514, -209, -634, 280, 119, -55
        };
    }

    @Override
    public double f(double x) {
        return (-55 * Math.pow(x, 7) + 119 * Math.pow(x, 6) + 280 * Math.pow(x, 5) - 634 * Math.pow(x, 4) - 209 * Math.pow(x, 3) + 514 * Math.pow(x, 2) + 131 * x + 3);
    }


    @Override
    public void printSolution(){
        LobachevskyMethod lobachevskyMethod = new LobachevskyMethod();
        double [] x = lobachevskyMethod.Do(this);
        System.out.println("Решение полинома по методу Лобачевского:");
        for (int i = 0; i < x.length; i++){
            System.out.printf("\nx%d = %.3f", i, x[i]);
        }
    }
}
