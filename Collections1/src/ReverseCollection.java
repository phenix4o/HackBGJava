import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


public class ReverseCollection {
	public static void main(String... args){
		List<Integer> list= new ArrayList<Integer>();
		list.add(2);
		list.add(3);
		list.add(10);
		reverse(list);
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
			
		}
	}
	static <T> void reverse (Collection<T> collection) {
		T [] array = (T[])new Object[collection.size()];
		collection.toArray(array);
		collection.clear();
		for(int j = 0;j<array.length;j++){
			collection.add(array[array.length-1-j]);
		}
	}
}
