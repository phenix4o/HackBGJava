import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MainTester {
	public static void main(String... args){
		int[][] a = new int[] [] {{ 44, 55, 244, 242}, {180, 122 ,14,18},{10,180,190,130},{244,252,12,0}};
		int [] [] rescaled = rescale(a, 2, 2);
		final int[][] original = new int[100][100];
        int counter = 0;
        BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        BufferedImage bufferedImage2 = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < original.length; y++) {
            for (int x = 0; x < original[0].length; x++) {
            	bufferedImage.setRGB(x, y, counter);
                original[y][x] = counter++;
                
            } 
        } 
       
        File outputfile = new File("image.jpg");
        try {
			ImageIO.write(bufferedImage, "jpg", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        final int newWidth = 50;
        final int newHeight = 50;
 
 
        final int[][] newImage = rescale(original, newWidth, newHeight);
        for (int y = 0; y < newImage.length; y++) {
            for (int x = 0; x < newImage[0].length; x++) {
            	bufferedImage2.setRGB(x, y, newImage[y][x]);
                
            } 
        }
        File outputfile2 = new File("image2.jpg");
        try {
			ImageIO.write(bufferedImage2, "jpg", outputfile2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int[][] rescale(int[][] original, int newWidth, int newHeight) {
		// TODO Auto-generated method stub
		int[] interpolationMatrix = new int[original.length
				* original[0].length];
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < original[0].length; j++) {
				interpolationMatrix[i * original[0].length + j] = original[i][j];
			}
		}
		int[] result = new int[newWidth * newHeight];
		double x_ratio = original[0].length / newWidth;
		double y_ratio = original.length / newHeight;
		double px, py;
		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				px = Math.floor(j * x_ratio);
				py = Math.floor(i * y_ratio);
				result[(i * newWidth) + j] = interpolationMatrix[(int) ((py * original[0].length) + px)];
			}
		}
		int[][] rescaled = new int[newHeight][newWidth];
		for (int i = 0; i < newHeight; i++) {
			for (int j = 0; j < newWidth; j++) {
				rescaled[i][j] = result[(i * newWidth) + j];
			}
		}
		return rescaled;
	}
}