import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import boofcv.struct.image.ImageUInt8;

public class Thresh {
	private static Thresh instance = null;
	public static double maxVal = 0f;
	public static int irisCentrX, irisCentrY;

	private Thresh() {

	}

	private static void deleteCells(List<Integer> x, List<Integer> y) {
		for (int j = y.size() - 1; j >= 0; j--) {
			if (x.get(j) == 904 || y.get(j) == 904) {
				x.remove(j);
				y.remove(j);
			}
		}
	}

	public static Thresh getInstance() {
		if (instance == null) {
			instance = new Thresh();
		}
		return instance;
	}

	public String thresh(ImageUInt8 img, int rmin, int rmax) {
		return thresh1(img, rmin, rmax);
	}

	private String thresh1(ImageUInt8 img, int rmin, int rmax) {
		int rows = img.height;
		int cols = img.width;
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (img.get(j, i) < 20) {
					x.add(i);
					y.add(j);
				}
			}
		}
		int minimum;
		for (int i = 0; i < y.size(); i++) {
			if ((x.get(i) > rmin) && (y.get(i) > rmin)
					&& (x.get(i) <= (rows - rmin))
					&& (y.get(i) < (cols - rmin))) {
				ArrayList<Integer> minimalValues = new ArrayList<>();
				for (int l = x.get(i) - 1; l <= x.get(i) + 1; l++) {
					for (int k = y.get(i) - 1; k <= y.get(i) + 1; k++) {
						minimalValues.add(img.get(k, l));
					}
				}
				minimum = Collections.min(minimalValues);
				if (img.get(y.get(i), x.get(i)) != minimum) {
					x.set(i, 904);
					y.set(i, 904);
				}
			}
			if ((x.get(i) <= rmin) | (y.get(i) <= rmin)
					|| (x.get(i) > (rows - rmin)) || (y.get(i) > (cols - rmin))) {
				x.set(i, 904);
				y.set(i, 904);
			}
		}
		deleteCells(x, y);
		PartialDerivate part = PartialDerivate.getInstance();
		for (int i = 0; i < x.size(); i++) {

			double max = part.calculatePartialDerivate(img, new Point(x.get(i),
					y.get(i)), rmin, rmax, 600);
			if (Double.compare(max, maxVal) > 0) {
				maxVal = max;
				irisCentrX = x.get(i);
				irisCentrY = y.get(i);

			}
		}
		return irisCentrX + " " + irisCentrY;
	}
}
