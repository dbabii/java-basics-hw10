import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ExampleExceptionTest {

  /**
   * Test data for positive test.
   *
   * @return test data array
   */
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {1, 3, 3},
        {1, 1, 1}
    };
  }

  /**
   * Test data for exception test.
   *
   * @return test data array
   */
  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {-3, -2},
        {21, -1},
        {2, -1}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    assertEquals(ExampleException.rectangleArea(a, b), c);
  }

  @Test(dataProvider = "negativeData", expectedExceptions = IllegalArgumentException.class,
          expectedExceptionsMessageRegExp = "input value is below zero!")
  public void testRectangleAreaNegative(int a, int b) {
    ExampleException.rectangleArea(a,b);
  }

}