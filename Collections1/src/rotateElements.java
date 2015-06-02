import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class rotateElements {
	public static void main(String... args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		rotate(list, -5);
	}

	static <T> void rotate(Collection<Integer> collection, int rotateStep) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(Integer c : collection){
			list.add(c);
		}
		while(rotateStep>0){
			list.addFirst(list.getLast());
			list.removeLast();
			rotateStep--;
		}
		while(rotateStep<0){
			list.addLast(list.getFirst());
			list.removeFirst();
			rotateStep++;
		}		
	//	Collections.rotate(list, rotateStep);
		collection.clear();
		for(Integer c : list){
			collection.add(c);
			System.out.print(c);
		}
	}
}
