public class Main {

    public static void main(String[] args) {
        Func f43 = new Func43();
        Func f47 = new Func47();

        Methods falsePositionMethod = new FalsePositionMethod();
        Methods fixPointIterationMethod = new FixPointIterationMethod();
        Methods stephensonMethod = new StephensonMethod();

        double e = 0.0000001;
        try {
            System.out.printf("\nФункция 47 на (0.3; 0.4) за методом хорд дает значение %.7f\n", falsePositionMethod.Do(e, 0.4, 0.3, f47));
            System.out.printf("\nФункция 43 на (4.5; 4.8) за методом Стефенсона дает значение %.7f\n", stephensonMethod.Do(e, 4.8, 4.5, f43));
            System.out.printf("\nФункция 43 на (4.5; 4.8) за методом простых итераций дает значение %.7f\n", fixPointIterationMethod.Do(e, 4.8, 4.5, f43));

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        Poly p8 = new Poly8();
        p8.printSolution();
    }
}
