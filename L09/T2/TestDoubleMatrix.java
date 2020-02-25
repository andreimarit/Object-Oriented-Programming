public class TestDoubleMatrix {
  public static void main(String[] args) {
    // Create Double arrays m1, m2
    Double[][] m1 = new Double[][]{{1.5, 2.5, 3.5}, {4.5, 5.5, 6.5}, {1.5, 1.5, 1.5}};
    Double[][] m2 = new Double[][]{{1.5, 1.5, 1.5}, {2.5, 2.5, 2.5}, {0.5, 0.5, 0.5}};

    // Create an instance of IntegerMatrix
    DoubleMatrix doubleMatrix = new DoubleMatrix();

    System.out.println("\nm1 + m2 is ");
    GenericMatrix.printResult(
      m1, m2, doubleMatrix.addMatrix(m1, m2), '+');

    System.out.println("\nm1 * m2 is ");
    GenericMatrix.printResult(
      m1, m2, doubleMatrix.multiplyMatrix(m1, m2), '*');
  }
}
