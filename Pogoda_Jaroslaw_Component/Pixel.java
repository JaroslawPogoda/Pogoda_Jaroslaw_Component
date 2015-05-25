/**
 * @author Jaroslaw Pogoda
 * Subject CS313 Instructor Prof. Svitak
 *	Class Pixel(Node)
 * Description:
 * 	Projects main focus was to create fully functioning connected component list using linked lists using extracted pixels from image.
 * 
 */
public class Pixel {
	//var for pixel
	public int dataHeight;
	public int dataWidth;
	public Pixel next;
	//empty constructor
	public Pixel(){
		dataHeight=-1;
		dataWidth=-1;
		next=null;
	}
	//proper constructor
	public Pixel(int locationHeight, int locationWidth){
		dataHeight = locationHeight;
		dataWidth = locationWidth;
		next= null;
	}
	//function for equality
	public boolean equals(Pixel in){
		boolean ans= false;
		if(this.dataHeight==in.dataHeight&&this.dataWidth==in.dataWidth){
			ans=true;
		}
		
		
		
		return ans;
		
		
	}
}
