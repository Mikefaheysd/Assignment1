package imageManipulation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ListPixelColors {

	/**
	 * Allow a user to choose an image file, and then list 
	 * all the pixels in that file. This is simple code
	 * to demonstrate the conversion of an RGB image
	 * to different colors, and how to iterate through
	 * an image.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
		 * Construct the chooser window that will allow the user
		 * to choose their image file. Limit the file types to
		 * PNG, JPG, or GIF.
		 * 
		 */

		JFrame parent = new JFrame();
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, & GIF Images", "jpg", "png", "gif");
		chooser.setFileFilter(filter);
		chooser.setDialogTitle("Please choose the image file:");
		int returnVal = chooser.showOpenDialog(parent);
		if(returnVal != JFileChooser.APPROVE_OPTION) {
			System.err.println("There was an error, the file was not chosen");
			System.exit(-1);
		}

		/*
		 * Read the image file as a bufferedImage
		 */

		BufferedImage bufferedImage = null;
		try {
			File imageFile = chooser.getSelectedFile().getCanonicalFile();
			bufferedImage = ImageIO.read(imageFile);
		}
		catch (IOException e) {
			System.err.println("There was an IO Error reading the file");
			e.printStackTrace();
		}
		
		/*
		 * Display the RGB values for each of the pixels.
		 */

		for (int x=0; x < bufferedImage.getWidth(); x++)
			for (int y=0; y < bufferedImage.getHeight(); y++) {
				int rgb = bufferedImage.getRGB(x, y);
				System.out.println("The color at position " + x + "," + y + " is " + rgb);
			}	
	}
}
