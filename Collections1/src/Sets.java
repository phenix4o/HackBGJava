import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets {
	public static void main(String... args) {
		Set A = new HashSet<Integer>();
		Set B = new HashSet<Integer>();
		Set C = new HashSet<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		B.add(4);
		B.add(5);
		B.add(6);
		C.add(5);
		C.add(6);
		C.add(7);
		C.add(8);
		System.out.println(Arrays.toString(yourMethd(A, B, C).toArray()));
	}

	private static Set yourMethd(Set a, Set b, Set c) {
		Set duplicatedElements = new HashSet<Integer>();
		for (Object obj : a) {
			if (b.contains(obj) && c.contains(obj)) {
				duplicatedElements.add(obj);
			}
		}
		return duplicatedElements;
	}
}
