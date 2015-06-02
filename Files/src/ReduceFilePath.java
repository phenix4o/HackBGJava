import java.nio.file.Path;
import java.nio.file.Paths;


public class ReduceFilePath{
	public static Path reduceFilePath(Path path){
		return path.normalize();
	}
	public static void main(String... args){
		String s = "home//radorado/code/./hackbulgaria/week0/../";
		Path p = Paths.get(s);
		System.out.println(reduceFilePath(p).toString());
	}
}
