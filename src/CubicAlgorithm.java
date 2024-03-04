public class CubicAlgorithm {
    private final double a;
    private final double b;
    private final double c;
    private final double d;

    public CubicAlgorithm(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    private double w() {
        return (-b) / (3 * a);
    }

    private double p() {
        return (3 * a * Math.pow(w(), 2) + 2 * b * w() + c) / a;
    }

    private double q() {
        return (a * Math.pow(w(), 3) + b * Math.pow(w(), 2) + c * w() + d) / a;
    }

    private double delta() {
        return Math.pow(q(), 2) / 4 + Math.pow(p(), 3) / 27;
    }

    private double fi() {
        return Math.acos((3 * q()) / (2 * p() * Math.sqrt(-(p() / 3))));
    }

    private double u() {
        return Math.cbrt(-q() / 2.0 + Math.sqrt(delta()));
    }

    private double v() {
        return Math.cbrt(-q() / 2.0 - Math.sqrt(delta()));
    }

    private double deltaBiggerThanZero() {
        return u() + v() + w();
    }

    private double[] deltaEqualToZero() {
        double[] result = new double[2];

        result[0] = w() - 2 * Math.cbrt(q() / 2);
        result[1] = w() + Math.cbrt(q() / 2);

        return result;
    }

    private double[] deltaSmallerThanZero() {
        double[] result = new double[3];

        result[0] = w() + 2 * Math.sqrt(-(p() / 3.0)) * Math.cos(fi() / 3.0);
        result[1] = w() + 2 * Math.sqrt(-(p() / 3.0)) * Math.cos(fi() / 3.0 + (2.0 / 3.0 * Math.PI));
        result[2] = w() + 2 * Math.sqrt(-(p() / 3.0)) * Math.cos(fi() / 3.0 + (4.0 / 3.0 * Math.PI));

        return result;
    }

    public void calculate() {
        switch (Double.compare(delta(), 0)) {
            case 1:
                double x1 = deltaBiggerThanZero();
                System.out.println("Delta > 0, x1 = " + x1);
                break;
            case -1:
                double[] solutions = deltaSmallerThanZero();
                System.out.println("Delta < 0, x1 = " + solutions[0] + ", x2 = " + solutions[1] + ", x3 = " + solutions[2]);
                break;
            case 0:
                double[] solutionsEqual = deltaEqualToZero();
                System.out.println("Delta = 0, x1 = " + solutionsEqual[0] + ", x2 = x3 = " + solutionsEqual[1]);
                break;
        }
    }
}
