package main;



public class Node {
	
	String name;

	Node[] adjacentNodes = null;
	int[] adjacentDistances = null;

	Integer distance = Integer.MAX_VALUE;
	
	Node[] shortestPath;
	
	
	public void setDistance(int dist) {
		this.distance = dist;
	}
	
	public int getDistance() {
		return this.distance;
	}

	public Node[] getShortestPath() {
		return this.shortestPath;
	}
	
	public void setShortestPath(Node[] nodeList) {
		shortestPath = new Node[nodeList.length];
		
		shortestPath = nodeList;
	}
    
    public void addAjacentNodes(Node destination, int distance) {
		if(adjacentNodes == null) {
			adjacentNodes = new Node[1];
			adjacentNodes[0] = destination;
			
			adjacentDistances = new int[1];
			adjacentDistances[0] = distance;
		} else {
	    	int adjacentNodeLength = adjacentNodes.length;
	        Node[] adjacentNodes2Aux = adjacentNodes;
	        int[] adjacentDistances2Aux = adjacentDistances;

	        adjacentNodes = new Node[(adjacentNodeLength+1)];
	        adjacentDistances = new int[(adjacentNodeLength+1)];
	        
	        
	        for(int i = 0; i < adjacentNodeLength; i++) {
	        	adjacentNodes[i] = adjacentNodes2Aux[i];
	        	adjacentDistances[i] = adjacentDistances2Aux[i];
	        }
	        
	 
	    	adjacentNodes[adjacentNodeLength] = destination;
	    	adjacentDistances[adjacentNodeLength] = distance;
		}
		
		System.out.println("NODES ADJACENTES DE [" + this.name + "]: ");
		this.printAdjacentNodes();
    }

    
    
    public Node(String name) {
        this.name = name;
    }
    
	
	public void printAdjacentNodes() {
		for(int i = 0; i < adjacentNodes.length; i++) {
			System.out.println("NODE: " + adjacentNodes[i].name + " - CUSTO: " + adjacentDistances[i]);
		}
	}
	
	
	public void printShortestPath() {
		if(shortestPath == null) {
			System.out.println("-");
		} else {
			for(int i = 0; i < shortestPath.length; i++) {
				System.out.println(shortestPath[i].name + " " + shortestPath[i]);
			}
		}
	}
    
    
    

}


