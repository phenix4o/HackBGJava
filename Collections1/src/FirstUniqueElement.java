import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FirstUniqueElement {
	public static void main(String... args) {
		Collection<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 5, 4, 3, 1);
		System.out.println(yourMethod(ints)); // 2;
	}

	private static int yourMethod(Collection<Integer> ints) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int result = 0;
		for (Integer i : ints) {
			if (hm.containsKey(i)) {
				Integer value = hm.get(i); 
				if (value == null)
					value = 0;
				value++;
				hm.put(i, value);
			}
			else{
				hm.put(i, 1);
			}
		}
		Iterator it = hm.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if((Integer) pair.getValue()==1){
	        	result = (Integer) pair.getKey();
	        }
	        it.remove(); // avoids a ConcurrentModificationException
	    } 
		return result;
	}
}
