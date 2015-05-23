package imageManipulation;

import java.awt.image.BufferedImage;

import data_structures.*;

/**
 * A search method by using the stack to store information and search surrounding area
 * 
 * the count depth first approach utilizes the behavior of the stack to hold and store 
 * the information necessary by using last in first out behavior. 
 * 
 * 
 * @return blocks : the number of contiguous blocks of colors within the selected image
 * @author michaelfahey
 *
 */
//declare the width and height of the image to get the size of image
//declares blocks as our counter for contiguous blocks of color within the image
public class CountDepthFirst {
	int width;
	int height;
	int blocks;
	
	public CountDepthFirst(){
		width = 0;
		height = 0;
		blocks = 0;
	}
	//ignores white or black pixels within the image
		public boolean isWhiteBlack( int color) {	
			return (color == 0xff000000 || color == 0xffffffff);
		}
		//Make the stack empty
		public int countBlocks (BufferedImage bufferedImage) {
			Stack<Pixel> stack = new Stack<Pixel>(); 
			blocks = 0;
			width = bufferedImage.getWidth();
			height = bufferedImage.getHeight();
			//checks to see if we have previously seen the pixel
			boolean[][] haveSeen = new boolean [width][height];
			for(int n=0; n<width; n++){
				for(int p=0; p<height; p++){
					int next = bufferedImage.getRGB(n, p);//i,j
					//For every pixel in the image that we have not seen, push it onto the stack
					if(!haveSeen[n][p] && !isWhiteBlack(next)){
						int newcolor=bufferedImage.getRGB(n, p);
						Pixel newpixel = new Pixel(n , p, newcolor);
						stack.push(newpixel); 
						Pixel now = null;
						Pixel around;
						//while the stack is not empty,pop a pixel,from the stack, mark as seen
						while(!stack.isEmpty()){
							now = stack.pop();
							haveSeen[now.x][now.y]=true;
							//for each neighboring pixel
							for (int nearn =now.x -1; nearn<=now.x+1; nearn++){ 
								for(int nearp=now.y-1; nearp<=now.y+1; nearp++){ 
									if(nearn>-1&& nearn<width && nearp>-1 && nearp<height){
										//If we have not visited
										if (!haveSeen[nearn][nearp]){ 
											int aroundcolor = bufferedImage.getRGB(nearn,nearp); 
											around = new Pixel (nearn,nearp,aroundcolor); 
											//If n and p are the same color, push n to the stack
											if (around.compareTo(now)==0){ 
												haveSeen[around.x][around.y]=true; 
												stack.push(around); 
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


