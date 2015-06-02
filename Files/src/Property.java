import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Property {
	public static void main(String... args) {
		Map<String, String> m = new HashMap<String, String>();
		SetUp();
		try {
			m = parseProperties();
			for (String s : m.keySet()) {
				System.out.println("Key: " + s + " " + "Value: " + m.get(s));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static  void SetUp() {
		Properties prop = new Properties();
		OutputStream output = null;
		try {

			output = new FileOutputStream("config.properties");

			prop.setProperty("#", " this=comment");
			prop.setProperty("a1", "b1");
			prop.setProperty("a2 ", "b2");
			prop.setProperty("a3    ", "   b3");
			prop.setProperty("      a4 ", " b4");
			prop.setProperty("a5", "b6=b7=b8");
			prop.setProperty("a6", "b9 #comment ");
			prop.setProperty("a7", "=b10");
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	static Map<String, String> parseProperties() throws IOException {
		Properties prop = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		InputStream is = new FileInputStream("config.properties");
		prop.load(is);
		Set keys = new LinkedHashSet();
		keys = prop.keySet();
		HashMap<String,Object> newMap=new HashMap<>();
		for(Object entry: keys){
			String value = new String(prop.getProperty(entry.toString()));
		    newMap.put(entry.toString().trim(),value.trim());
		} 
		
		
		
		List<String> list = new ArrayList<String>();
		
		for (Object o : newMap.keySet()) {
			
			list.add(o.toString());
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (Object t : list) {
			if (!t.toString().startsWith("#")) {
				map.put(t.toString(), (String) newMap.get(t.toString()));
			}
			sb.append("\n");
		}
		return map;
	}

}
