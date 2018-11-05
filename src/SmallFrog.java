/**
 * Created by champ on 4/11/2018 AD.
 */
public class SmallFrog {
    public static void main(String[] args) {
        new SmallFrog();
    }

    public SmallFrog() {
        System.out.println(solution(10, 85, 30));
    }

    public int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int result = (Y-X)/D;
        int mod = (Y-X)%D;
        if (mod > 0) {
            return ++result;
        }
        else {
            return result;
        }
    }
}
