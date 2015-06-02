import java.util.HashMap;
import java.util.Map;

public class YourMethodTest {
	public static void main(String... args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("TU Sofiq", "4");
		map.put("FMI", "3");
		map.put("Soft Uni", "2");
		map.put("Hack Bulgaria", "1");

		System.out
				.println(YourUtilsClass.yourFirstUtilMethod((HashMap<? extends Object, ? extends Object>) map));
	}
}
