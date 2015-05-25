/**
 * @author Jaroslaw Pogoda
 * Subject CS313 Instructor Prof. Svitak
 *	Class Main
 * Description:
 * 	Projects main focus was to create fully functioning connected component list using linked lists using extracted pixels from image.
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;


public class Assignment1Main {

	public static void main(String[] args) throws IOException {
		//reading and opening file
		JPegImage Image = new JPegImage();
		Image.readImage("C:\\Users\\yep\\workspace\\classfiles\\FontsCourierNew48_TH161.jpg");//FontsCourierNew48_TH161.jpg Test.jpg
		int imageHeight=Image.getImageHeight();
		int imageWidth=Image.getImageWidth();
		int[][] compGrid = new int[imageHeight][imageWidth];
		//creating compGrid
		int filled=0;
		for(int i=0;i<imageHeight;++i){
			for(int j=0;j<imageWidth;++j){
				compGrid[i][j]=Image.getPixelColor(j, i);
			}
		}
		
		int size=(imageHeight*imageWidth)/4+1;
		//creating compList
		compList[] list= new compList[size];
		for(int b=0;b<size;b++)
			list[b]=new compList();

		//filling linked lists with pixels
		for(int i=0;i<imageHeight;++i){
			for(int j=0;j<imageWidth;++j){
				if(Image.getPixelColor(j, i)==0){
					boolean notused=true;
					int n=0;
					if(filled==n){
						list[0].append(i, j);
						filled++;	
					}
					while(n<=filled){
						
						if(list[n].connected(i, j, compGrid)){
							//System.out.println(n+" "+i+" "+j+" "+filled);
							list[n].append(i, j);
							notused=false;
							break;
						}
						n++;
					}
					if(notused){
						list[filled].append(i, j);
						filled++;
					}
				}
			}
		}
//merging connected lists together
		int g=0,h=0,t=0;
		for(g=0;g<=filled;g++){
			for(h=0;h<g;h++){
				
					if(list[g].compConnect(list[h])){
						
						list[g]=list[g].margeList(list[h]);
						list[h].removeList();
					}

			}
			
			
		}
		int l=1;
		//finding out number of the list and number of pixels as well as xmin ymin xMax yMax and the center of component
		for(int b=0;b<=filled;b++){
			if(!list[b].isEmpty()){
				
				System.out.println("In component#:" +l+". The Total Number of Pixels is:"+list[b].getlength());
				list[b].center();
				l++;
			}
		}

				
		}
		
	}
		



