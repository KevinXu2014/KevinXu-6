/*
 * 6 - Maximum yield

You are a Science Engineer on the Federation mining freighter Daedalus. Your team mines strips for a special type of dilithium that is rare and particularly volatile. This has certain implications.

When your team mines a square in the strip, the trace amounts of dilithium that remain become charged for years. Your team simply cannot mine two squares that are side by side or this would result in an explosion and destroy the planet.

The ship¡¯s sensors can detect the quantity of dilithium in each square in advance. Your team needs to know the optimal squares it should mine, as well as the total yield from a strip of any size so they can bring it before the captain for final approval.

Two strip examples:

[ 206, 140, 300, 52, 107 ] should return 613 units, as mining the first, third, and fifth squares is optimal [ 206, x, 300, x, 107 ]

[ 147, 206, 52, 240, 300 ] should return 506 units, as mining the second and fifth squares is optimal [ x, 206, x, x, 300 ]

		
The output in console:

Total should return 904 units
The original mine is  147 206 52 240 300 1 20 398 
The optimal is  0 206 0 0 300 0 0 398 
		
*
*/

public class Maximumyield {

	// result will hold the result of which numbers get selected
	public static int[] result;

	// use recursive algorithm
	public int max(int[] n) {

		int len = n.length;

		// Assume the array has at least 1 element and every element in array is
		// greater than 0

		// if the array has 1 element
		if (len == 1) {
			result[0] = n[0];
			return n[0];
		}

		// if the array has 2 elements
		if (len == 2)
			if (n[0] > n[1]) {
				result[0] = n[0];
				result[1] = 0;
				return n[0];
			} else {
				result[1] = n[1];
				result[0] = 0;
				return n[1];
			}

		// if the array has more than 2 elements
		int[] n1 = new int[len - 1];
		System.arraycopy(n, 0, n1, 0, len - 1);

		int[] n2 = new int[len - 2];
		System.arraycopy(n, 0, n2, 0, len - 2);

		if ((n[len - 1] + max(n2)) > max(n1)) {
			result[len - 1] = n[len - 1];
			result[len - 2] = 0;
			return n[len - 1] + max(n2);
		} else {
			result[len - 2] = n[len - 2];
			result[len - 1] = 0;
			return max(n1);
		}

	}

	// main method
	public static void main(String[] args) {
		// test with a simple array
		int[] n = {147, 206, 52, 240, 300, 1, 20, 398};


		result = new int[n.length];

		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}

		Maximumyield maxyield = new Maximumyield();

		System.out.println("Total should return " + maxyield.max(n) + " units");

		System.out.print("The original mine is  ");
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}

		System.out.println("");

		System.out.print("The optimal is  ");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}
}
