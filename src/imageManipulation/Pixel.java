package imageManipulation;
/**
 * 
 * compares pixels based off of their individual color. 
 * class pixel is called within CountDepthFirst and CountBreadthFirst
 * and is used to compare the colors of surrounding pixels.
 * @author michaelfahey
 *@return will return 0 if it is a new pixel with same color 
 *else will return -1 if it is a pixel that has a different color.
 */
public class Pixel implements Comparable<Pixel> {
	
	int x;
	int y;
	int color;
	
	public Pixel (int x,int y,int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	//tests the color of current pixel
	//@returns -1 if pixel has a different color, 0 if the pixel has the same color
	public int compareTo (Pixel P){
		if (P.color==color){
			return 0;
		}
		return -1;
	}

}
