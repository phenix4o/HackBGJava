import java.util.Stack;

public class Brackets {
	public static void main(String... args) {
		Stack<Integer> st = new Stack<Integer>();
		String c ="" ;
		int counter = 0;
		int index = 0;
		String string = "())";
		while (index < string.length() && string.charAt(0) == '('
				&& string.charAt(string.length() - 1) == ')') {

			if (string.charAt(index) == '(') {
				st.push(1);
			} else if (string.charAt(index) == ')') {
				if (!st.isEmpty()) {
					st.pop();
				} else {
					string = new String("Bad expression");
					break;
				}
			}
			index++;
		}
		if (st.isEmpty()&&!string.equals("Bad expression")&& string.charAt(0) == '('
				&& string.charAt(string.length() - 1) == ')') {
			string = new String("Good expression");
		}
		else{
			string = new String("Bad expression");
		}
		System.out.println(string);
	}
}
