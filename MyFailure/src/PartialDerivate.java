import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import boofcv.struct.image.ImageUInt8;

public class PartialDerivate {
	private static PartialDerivate instance = null;
	private static final double[] filter = { 1 / 7f, 1 / 7f, 1 / 7f, 1 / 7f,
			1 / 7f, 1 / 7f, 1 / 7f };

	private PartialDerivate() {

	}

	public static PartialDerivate getInstance() {
		if (instance == null) {
			instance = new PartialDerivate();
		}
		return instance;
	}

	public double calculatePartialDerivate(ImageUInt8 img, Point p, int rmin,
			int rmax, int n) {
		return calculatePartialDerivate1(img, p, rmin, rmax, n);
	}

	public double calculatePartialDerivate1(ImageUInt8 img, Point p, int rmin,
			int rmax, int n) {
		List<Integer> radius = new ArrayList<>();
		List<Double> lineIntegral = new ArrayList<>();
		LineIntegral li = LineIntegral.getIntegralInstance();
		int counter = 0;
		for (int i = rmin; i <= rmax; i++) {
			radius.add(i);
			lineIntegral.add(li.calculateLineIntegral(img, p,
					radius.get(counter), n));
			counter++;
		}
		for (Double f : lineIntegral) {
			if (f == 0) {
				lineIntegral.remove(f);
				counter--;
				return 0;
			}
		}
		List<Double> partialDerivative = new ArrayList<Double>();
		for (int i = 0; i < counter - 1; i++) {
			double diff = lineIntegral.get(i + 1) - lineIntegral.get(i);

			partialDerivative.add(diff);
		}
		partialDerivative.add(0, 0.0);

		List<Double> container = new ArrayList<Double>();
		int nf = filter.length;
		int ng = partialDerivative.size();
		for (int c = 0; c < ng + nf - 1; c++) {

			double sum = 0;

			int kmin = (c >= nf - 1) ? c - (nf - 1) : 0;
			int kmax = (c < ng - 1) ? c : ng - 1;

			for (int k = kmin; k <= kmax; k++) {
				sum += partialDerivative.get(k) * filter[c - k];
			}

			container.add(Math.abs(sum));

		}

		for (int k = 0; k < container.size(); k++) {
			if (k < Math.floor(nf / 2f) - 1
					|| k > partialDerivative.size() + Math.floor(nf / 2f) - 2) {
				container.remove(k);
			}

		}
		Double maxValue = Collections.max(container);
		return maxValue;
	}
}
