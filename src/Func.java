import static java.lang.Math.*;

public abstract class Func {
    Func() {}

    public int index;

    public abstract double f(double x);

    public abstract double der1(double x);
}

class Func43 extends Func{

    Func43(){
        this.index = 43;
    }

    @Override
    public double f(double x){
        return ( pow((5-x), 0.5) * sin(x) + x * cos(PI - x) );
    }

    @Override
    public double der1(double x){
        return ( sin(x) * (x - 1/(2*pow((5-x), 0.5))) + cos(x) * (pow((5-x), 0.5) - 1) );
    }
}

class Func47 extends Func{

    Func47(){
        this.index = 47;
    }

    @Override
    public double f(double x){
        return (x * cos(cosh(x - PI)) + 0.3 * x);
    }

    @Override
    public double der1(double x){
        return (cos(cosh(x - PI)) - x * sinh(x-PI) * sin(cosh(x - PI)) + 0.3);
    }
}