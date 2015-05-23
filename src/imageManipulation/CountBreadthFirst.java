package imageManipulation;

import java.awt.image.BufferedImage;

import data_structures.*;

/**
 * A search method by using the queue to store information and search surrounding area
 * 
 * the count breadth first approach utilizes the behavior of the queue to hold and store 
 * the information necessary by using first in first out behavior. 
 * 
 *@author michaelfahey
 *@return blocks: the number of contiguous blocks of colors within the selected image
 */
//declare the width and height of the image to get the size of image
//declares blocks as counter for contiguous blocks of color within the image
public class CountBreadthFirst {
	int width;
	int height;
	int blocks;

	public CountBreadthFirst(){
		width = 0;
		height = 0;
		blocks = 0;
	}
	//creates a check for white or black
	public boolean isWhiteBlack( int color) {	
		return (color == 0xff000000 || color == 0xffffffff);
	}
	//Make the queue empty(X)
	public int countBlocks (BufferedImage bufferedImage) {
		Queue<Pixel> queue = new Queue<Pixel>(); 
		blocks = 0;
		width = bufferedImage.getWidth();
		height = bufferedImage.getHeight();
		boolean[][] haveSeen = new boolean [width][height]; 
		for(int n=0; n<width; n++){
			for(int p=0; p<height; p++){
				int next = bufferedImage.getRGB(n, p);
				//For every pixel in the image that we have not seen
				if(!haveSeen[n][p] && !isWhiteBlack(next)){
					int newcolor=bufferedImage.getRGB(n, p);
					Pixel newpixel = new Pixel(n , p, newcolor);
					//enqueue it
					queue.enqueue(newpixel);
					Pixel now = null;
					Pixel around;
					//while the queue is not empty,dequeue a pixel, p, from the queue, mark as seen
					while(!queue.isEmpty()){
						now = queue.dequeue();
						haveSeen[now.x][now.y]=true;
						//for each neighboring pixel, n()
						for (int nearn =now.x -1; nearn<=now.x+1; nearn++){
							for(int nearp=now.y-1; nearp<=now.y+1; nearp++){ 
								if(nearn>-1&& nearn<width && nearp>-1 && nearp<height){
									//If we have not visited n()
									if (!haveSeen[nearn][nearp]){ 
										int aroundcolor = bufferedImage.getRGB(nearn,nearp);
										around = new Pixel (nearn,nearp,aroundcolor);
										//If n and p are the same color:()
										if (around.compareTo(now)==0){ 
											haveSeen[around.x][around.y]=true; 
											//push n to the queue
											queue.enqueue(around); 
										}
									}
								}
							}
						}
					}
					//increase the amount of contiguous blocks we have seen
					blocks = blocks + 1;
				}
			}
		}
		//return total amount of contiguous blocks in image
		return blocks;
	}
}


