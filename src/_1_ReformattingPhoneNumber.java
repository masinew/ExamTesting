
public class _1_ReformattingPhoneNumber {
	public static void main(String[] args) {
		new _1_ReformattingPhoneNumber();
	}
	
	public _1_ReformattingPhoneNumber() {
		String s = "00-44  48 5555 8361";
		System.out.println(solution(s));
	}
	
	public String solution(String S) {
        // write your code in Java SE 8
		if (S == null) return S;
		
		S = S.replaceAll("-", "");
		S = S.replaceAll(" ", "");
		return reformat(S);
    }
	
	public String reformat(String s) {
		if (s.length() <= 3) {
			return s;
		}
		else if (s.length() == 4) {
			String firstTwo = s.substring(0, 2);
			String remaining = s.substring(2, s.length());
			return firstTwo + "-" + remaining;
		}
		else {
			String firstThree = s.substring(0, 3);
			String remaining = s.substring(3, s.length());
			return firstThree + "-" + reformat(remaining);
		}
	}
	
}
