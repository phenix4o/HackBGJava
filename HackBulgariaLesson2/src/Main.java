import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	static List<List<Integer>> container = new ArrayList<List<Integer>>();

	public static void main(String... args) {


	    int array[] = {1,2,3 ,4,5};
		printPermutations(array,array.length);
	}
	public static void printPermutations(int[] array,int n) {
			if(n==1){
				System.out.println(Arrays.toString(array));
			}
			else{
				for(int i=0;i<n;i++){
					printPermutations(array, n-1);
					if(n%2!=0){
						int temp = array[array.length-1];
						array[array.length-1]=array[0];
						array[0]=temp;
						
					}
					else{
						int temp = array[array.length-1];
						array[array.length-1]=array[i];
						array[i]=temp;
					}
				}
			}
		 
	   }
	} 
