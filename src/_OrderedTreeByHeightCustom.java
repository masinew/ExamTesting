
public class _OrderedTreeByHeightCustom {
	public static void main(String[] S) {
		new _OrderedTreeByHeightCustom();
	}
	
	public _OrderedTreeByHeightCustom() {
//		 int[] A = {3,4,5,4}; // 2
//		 int[] A = {4,5,2,3,4}; // 0
//		 int[] A = {1,2,3,3,5,6,7}; // 7
//		 int[] A = {1,3,8,5,6,7}; // 1
		int[] A = { 2,5,7,7,5 }; // 1
		System.out.println("result: " + solution(A));

		
	}
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		int count = 0;
		if (A == null || A.length == 0) return count;
		
		for (int i=0; i<A.length; i++) {
			boolean checker = true;
			int[] reorderArr = reorder(A, i);
			for (int j=0; j<reorderArr.length; j++) {
				if (j > 0) {
					if (reorderArr[j - 1] > reorderArr[j]) {
						checker = false;
						break;
					}
				}
			}
			
			if (checker) count++;
		}
		
		return count;
    }
	
	private int[] reorder(int[] a, int ignoreIndex) {
		int[] arr = new int[a.length - 1];
		int indexCounter = 0;
		for (int i=0; i<a.length; i++) {
			if (i != ignoreIndex) {
				arr[indexCounter] = a[i];
				indexCounter++;
			}
		}
		
		return arr;
	}

}
