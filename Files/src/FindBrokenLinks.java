import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotLinkException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FindBrokenLinks {
	public void printAllBrokenLinks(Path path) throws IOException {
		List<String> list = testLink(path);
		for (String put : list) {
			System.out.println(put);
		}
	}

	public static void main(String... args) throws IOException {
		File file = new File("src/Downloads");
		List<String> list = testLink(file.toPath());
		System.out.println(list.size());
	}

	public static List<String> testLink(Path path) throws IOException {
		List<String> list = new ArrayList<String>();
		File file = new File(path.toString());
		if (file.listFiles() != null) {
			for (File f : file.listFiles()) {
				try {
					if (Files.isSymbolicLink(Paths.get(f.getPath()))
							&& Files.readSymbolicLink(path) != path
							&& f.isFile()) {
						System.out.println("testing dir for syminks");
						testLink(Files.readSymbolicLink(path));
					} else {
						list.add(f.getParent());
					}
				} catch (NotLinkException e) {

					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else if(Files.isSymbolicLink(Paths.get(file.getPath()))
				&& Files.readSymbolicLink(path) != path
			){
			System.out.println(file.isDirectory());
		}
		else{
			list.add(file.toPath().toString());
		}
		return list;
	}
}
