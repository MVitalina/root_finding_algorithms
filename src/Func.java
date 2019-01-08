import static java.lang.Math.*;

public abstract class Func {
    public Func() {}

    public int index;

    public abstract double f(double x);

    public abstract double der1(double x);

    public abstract double der2(double x);

    public abstract double fX(double x); // x = func(x)
}

class Func43 extends Func{

    public Func43(){
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

    @Override
    public double der2(double x){
        return ( sin(x) * (2 - 1/(4*pow((5-x), 1.5)) - pow((5-x), 0.5)) + cos(x) * (x - 1/pow((5-x), 0.5)) );
    }

    @Override
    public double fX(double x){
        return 0;
    }
}

class Func47 extends Func{

    public Func47(){
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

    @Override
    public double der2(double x){
        return (-x * cosh(x-PI) * sin(cosh(x - PI)) - sinh(x-PI)*(2*sin(cosh(x-PI)) + x * sinh(x-PI)*cos(cosh(x-PI))));
    }

    @Override
    public double fX(double x){
        return 0;
    }
}