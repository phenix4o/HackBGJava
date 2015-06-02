import java.awt.Point;
import java.util.LinkedList;

import boofcv.struct.image.ImageUInt8;

/**
 * 
 * Created by martin on 8.04.15.
 * 
 * The Class calculates the Line Integral of the point x and y with radius r
 * This is the Line Integral of a Circle
 */

public class LineIntegral {

	private static LineIntegral integral = null;

	private LineIntegral() {

	}

	public static LineIntegral getIntegralInstance() {

		if (integral == null) {

			integral = new LineIntegral();

		}

		return integral;

	}

	/**
	 * 
	 * Point x - height,y - width
	 * 
	 * @param img
	 * 
	 * @param p
	 * 
	 * @param r
	 * 
	 * @param n
	 * 
	 * @return lineIntegral
	 */
	// public Method
	public double calculateLineIntegral(ImageUInt8 img, Point p, int r, int n) {
		return calculateLineIntegral1(img, p, r, n);
	}

	// Method, that hides the lineIntegral from outside Access
	private double calculateLineIntegral1(ImageUInt8 img, Point p, int r, int n) {

		double result = 0;

		LinkedList<Double> x = new LinkedList<Double>();

		LinkedList<Double> y = new LinkedList<Double>();

		int rows = img.getHeight();

		int cols = img.getWidth();
		double sum = (float) (2 * Math.PI / n);
		for (float theta = (float) (2 * Math.PI / n); theta <= 2 * Math.PI; theta += sum) {

			x.add((double) (p.x - r * Math.sin(theta)));

			y.add((double) (p.y + r * Math.cos(theta)));

			if (x.getLast() >= rows  || y.getLast() >= cols 
					|| x.getLast() <= 1 || y.getLast() <= 1) {

				result = 0;
				return result;

			}

		}

		for (int z = 0; z < Math.round(n / 8); z++) {

			int value = img.get((int) Math.round(y.get(z)) - 1, (int) Math.round(x.get(z)) - 1);

			result += value;

		}

		for (int z = Math.round(3 * n / 8); z < Math.round(5 * n / 8); z++) {

			int value = img.get((int) Math.round(y.get(z)) - 1, (int) Math.round(x.get(z)) - 1);

			result += value;

		}

		for (int z = Math.round(7 * n / 8); z < n; z++) {

			int value = img.get((int) Math.round(y.get(z)) - 1, (int) Math.round(x.get(z)) - 1);

			result += value;

		}

		result = (double) (2 * result) / n;

		return result;

	}
}