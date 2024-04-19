# Description

Code challenge: "Triangle Classification by Sides"

Do an algorithm that receives 3 values, representing the sides of a triangle.

Check if the values can make 1 triangle and **classify** as:

Equilateral (three equal sides)\
Isosceles (two equal sides)\
Scalene (three different sides)

**Note** that if the sum of the smallest sides is not bigger than the highest side, then the triangle does not exist.

## Example 1

**Input**: `side1 = 3, side2 = 4, side3 = 5`\
**Output**: `"Scalene"`\
**Explanation**: All three sides are different from each other and can make a triangle.

## Example 2

**Input**: `side1 = 1, side2 = 2, side3 = 3`\
**Output**: `"This triangle does not exist"`\
**Explanation**:\
The sum of the smallest sides `1 + 2 = 3` is equal to the highest side.\ 
For a real triangle, the sum of the smalllest sides must be bigger than the highest one.\
Thus, this triangle does not exist.

