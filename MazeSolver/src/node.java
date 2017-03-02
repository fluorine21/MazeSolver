
public class node {

	private int Posx, Posy; //Equivalent to w and h respectively, scans left to right, up to down
	private boolean down, up, left, right, visited;
	private String type;

	public node(int x, int y, boolean downIn, boolean upIn, boolean leftIn, boolean rightIn, String typeIn){
		setPosx(x);
		setPosy(y);
		down = downIn;
		up = upIn;
		left = leftIn;
		right = rightIn;
		setType(typeIn);
		setVisited(false);
		//start, finish, normal, or deadend
	}
	boolean canMove(String direction){
		switch(direction){
		case "up": return up;
		case "down": return down;
		case "left": return left;
		case "right": return right;
		}
		throw new NullPointerException();

	}
	public void setMove(String direction, boolean value){
		switch(direction){
		case "right": 
			right = true;
			break;
		case "left": 
			left = true;
			break;
		case "up": 
			up = true;
			break;
		case "down": 
			down = true;
			break;
		}
		return;
	}
	public int getPosx() {
		return Posx;
	}
	private void setPosx(int posx) {
		Posx = posx;
	}
	public int getPosy() {
		return Posy;
	}
	private void setPosy(int posy) {
		Posy = posy;
	}
	public String getType() {
		return type;
	}
	private void setType(String type) {
		this.type = type;
	}

	//Checks to see if they're in the same row and can move in the row direction
	public boolean canMoveTo(node target){
		if(target.getPosx() == this.getPosx()){
			if((target.canMove("right") && this.canMove("left"))||(target.canMove("left") && this.canMove("right"))){
				return true;
			}

		}
		if(target.getPosy() == this.getPosy()){
			if((target.canMove("up") && this.canMove("dowm"))||(target.canMove("down") && this.canMove("up"))){
				return true;
			}

		}
		return false;

	}
	public boolean visited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public int getDistanceTo(node node) {
		// TODO Auto-generated method stub
		return 0;
	}


}
