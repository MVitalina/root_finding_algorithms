public class LobachevskyMethod {
    public LobachevskyMethod() {
    }

    public double[] Do(Poly poly){
        double a[] = poly.poly();
        double [] b = new double[a.length];
        double sum, stop;
        int p = 0;
        do {
            p++;
            for (int k = 0; k < a.length; k++){
                sum = 0;
                for (int j = 1; j <= a.length-k; j++){
                    if(k - j >= 0  && k + j < a.length)
                        sum += Math.pow(-1, j) * a[k - j] * a[k + j];
                }
                b[k] = Math.pow(a[k], 2) + 2 * sum;
            }
            sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += Math.pow((1 - b[i]/Math.pow(a[i], 2)), 2);
            }
            stop = Math.pow(sum, 0.5);
            System.arraycopy(b, 0, a, 0, a.length);
        } while (stop > 0.5);
        double [] x = new double[a.length-1];
        for (int i = 1; i < a.length; i++){
            x[i-1] = Math.pow((Math.abs(b[a.length-i-1]/b[a.length-i])), Math.pow(2,-p));
            x[1] = -x[1];
            if (Math.abs(poly.f(-x[i-1])) < Math.abs(poly.f(x[i-1])))
                x[i-1] = -x[i-1];
        }

        return x;
    }
}
