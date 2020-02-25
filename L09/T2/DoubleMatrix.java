public class DoubleMatrix extends GenericMatrix<Double> {
  @Override /** Add two doubles */
  protected Double add(Double o1, Double o2) {
    return o1 + o2;
  }

  @Override /** Multiply two doubles */
  protected Double multiply(Double o1, Double o2) {
    return o1 * o2;
  }

  @Override /** Specify zero for a double */
  protected Double zero() {
    return 0.0;
  }
}


