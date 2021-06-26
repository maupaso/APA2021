package main;

import java.util.HashMap;
import java.util.Map;

public class Node {
	
	String name;
	//Lista de nós adjacentes utilizando HASHMAP
    Map<Node, Integer> adjacentNodes = new HashMap<>();
    //Lista de nós adjacentes caso não possa utilizar a estrutura HASHMAP
	Node[] adjacentNodes2 = null;
	int[] adjacentDistances2 = null;


    public void addaAjacentNodes(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
    
    public void addaAjacentNodes2(Node destination, int distance) {
		if(adjacentNodes2 == null) {
			adjacentNodes2 = new Node[1];
			adjacentNodes2[0] = destination;
			
			adjacentDistances2 = new int[1];
			adjacentDistances2[0] = distance;
		} else {
	    	int adjacentNodeLength = adjacentNodes2.length;
	        Node[] adjacentNodes2Aux = adjacentNodes2;
	        int[] adjacentDistances2Aux = adjacentDistances2;

	        adjacentNodes2 = new Node[(adjacentNodeLength+1)];
	        adjacentDistances2 = new int[(adjacentNodeLength+1)];
	        
	        
	        for(int i = 0; i < adjacentNodeLength; i++) {
	        	adjacentNodes2[i] = adjacentNodes2Aux[i];
	        	adjacentDistances2[i] = adjacentDistances2Aux[i];
	        }
	        
	 
	    	adjacentNodes2[adjacentNodeLength] = destination;
	    	adjacentDistances2[adjacentNodeLength] = distance;
		}
    }

    
    
    public Node(String name) {
        this.name = name;
    }
    
    public void printAdjacentNodes() {
    	for (Node n: adjacentNodes.keySet()) {
    	    String key = n.name;
    	    String value = adjacentNodes.get(n).toString();
    	    System.out.println(key + " " + value);
    	}    	
    }
   
    
	
	public void printAdjacentNodes2() {
		for(int i = 0; i < adjacentNodes2.length; i++) {
			System.out.println(adjacentNodes2[i].name + " " + adjacentDistances2[i]);
		}
	}
    
    
    

}


