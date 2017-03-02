//I made an edit here to see if it would show up in eclipse
public class jsearch {
	
	node[] nodeArray, deadends;
	node startNode, finishNode, currentNode;
	
	public jsearch(node[] inputArray){
		nodeArray = inputArray;
		for(int i = 0; i < nodeArray.length; i++){
			if(nodeArray[i].getType() == "start"){
				startNode = nodeArray[i];
			}
		}
		for(int i = 0; i < nodeArray.length; i++){
			if(nodeArray[i].getType() == "finish"){
				finishNode = nodeArray[i];
			}
		}
	}
	
	public boolean solve(){
		
		move(true, startNode);
		
		
		
		
		
		
		
		
		
		
		
		return false;
		
	}
	

	//Recursive function which evaluates its current position and decides on how to move
	//Should only return true if it has found the end
	private boolean move(boolean state, node previousNode){
		if(currentNode.getType() == "deadend"){
			nodeArray[getPosInArray(currentNode)].setVisited(true);
			return false;
		}
		if(currentNode.getType() == "finsh"){//Checks for a win
			return true;
		}
		if(state = false && isExhausted(currentNode)){
			currentNode = previousNode;
			return false;
		}
		if(currentNode.canMove("left")){
			if(!findNodeTo("left", currentNode).visited()){//Checks if the node were trying to move to is not visited
				nodeArray[getPosInArray(currentNode)].setVisited(true);
			}
		}
		if(currentNode.canMove("left")){
			if(!findNodeTo("left", currentNode).visited()){//Checks if the node were trying to move to is not visited
				nodeArray[getPosInArray(currentNode)].setVisited(true);
			}
		}
		if(currentNode.canMove("left")){
			if(!findNodeTo("left", currentNode).visited()){//Checks if the node were trying to move to is not visited
				nodeArray[getPosInArray(currentNode)].setVisited(true);
			}
		}
		if(currentNode.canMove("left")){
			if(!findNodeTo("left", currentNode).visited()){//Checks if the node were trying to move to is not visited
				nodeArray[getPosInArray(currentNode)].setVisited(true);
			}
		}

		return false;
	}
	
	private boolean isExhausted(node target) {
		//Need to add special cases for nodes with less than 4 possible paths
		int count = 0;
		if(findNodeTo("left", target) != null && findNodeTo("left", target).visited() == true){
			count++;
		}
		if(findNodeTo("right", target) != null && findNodeTo("right", target).visited() == true){
			count++;
		}
		if(findNodeTo("up", target) != null && findNodeTo("up", target).visited() == true){
			count++;
		}
		if(findNodeTo("down", target) != null && findNodeTo("down", target).visited() == true){
			count++;
		}
		
		if(count <= 3){
			return true;
		}
		return false;
	}

	private node findNodeTo(String Direction, node target){
		int currentDistance = 100000000;
		node finalNode = null;
		for(int i = 0; i < nodeArray.length; i++){
			if(nodeArray[i].getPosx() < target.getPosx() && target.getDistanceTo(nodeArray[i]) < currentDistance){
				finalNode = nodeArray[i];
			}
		}
		return finalNode;
	}
	
	private int getPosInArray(node target){
		for(int i = 0; i < nodeArray.length; i++){
			if(target.getPosx() == nodeArray[i].getPosy() && target.getPosy() == nodeArray[i].getPosy()){
				return i;
			}
		}
		return 0;
		
	}


}
