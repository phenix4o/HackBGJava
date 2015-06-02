import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import javax.imageio.ImageIO;

import boofcv.core.image.ConvertBufferedImage;
import boofcv.struct.image.ImageFloat32;
import boofcv.struct.image.ImageUInt8;
import boofcv.struct.image.MultiSpectral;

public class MainActivityJava {
	public static void main(String... args) {
		Thresh b = Thresh.getInstance();
		PartialDerivate c = PartialDerivate.getInstance();
		LineIntegral d = LineIntegral.getIntegralInstance();
		long da = System.currentTimeMillis();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("one.jpg"));
		} catch (IOException e) {
		}
		ImageUInt8 mat = new ImageUInt8(img.getWidth(), img.getHeight());
		MultiSpectral<ImageFloat32> color = ConvertBufferedImage
				.convertFromMulti(img, null, true, ImageFloat32.class);
		for (int i = 0; i < color.getHeight(); i++) {
			for (int j = 0; j < color.getWidth(); j++) {
				color.getBand(0).set(j, i, color.getBand(0).get(j, i) / 255f);
				color.getBand(1).set(j, i, color.getBand(1).get(j, i) / 255f);
				color.getBand(2).set(j, i, color.getBand(2).get(j, i) / 255f);
				mat.set(j, i, Math.round(255 * (color.getBand(0).get(j, i)
						* 0.299f + color.getBand(1).get(j, i) * 0.587f + color
						.getBand(2).get(j, i) * 0.114f)));
			}
		}
		System.out.println(b.thresh(mat, 59, 120));
		System.out.println(System.currentTimeMillis()-da);
	}
}
