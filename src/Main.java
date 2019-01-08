public class Main {

    public static void main(String[] args) {
        Func f43 = new Func43();
        Func f47 = new Func47();

        Methods falsePositionMethod = new FalsePositionMethod();
        Methods fixPointIterationMethod = new FixPointIterationMethod();
        Methods stephensonMethod = new StephensonMethod();

        double e = 0.0000001;
        try {
            System.out.printf("\nФункция 47: на (0.3; 0.4) за методом хорд дает значение %.7f", falsePositionMethod.Do(e, 0.4, 0.3, f47));

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
