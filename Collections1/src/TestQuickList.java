import java.util.Arrays;


public class TestQuickList {
	public static void main(String[] args){
		QuickList qlist = new QuickList();
		qlist.add(1);
		qlist.add(2);
		qlist.add(8);
		qlist.add(3);
		qlist.add(4);
		;
		System.out.println(qlist.getRange());
		for(Integer i : qlist){
			System.out.println(i);
		}
		System.out.println(Arrays.toString(qlist.getMode().toArray()));
		System.out.println(qlist.getMedian());
		
	}
}
