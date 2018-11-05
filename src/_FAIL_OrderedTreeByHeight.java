

public class _FAIL_OrderedTreeByHeight {
	public static void main(String[] args) {
		new _FAIL_OrderedTreeByHeight();
	}
	
	public _FAIL_OrderedTreeByHeight() {
//		int[] A = {3,4,5,4};
//		int[] A = {4,5,2,3,4};
//		int[] A = {1,2,3,3,5,6,7};
//		int[] A = {1,3,8,5,6,7};
//		int[] A = {1,2,5,3,4,99};
		int[] A = { 2,5,7,7,5};
		System.out.println("Result: " + solution(A));
	}
	
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		int result = 0;
		if (A == null || A.length == 0) return result;
		
		int arrSize = A.length;
		for (int i=0; i<arrSize; i++) {
			if (i+1 >= arrSize) {
				result++;
				break;
			}
			
			int currentValue = A[i];
			int nextValue = A[i+1];
			if (currentValue <= nextValue) {
				result++;
				continue;
			}
			else {
				System.out.println(currentValue);
				result = 0;
				boolean isPass = checkIssue(A, i, i+1);
				if (isPass) {
					result = 1;
					if (i+2 == arrSize) {
						result += 1;
					}
				}
				
				break;
			}
		}
		
		return result;
    }
	
	public boolean checkIssue(int A[], int currentIndex, int issueIndex) {
		boolean isPass = true;
		for (int i=0; i<currentIndex; i++) {
			int checkValue = A[i];
			int issueValue = A[issueIndex];
			if (checkValue <= issueValue) {
				continue;
			}
			
			isPass = false;
			break;
		}
		
		return isPass;
	}
}
