public abstract class Methods {
    public Methods() {
    }
    public abstract double Do(double e, double r, double l, Func f);
}

class FalsePositionMethod extends Methods { //метод хорд
    @Override
    public double Do(double e, double r, double l, Func f) {
        return 0;
    }
}

class StephensonMethod extends Methods {
    @Override
    public double Do(double e, double r, double l, Func f) {
        return 0;
    }
}

class FixPointIterationMethod extends Methods { //МПІ
    @Override
    public double Do(double e, double r, double l, Func f) {
        return 0;
    }
}