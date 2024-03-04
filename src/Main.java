public class Main {
    public static void main(String[] args) {
        CubicAlgorithm cardanoAlgorithm1 = new CubicAlgorithm(-3, -5, 1, 1);

        cardanoAlgorithm1.calculate();

        CubicAlgorithm cardanoAlgorithm2 = new CubicAlgorithm(1, 1, 1, 1);

        cardanoAlgorithm2.calculate();
    }
}