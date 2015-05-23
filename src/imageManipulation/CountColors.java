/**
 * CountColors. Allow users to choose a file and count the blocks of contiguous 
 * color in the file. 
 * 
 */
package imageManipulation;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * 
 * A front end to the image processing code. This allows you to pick a file from your filesystem. It has to
 * be a jpg, png, or gif file. 
 * 
 * We will then open the image and create a BufferedImage object which can be passed into your code into 
 * the countBlocks method. That method will return an int, the number of blocks in the image.
 * 
 * @author Rob Edwards
 * @version $Id: CountColors.java,v 1.1.1.1 2013/01/29 23:57:53 masc0674 Exp $
 */
public class CountColors {

	/**
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
		String filename = null;
		try {
			File imageFile = chooser.getSelectedFile().getCanonicalFile();
			bufferedImage = ImageIO.read(imageFile);
			filename = imageFile.getName();
		}
		catch (IOException e) {
			System.err.println("There was an IO Error reading the file");
			e.printStackTrace();
		}

		// Display the image in a new JFrame
		JFrame frame = new JFrame();
		JLabel label = new JLabel(new ImageIcon(bufferedImage));
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.setTitle("Image from " + filename);
		frame.pack();
		frame.setVisible(true);
	
		System.err.println("Counting the colors in " + filename + "\n");
		int regions = 0;

		/* 
		 * To test your code, Uncomment one of these methods and regions line below
		 * to run the code. 
		 *  
		 * Otherwise, we just display the image.
		 * 
		 */
		
		 //CountBreadthFirst cb = new CountBreadthFirst();
		 CountDepthFirst cb = new CountDepthFirst();
		 regions = cb.countBlocks(bufferedImage); 
		
		System.out.println("There are " + regions + " regions in this file\n");
		parent.dispose();

	}

}
