package main;


public class Graph {

	Node[] nodes = null;
	
	public Node[] getNodes() {
		return this.nodes;
	}
	
    
	public void addNode(Node nodeA) {
		if(nodes == null) {
			nodes = new Node[1];
			nodes[0] = nodeA;
		} else {
			int nodeLength = nodes.length;
	        Node[] nodes2Aux = nodes;
	        
	        nodes = new Node[nodeLength+1];
	        
	        for(int i = 0; i < nodeLength; i++) {
	        	nodes[i] = nodes2Aux[i];
	        }
	        
	    	nodes[nodeLength] = nodeA;
		}
	}
	
	
	public void printNodeList() {
		System.out.println("NODE LIST");
		for(int i = 0; i < nodes.length; i++) {
			System.out.println("NODE " + nodes[i].name);
			nodes[i].printAdjacentNodes();
		}
	}
	
	
	
	public static Node[] addNodeToNodeList(Node[] nodeList, Node node) {
		if(nodeList == null) {
			nodeList = new Node[1];
			nodeList[0] = node;
		} else {
			Node[] auxList = nodeList;
			nodeList = new Node[nodeList.length+1];
			
			for(int i = 0; i < auxList.length; i++) {
				nodeList[i] = auxList[i];
			}
			
			nodeList[auxList.length] = node;
		}
		
		return nodeList;
	}
	
	public static Node[] removeNodeFromNodeList(Node[] nodeList, Node node) {
		Node[] auxList = nodeList;
		nodeList = new Node[nodeList.length-1];
		
		int pos = 0;
		
		for(int i = 0; i < auxList.length; i++) {
			if(node.name != auxList[i].name) {
				nodeList[pos] = auxList[i];
				pos++;
			}
		}
		
		return nodeList;
	}
	
	public static Boolean nodeListContains(Node[] nodeList, Node node) {
		if(nodeList == null) {
			return false;
		}
		
		for(int i = 0; i < nodeList.length; i++) {
			if(nodeList[i].name == node.name) {
				return true;
			}
		}
		
		return false;
	}
	
	

	
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
	    source.setDistance(0);

	    Node[] settledNodes = null;
	    
	    Node[] unsettledNodes = new Node[1];
	    unsettledNodes[0] = source;

	    while (unsettledNodes.length != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        
	        Node[] nodeListAux = unsettledNodes;
	        
	        unsettledNodes = new Node[nodeListAux.length-1];
	        unsettledNodes = removeNodeFromNodeList(nodeListAux, currentNode);
	        
	        
			for(int i = 0; i < currentNode.adjacentNodes.length; i++) {
				Node adjacentNode = currentNode.adjacentNodes[i];
				int edgeWeight = currentNode.adjacentDistances[i];
				
				System.out.println("NODE [" + i + "], adjacente [" + adjacentNode.name + "] -  distancia: " + edgeWeight);
				
				System.out.println("currentNode: " + currentNode.name);
				currentNode.printAdjacentNodes();


				if(settledNodes != null && nodeListContains(settledNodes, adjacentNode)) {
					System.out.println("AQUI----");
					CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                
	    	        Node[] nodeListAux2 = unsettledNodes;
	    	        
	    	        unsettledNodes = new Node[nodeListAux2.length+1];
	    	        unsettledNodes = addNodeToNodeList(nodeListAux2, currentNode.adjacentNodes[i]);
				}
			}
			
			
	        Node[] nodeListAux3 = settledNodes;
	        
	        int nodeListAux3Lenght = 0;
	        if(nodeListAux3 != null) {
	        	nodeListAux3Lenght = nodeListAux3.length;
	        }
	        
	        settledNodes = new Node[nodeListAux3Lenght+1];
	        settledNodes = addNodeToNodeList(nodeListAux3, currentNode);
	        
	        System.out.println("settledNodes");
	        
			System.out.println("settledNodes LIST");
			for(int i = 0; i < settledNodes.length; i++) {
				System.out.println("NODE " + settledNodes[i].name);
				settledNodes[i].printAdjacentNodes();
			}
			System.out.println("FIM settledNodes LIST");
	    }
	    return graph;
	}
	
	

	
	private static Node getLowestDistanceNode(Node[] unsettledNodes) {
	    Node lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
	        
	        System.out.println("NODE: " + node.name + " - nodeDistance: " + nodeDistance);
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    
	    System.out.println("lowestDistanceNode: " + lowestDistanceNode.name + " - " + lowestDistance);
	    
	    return lowestDistanceNode;
	}
	
	
	private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
	    Integer sourceDistance = sourceNode.getDistance();
	    
	    System.out.println("sourceDistance: " + sourceDistance);
	    
	    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
	        evaluationNode.setDistance(sourceDistance + edgeWeigh);
	       
	        Node[] shortestPath = sourceNode.getShortestPath();
	       
	        Node[] nodeListAux = shortestPath;
	        
	        int nodeListAuxLenght = 0;
	        if(nodeListAux != null) {
	        	nodeListAuxLenght = nodeListAux.length;
	        }
	        
	        shortestPath = new Node[nodeListAuxLenght+1];
	        shortestPath = addNodeToNodeList(nodeListAux, sourceNode);
	        
	        evaluationNode.setShortestPath(shortestPath);
	    }
	}

	
	
}
