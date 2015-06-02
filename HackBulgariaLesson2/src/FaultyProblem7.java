

import java.lang.Thread.State;

public class FaultyProblem7 {
    public static int binarySearch(int element, int... array) {
//        Utils.killMeIfIGetStuck();

        int low = 0;
        int high = array.length - 1;
        
       
        while (high - low > 1) {
        	 int mid = (low + high) / 2;
            if (element == array[mid]) {
            	
                return array[mid];
            }
            if (element < array[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        if (array[high] == element)
            return high;
        if (array[low] == element)
            return low;

        return -1; // not found
    }
}
