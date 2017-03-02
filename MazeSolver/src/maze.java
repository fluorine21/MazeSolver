import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class maze {

	private int[][] mazeArray;
	private node[] nodeArray;
	int w;
	int h;

	public maze(String mazePhotoName){
		BufferedImage mazePhoto = null;

		try 
		{mazePhoto = ImageIO.read(new File(mazePhotoName));}
		catch (IOException e){
			System.out.println("File not found...");
			e.printStackTrace();
		}
		Raster raster = ((BufferedImage) mazePhoto).getData();
		int w = mazePhoto.getWidth();
		int h = mazePhoto.getHeight();
		for (int j = 0; j < w; j++) {
			for (int k = 0; k < h; k++) {
				mazeArray[j][k] = raster.getSample(j, k, 0);
			}
		}


	}

	public void generateNodeArray(){
		int currentNode = 0;
		for(int i = 0; i < w; i++){
			for(int j = 0; i < h; j++){
				if(mazeArray[i][j] < 100){//Skips if it sees a black pixel

				}
				else{
					if(i == 0 || j == 0 || i == w-1 || j == w-1 ){//Checks if it's at a wall
						if(j == 0){//Start of Maze
							nodeArray[currentNode] = new node(i,j,false,false,false,false,"start");
							currentNode++;
						}
						else{//End of Maze
							nodeArray[currentNode] = new node(i,j,false,false,false,false,"finish");
							currentNode++;
						}
					}
					else{
						//Checks if its a corridor and then does nothing
						if((mazeArray[i][j+1] > 100 && mazeArray[i][j-1] > 100) || mazeArray[i+1][j] > 100 && mazeArray[i-1][j] > 100){

						}
						else{//Creates a node if we're at an appropriate place
							if(isDeadEnd(i,j)){
								nodeArray[currentNode] = new node(i,j,false,false,false,false,"deadend");
							}
							else{
								nodeArray[currentNode] = new node(i,j,false,false,false,false,"normal");
							}

							if(mazeArray[i][j+1] > 100){
								nodeArray[currentNode].setMove("down", true);
							}
							if(mazeArray[i][j-1] > 100){
								nodeArray[currentNode].setMove("up", true);
							}
							if(mazeArray[i+1][j] > 100){
								nodeArray[currentNode].setMove("right", true);
							}
							if(mazeArray[i-1][j] > 100){
								nodeArray[currentNode].setMove("left", true);
							}
							currentNode++;
						}
					}
				}
			}
		}

	}

	private boolean isDeadEnd(int i, int j) {
		int count = 0;
		for(int k = -1; k < 2; k+=2){
			for(int l = -1; l < 2; l+=2){
				if(k == l || k == -l){//Checks for edge pieces 
					
				}
				if(mazeArray[i+k][j+l] == 0){
					count++;
				}
			}
		}
		if(count > 1){
			return true;
		}
		return false;
	}
	
	public node[] getNodeArray(){
		return nodeArray;
	}
}
