import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class YourUtilsClass {
	

	public static String yourFirstUtilMethod(
			HashMap<? extends Object, ? extends Object> hm) {
		Set keys = hm.keySet();
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			String key = (String) i.next();
			String value = (String) hm.get(key);
			if (counter == 0) {
				sb.append("{ " + key + ":" + value + ", ");
				counter++;
			} else if (counter == hm.size() - 1) {
				sb.append(key + ":" + value + " }");
			} else {
				sb.append(key + ":" + value + ", ");
				counter++;
			}

		}
		return sb.toString();

	}
}
