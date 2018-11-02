
public class OrderedTreeByHeightByPJoe {
	public static void main(String[] S) {
		// int[] A = {3,4,5,4};
		// int[] A = {4,5,2,3,4};
		// int[] A = {1,2,3,3,5,6,7};
		// int[] A = {3,4,5,4};
		// int[] A = {4,5,2,3,4};
		// int[] A = {1,2,3,3,5,6,7};
		// int[] A = {1,3,8,5,6,7};
		int[] A = { 2,5,7,7,5 };

		int c = 0;
		if (A == null) {
			System.out.println("Array is null 1.");
			// return c;
		} else if (A.length == 0) {
			System.out.println("Array is null 2.");
			// return c;
		} else {
			boolean chk = true;
			for (int i = 0; i < A.length; i++) {

				chk = funcV(A, i);
				if (chk == true) {
					c++;
				}
			}
			System.out.println("c=" + c);

			// return c;

			// return c;
		}
	}

	public static boolean funcV(int[] A, int ind) {
		boolean chk = true;
		int count = 0;
		int[] B = new int[A.length - 1];
		for (int i = 0; i < A.length; i++) {
			if (i != ind) {
				B[count] = A[i];
				count++;
			}

		}

		for (int i = 0; i < B.length; i++) {
			if (i > 0) {

				if (B[i - 1] > B[i]) {
					chk = false;
					break;
				}
			}
		}

		return chk;
	}
}
