import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PointOperations {
	
	public static List<Point> generatePoints() {
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < 100000; i++) {
			Random rand = new Random();
			int x = rand.nextInt(10000);
			int y = rand.nextInt(10000);
			list.add(new Point(x, y));
		}
		return list;

	}
	
	
	public Map<Point, Point> getNearestPoints(List<Point> generatedPoints) {
		Map<Point, Point> map = new HashMap<Point, Point>();
		Point p = new Point(0, 0);
		for (int i = 0; i < generatedPoints.size() - 1; i++) {
			double distance = Double.MAX_VALUE;
			for (int j = 1; j < generatedPoints.size(); j++) {
				double value = Math.sqrt(Math.pow(generatedPoints.get(i).x
						- generatedPoints.get(j).x, 2)
						+ Math.pow(
								generatedPoints.get(i).y
										- generatedPoints.get(j).y, 2));
				if (value < distance) {
					distance = value;
					p.setX(generatedPoints.get(j).x);
					p.setY(generatedPoints.get(j).y);
				}
				if (j == generatedPoints.size() - 1) {
					map.put(generatedPoints.get(i), p);
				}
			}
		

		}
		return map;
	}
	
	
	void doCalculations(List<Point> inPoints, int indexFrom, int indexTo, Map<Point, Point> outMap){
		Point p = new Point(0, 0);
		for (int i = indexFrom; i < indexTo - 1; i++) {
			double distance = Double.MAX_VALUE;
			for (int j = i+1; j < inPoints.size(); j++) {
				double value = Math.sqrt(Math.pow(inPoints.get(i).x
						- inPoints.get(j).x, 2)
						+ Math.pow(
								inPoints.get(i).y
										- inPoints.get(j).y, 2));
				if (value < distance) {
					distance = value;
					p.setX(inPoints.get(j).x);
					p.setY(inPoints.get(j).y);
				}
				if (j == inPoints.size() - 1) {
					outMap.put(inPoints.get(i), p);
				}
			}
		

		}
	}

	
}
