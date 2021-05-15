package group17;

public class ExponentialFunction {
    public double compute(double d) throws Exception{
        if (d != (int) d){
            throw new Exception("Only integers are allowed");
        }
        double res = 1;
        for(int i = 0; i < Math.abs(d); i++){
            res = res * Math.E;
        }
        if (d < 0){
            res = 1/res;
        }
        return res;
    }
    public boolean checkNumber(double d, NumberChecker nc){
        return nc.isGreaterThan1(d);
    }
}
