import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixFockingSubtitles {
	public static void main(String... args) {
		Path p = Paths.get("src/lost.s04e11.hdtv.xvid-2hd.srt");
		try {
			fixEncoding(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void fixEncoding(Path path) throws IOException {
		byte[] encoded = Files.readAllBytes(path);
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(new File("dest.txt")), "UTF-8"))) {
			bw.write(new String(encoded, "Windows-1251"));
		}
	}
}
