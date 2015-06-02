import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {
	private static Object instance = null;
	public static FileUtils getInstance(){
		if(instance ==null){
			instance = new FileUtils();
		}
		return (FileUtils) instance;
	}
	private FileUtils() {
	}

	String readFrom(File file) throws FileNotFoundException,IOException {
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new FileReader(file.toString()));

		while (br.readLine() != null) {
			sb.append(br.readLine());
		}
		Path path = file.toPath();
		readFrom(path);
		return sb.toString();
	}
	void writeTo(String str,File file) throws IOException{
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsolutePath());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(str);
		bw.close();
	}
	
	
	void writeTo(String str,Path path) throws IOException{
		File f = new File(path.toString());
		writeTo(str, f);
	}
	
	
	String readFrom(Path path) throws FileNotFoundException,IOException {
		File f = new File(path.toString());
		return readFrom(f);
	}
	
}
