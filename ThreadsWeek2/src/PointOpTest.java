import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PointOpTest {
	public static Map<Point, Point> maps = new HashMap<Point, Point>();

	public static void main(String[] args) {
		final PointOperations p = new PointOperations();
		long time = System.currentTimeMillis();

		final List<Point> list = p.generatePoints();
		// Map<Point, Point> map = p.getNearestPoints(list);
		final Map<Point, Point> maps1 = new HashMap<Point, Point>();
		final Map<Point, Point> maps2 = new HashMap<Point, Point>();
		final Map<Point, Point> maps3 = new HashMap<Point, Point>();
		final Map<Point, Point> maps4 = new HashMap<Point, Point>();
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				p.doCalculations(list, 0, 25000, maps1);
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				p.doCalculations(list, 25000, 50000, maps2);
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				p.doCalculations(list, 50000, 75000, maps3);
			}
		});
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				p.doCalculations(list, 75000, 100000, maps4);
			}
		});
		t.start();
		t2.start();
		t3.start();
		t4.start();
		try {
			t.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		maps.putAll(maps1);
		maps.putAll(maps2);
		maps.putAll(maps3);
		maps.putAll(maps4);
		for(Point k : maps.keySet()){
			System.out.println(k.x+" "+k.y);
		}
		System.out.println(System.currentTimeMillis() - time+" "+maps.size() );

	}
}
