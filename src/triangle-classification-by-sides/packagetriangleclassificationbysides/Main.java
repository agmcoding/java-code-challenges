package packagetriangleclassificationbysides;

public class Main {

//	Challenge:
//		
//	Do an algorithm that receives 3 values, representing the sides of a triangle. 
//	Check if the values can make a triangle and classify as:
//		
//	a) Equilateral (three equal sides)
//	b) Isosceles (two equal sides)
//	c) Scalene (three different sides)
  
  public static void main(String[] args) {

    double side1 = 3;
    double side2 = 4;
    double side3 = 5;
    
    System.out.println(classifyTriangleBySides(side1, side2, side3));

    /* Output Result:
     *
     * Scalene
     *
     */
    
  }

  static String classifyTriangleBySides(double side1, double side2, double side3) {

    if (!triangleExists(side1, side2, side3))
      return "This triangle doesn't exist";

    return side1 != side2 && side1 != side3 && side2 != side3 ? "Scalene"
        : side1 == side2 && side2 == side3 ? "Equilateral" : "Isosceles";
  }


  
  
  private static boolean triangleExists(double side1, double side2, double side3) {
    
    double highestSide = highestSideOfTriangle(side1, side2, side3);
    
    /* If the sum of the smallest sides isn't bigger than the highest side, then the triangle doesn't exist */
    double sumOfSmallestSides = side1 == highestSide ? side2 + side3
        : side2 == highestSide ? side1 + side3 : side1 + side2;
    if (sumOfSmallestSides <= highestSide)
      return false;

    return true;
  }

  
  
  
  private static double highestSideOfTriangle(double side1, double side2, double side3) {
    return side1 > side2 && side1 > side3 ? side1 : side2 > side3 ? side2 : side3;
  }
  
  /*
   * Alternative way for finding the highest side of the triangle, with max() method from Math class:
   * 
   * double possibleHighestSide1 = Math.max(side1, side2);
   * double possibleHighestSide2 = Math.max(side1, side3);
   * double highestSide = Math.max(possibleHighestSide1, possibleHighestSide2);
   * 
   */
  
}
