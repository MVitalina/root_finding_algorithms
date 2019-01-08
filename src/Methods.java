import java.io.FileWriter;
import java.io.IOException;

public abstract class Methods {
    public Methods() {
    }
    public abstract double Do(double e, double r, double l, Func f) throws IOException;
}

class FalsePositionMethod extends Methods { //метод хорд
    @Override
    public double Do(double e, double b, double a, Func f) throws IOException {
        String filename = "results/FalsePositionMethod" + f.index + ".txt";
        FileWriter writer = new FileWriter(filename);
        double c = a - (f.f(a) * (b - a) / (f.f(b) - f.f(a)));
        double f_l = f.f(a);
        double f_r = f.f(b);
        double f_m = f.f(c);
        while (Double.compare(Math.abs(b-a),e) > 0) {
            if (f_m * f_r < 0) {
                a = c;
                f_l = f_m;
            } else
            if (f_m * f_l < 0) {
                b = c;
                f_r = f_m;
            }
            writer.append(String.valueOf(c)).append("\n");
            c = a - (f.f(a) * (b - a) / (f.f(b) - f.f(a)));
            f_m = f.f(c);
        }
        writer.append(String.valueOf(c));
        writer.close();
        return c;
    }
}

class StephensonMethod extends Methods {
    @Override
    public double Do(double e, double r, double l, Func f) throws IOException {
        return 0;
    }
}

class FixPointIterationMethod extends Methods { //МПІ
    @Override
    public double Do(double e, double r, double l, Func f) throws IOException {
        return 0;
    }
}