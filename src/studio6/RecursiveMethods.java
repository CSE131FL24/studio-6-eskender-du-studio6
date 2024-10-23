package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		
			// FIXME compute the geometric sum for the first n terms recursively
		if(n==0) {
			return 0;
		}
		return geometricSum(n-1)+Math.pow(0.5, n);
	}
		
	
	
	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {
		
		// FIXME
		if (radius<radiusMinimumDrawingThreshold) {
			return;
		}
		StdDraw.circle(xCenter, yCenter, radius);
		
		double newradius = radius/3.0;
//		up
		circlesUponCircles(xCenter,yCenter+radius,newradius,radiusMinimumDrawingThreshold);
//		down
		circlesUponCircles(xCenter,yCenter-radius,newradius,radiusMinimumDrawingThreshold);
//		left
		circlesUponCircles(xCenter-radius,yCenter,newradius,radiusMinimumDrawingThreshold);
//		right
		circlesUponCircles(xCenter+radius,yCenter,newradius,radiusMinimumDrawingThreshold);
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		
			// FIXME create a helper method that can recursively reverse the given array
		 if (array == null || array.length <= 1) {
	            return array;
	        }
	        
	        // Create a copy of the array to reverse
	        int[] reversedArray = new int[array.length];
	        System.arraycopy(array, 0, reversedArray, 0, array.length);

	        // Call the helper method
	        reverseHelper(reversedArray, 0, array.length - 1);
	        return reversedArray;
		
	}
	private static void reverseHelper(int[] array, int start, int end) {
        // Base case: if start index crosses the end index, stop the recursion
        if (start >= end) {
            return;
        }

        // Swap the elements at start and end indices
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        // Recursive call with next indices
        reverseHelper(array, start + 1, end - 1);
    }
	
	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		
			// FIXME compute the gcd of p and q using recursion
			if(q==0) {
				return p;
			}
			return gcd(q,p%q);
		
	}

}
