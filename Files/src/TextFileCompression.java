import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TextFileCompression {

	private static HashMap<String, String> map;

	public TextFileCompression() {
		map = new HashMap<String, String>();
	}

	public static void main(String... args) {
		TextFileCompression txt = new TextFileCompression();
		Path p = Paths.get("src/text.txt");
		Path p2 = Paths.get("src/in1.txt");
		try {
			txt.compress(p);
			txt.decompress(p2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void decompress(Path path) throws IOException {
		File file = new File(path.toString());
		FileReader fr = new FileReader(path.toString());
		BufferedReader br = new BufferedReader(fr);
		File out = new File("out1.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));
		String line = br.readLine();
		String[] words = line.split("~");

		for (String s : words) {
			System.out.println(s);
			for (String s1 : map.keySet()) {
				if ((map.get(s1)).equals("~"+s)) {
					bw.write(" " + s1);
					
				}
			}
		}
		br.close();
		bw.close();
	}

	void compress(Path path) throws FileNotFoundException,IOException {
		File file = new File(path.toString());
		FileReader fr = new FileReader(path.toString());
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String[] words = line.split(" ");
		int counter = 0;

		for (String s : words) {

			if (!map.containsKey(s)) {
				map.put(s, "~" + counter);
				counter++;
			}
		}
		File out = new File("out.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(out));
		for (String s : words) {
			if (map.containsKey(s)) {
				bw.write(map.get(s));
			}
			System.out.println(s);
		}
		br.close();
		bw.close();
	}

}
