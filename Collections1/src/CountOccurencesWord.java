import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountOccurencesWord {
	private static Map<String, Integer> result;

	public static void main(String... args) {
		yourSecondUtilMethod("Ninjas are all over the place! We are all going to die!");
		System.out.println(yourFirstUtilMethod());
	}

	public static void yourSecondUtilMethod(String split) {
		result = new LinkedHashMap<String, Integer>();
		String[] splited = split.split("\\s+");
		for (int i = 0; i < splited.length; i++) {
			if (result.containsKey(splited[i])) {
				result.put(splited[i], result.get(splited[i]) + 1);
			} else {
				result.put(splited[i], 1);
			}
		}
	}

	public static String yourFirstUtilMethod() {
		Set keys = result.keySet();
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			String key = (String) i.next();
			Integer value = (Integer) result.get(key);
			if (counter == 0) {
				sb.append("{ " + key + ":" + value + ", ");
				counter++;
			} else if (counter == result.size() - 1) {
				sb.append(key + ":" + value + " }");
			} else {
				sb.append(key + ":" + value + ", ");
				counter++;
			}

		}
		return sb.toString();

	}
}
