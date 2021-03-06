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
        String name = "results/StephensonMethod" + f.index + ".txt";
        FileWriter writer = new FileWriter(name);
        double x0 = (r+l)/2;
        double x = x0 - Math.pow(f.f(x0), 2) / (f.f(x0 + f.f(x0)) - f.f(x0));
        while ( Math.abs(x - x0) > e){
            writer.append(String.valueOf(x)).append("\n");
            x0 = x;
            x = x0 - Math.pow(f.f(x0), 2) / (f.f(x0 + f.f(x0)) - f.f(x0));
        }
        writer.append(String.valueOf(x));
        writer.close();
        return x;
    }
}

class FixPointIterationMethod extends Methods { //МПІ
    @Override
    public double Do(double e, double r, double l, Func f) throws IOException {
        String name = "results/FixPointIterationMethod" + f.index + ".txt";
        FileWriter writer = new FileWriter(name);
        double alpha, gamma;
        if (f.der1(l) < f.der1(r)) {
            alpha = f.der1(l);
            gamma = f.der1(r);
        } else {
            alpha = f.der1(r);
            gamma = f.der1(l);
        }
        double lambda = 2 / (alpha + gamma);
        double x0 = l;
        double x = x0 - lambda * f.f(x0);
        double q = (gamma - alpha) / (gamma + alpha);
        if ( q < 0.5) {
            while (Math.abs(x0-x) > e * Math.abs((1-q)/q)) {
                writer.append(String.valueOf(x)).append("\n");
                x0 = x;
                x = x0 - lambda * f.f(x0);
            }
        } else {
            while (Math.abs(x0-x) > e) {
                writer.append(String.valueOf(x)).append("\n");
                x0 = x;
                x = x0 - lambda * f.f(x0);
            }
        }
        writer.append(String.valueOf(x));
        writer.close();
        return x;
    }
}