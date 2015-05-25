/**
 * @author Jaroslaw Pogoda
 * Subject CS313 Instructor Prof. Svitak
 *	Class compList
 * Description:
 * 	Projects main focus was to create fully functioning connected component list using linked lists using extracted pixels from image.
 * 
 */
public class compList {
	//var
	private Pixel firstPixel = new Pixel();
	private Pixel lastPixel = new Pixel();
	private int length;
	private int listnum;
	//list constructor
	public compList(){
		Pixel ln = new Pixel(0,0);
		firstPixel=ln;
		lastPixel=ln;
		length=0;
	}
	//append to the end of the list function
	public void append(int locationHeight, int locationWidth)
	   {
		Pixel n = new Pixel(locationHeight,locationWidth);
		      if (length==0)
		      {
		    	  firstPixel=n;
		    	  lastPixel=n;
		    	  length=1;
		      }
		      else
		      {
		      lastPixel.next = n;
		      lastPixel = n;
		      length++;
		      }
	   }
	//checking for connection
	public boolean connected(int i,int j, int[][] compGrid){
		boolean ans = false;
		Pixel ln = new Pixel();
		ln = firstPixel;
		
		while(ln!=null){
			
			if(ln.dataHeight==i-1 || ln.dataHeight==i){
				
				if(ln.dataWidth==j||ln.dataWidth==j-1||ln.dataWidth==j+1){
					
					ans=true;
					break;
				}
				
			}
			ln=ln.next;
		}

		return ans;
	}
	//checking if it is empty
	public boolean isEmpty() {
		boolean ans=false;
		if(length==0){
			ans=true;
		}

		return ans;
	}
	//setter for num
		void setListNum(int n){
			listnum=n;
			
		}
		//getter for num
		int getListNum(){
			return listnum;
		}
		//getter for print to the entire list of prixel coordinates and well and the number of the coordinate
	public void getList(){
		Pixel n = firstPixel;
		int num=0;
		while(n!=null){
			System.out.println(num++ +" "+n.dataHeight+" "+n.dataWidth);
			n=n.next;
		}
	}
	//Merging two linkedlists together
	public compList margeList(compList n){
		compList marged = new compList();
		marged.firstPixel=this.firstPixel;
		this.lastPixel.next=n.firstPixel;
		marged.lastPixel=n.lastPixel;
		
		marged.length=n.length+this.length;
		//System.out.println(marged.length);
		return marged;
		
	}
	//checking if lists are connected
	public boolean compConnect(compList n){
		boolean ans=false;
		compList marged = new compList();
		marged.firstPixel=this.firstPixel;
		marged.lastPixel=this.lastPixel;
		compList marged2 = new compList();
		marged2.firstPixel=n.firstPixel;
		marged2.lastPixel=n.lastPixel;
		
		while(marged.firstPixel!=null){
			
			while(marged2.firstPixel!=null){
				
				if(marged2.firstPixel.dataHeight==marged.firstPixel.dataHeight+1||marged2.firstPixel.dataHeight==marged.firstPixel.dataHeight){
					if(marged2.firstPixel.dataWidth==marged.firstPixel.dataWidth||marged2.firstPixel.dataWidth==marged.firstPixel.dataWidth+1||marged2.firstPixel.dataWidth==marged.firstPixel.dataWidth-1){
						ans=true;
						break;
					}
				}
				marged2.firstPixel=marged2.firstPixel.next;
			}
			marged.firstPixel=marged.firstPixel.next;
		}
		
		return ans;
		
	}
	//remove list
	public void removeList() {
		this.firstPixel=null;
				this.lastPixel=null;
		length=0;
		// TODO Auto-generated method stub
		
	}
	//getting min coordinate for Width
	public int getxmin() {
		int xmin=-1;
		Pixel n = firstPixel;
		xmin=n.dataWidth;
		while(n!=null){
			if(xmin>n.dataWidth)
			xmin=n.dataWidth;
			
			n=n.next;
		}
		return xmin;
	}
	//getting min coordinate for height
	public int getymin() {
		int ymin=-1;
		Pixel n = firstPixel;
		ymin=n.dataWidth;
		while(n!=null){
			if(ymin>n.dataHeight)
			ymin=n.dataHeight;
			
			n=n.next;
		}
		return ymin;
	}
	//getting max coordinate for Width
	public int getxmax() {
		int xmax=-1;
		Pixel n = firstPixel;
		 xmax=n.dataWidth;
		while(n!=null){
			if( xmax<n.dataWidth)
				 xmax=n.dataWidth;
			
			n=n.next;
		}
		return xmax;
	}
	//getting max coordinate for height
	public int getymax() {
		int ymax=-1;
		Pixel n = firstPixel;
		 ymax=n.dataWidth;
		while(n!=null){
			if( ymax<n.dataHeight)
				 ymax=n.dataHeight;
			
			n=n.next;
		}
		return ymax;
		
	}
	//getting length of list
	public int getlength() {
		// TODO Auto-generated method stub
		return length;
	}
	// calculating center
	public void center(){
		Pixel n = firstPixel;
		
		int centery=0;
		int centerx=0;
		while(n!=null){
			centery+=n.dataHeight;
			centerx+=n.dataWidth;
			n=n.next;
		}
		
		centery=centery/this.length;//(this.getymax()-this.getymin());
		centerx=centerx/this.length;//(this.getxmax()-this.getxmin());
		System.out.println("Xmin: "+this.getxmin()+". "+"Ymin: "+this.getymin()+". "+"Xmax: "+this.getxmax()+". "+"Ymax: "+this.getymax()+". And the Center is("+centerx+","+centery+").");
	}
		
}
