import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;

public class WcCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path p = Paths.get("src/bla.txt");
		File f = new File(p.toString());
		try {
			WordCountResult wcr = wordCount(f);
			System.out.println(wcr.getCountWord());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static WordCountResult wordCount(File file) throws FileNotFoundException, IOException{
		String string = file.getPath();
		Path path = Paths.get(string);
		return wordCount(path);
	}
	public static WordCountResult wordCount(Path path)
			throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(path.toString());
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int countWords = 0;
		int countLine = 0;
		int countChars = 0;
		while (line != null) {
			countLine++;
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens()) {
				countWords++;
				String string = st.nextToken();
				for (int i = 0; i < string.length(); i++) {
					countChars++;
				}
			}
			line = br.readLine();
		}

	
		return new WordCountResult(countWords, countLine, countChars);
	}
}
