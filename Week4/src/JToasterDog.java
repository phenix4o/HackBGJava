import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;


public class JToasterDog {
	public static void main(String... args){
		
		while(true){
			try {
				Thread.sleep(2700000
						);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			showDogFor15MinutesEvery45Minutes();
		}
		
	}
	public static  void showDogFor15MinutesEvery45Minutes(){
		
		
		Toaster toasterManager = new Toaster();
		
		toasterManager.setToasterHeight(500);
		toasterManager.setToasterWidth(500);
		toasterManager.setStep(10);
		toasterManager.setDisplayTime(900000);;
		BufferedImage img = null ;
		try {
			img =  ImageIO.read(new File("src/dog.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		toasterManager.setBackgroundImage(img);
		toasterManager.showToaster( "JToaster Hello World!" );
	}
}
