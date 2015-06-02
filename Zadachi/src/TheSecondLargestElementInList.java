import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class TheSecondLargestElementInList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(100);
		list.add(200);
		list.add(-10);
		list.add(-20);
		list.add(100);
		list.add(22);
		int [] array = {1 , 8, 3 ,10 ,4 ,5 ,6 ,7,8,9,10};
		//System.out.println(findDuplicatingelement(array));
		LinkedList<Integer> a = new LinkedList<Integer>();
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		System.out.println(findMiddleElement(a));
		int max= Integer.MIN_VALUE;
		int sec_max = Integer.MIN_VALUE;
		for(int i = 0;i<list.size();i++){
			if(list.get(i)>=max){
				max = list.get(i);
			}
			else if(list.get(i)<=max&&sec_max<=list.get(i)){
				sec_max = list.get(i);
			}
		}
		//System.out.println(sec_max);
		//Collections.sort(list);
				//System.out.println(list.get(1));
		System.out.println(generateRandomInt(2, 14));
	}
	public static int generateRandomInt(int a, int b){
		double underLimitMultiplier = (double) a/1f;
		double upperLimitMiltiplier = (double) b/7f;
		int baseNumber = baseFunction(1,7);
		if(baseNumber<=1){
			baseNumber = (int) ((int) baseNumber*upperLimitMiltiplier); 
		}else if(baseNumber>=7){
			baseNumber = (int) ((int) baseNumber/underLimitMultiplier); 
		}
		return baseNumber;
	}
	public static  int baseFunction(int a,int b){
		Random r = new Random();
		int number = r.nextInt(b) + a;
		return number;
	}
	
	public int binarySearch(int [] array,int element){
		int index = (array.length-1)/2;
		if(element>array[index]){
			
		}
		return 0;
	}
	public static int findDuplicatingelement(int [] array){
		int temp = array[array.length-1];
		int duplicatedElement = 0;
		for(int i= 1;i<array.length;i++){
			if(array[i] != temp){
				temp = array[i--];
			}else{
				duplicatedElement = temp;
			}
		}
		return duplicatedElement;
	}
	public static int findMiddleElement(LinkedList<Integer> a){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addAll(a);
		int counter = 0;
		while(!list.isEmpty()){
			list.poll();
			counter++;
		}
		return a.get((counter)/2);
	}
}
