

public class FaultyProblem6 {
    public static long pow(int a, int b) {
    	long result = 1;
		while (b > 0) {
			if (b % 2 == 0) {
				b = b / 2;
				a = a * a;
			} else {
				b--;
				result = result * a;
			}
		}
		return result;
    }
}
