package main;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	//Lista de nós utilizando HASHSET
	Set<Node> nodes = new HashSet<>();
	//Lista de nós caso não possa utilizar a estrutura HASHSET
	Node[] nodes2 = null;
	
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
    
	public void addNode2(Node nodeA) {
		if(nodes2 == null) {
			nodes2 = new Node[1];
			nodes2[0] = nodeA;
		} else {
			int nodeLength = nodes2.length;
	        Node[] nodes2Aux = nodes2;
	        
	        nodes2 = new Node[nodeLength+1];
	        
	        for(int i = 0; i < nodeLength; i++) {
	        	nodes2[i] = nodes2Aux[i];
	        }
	        
	    	nodes2[nodeLength] = nodeA;
		}
	}
	
	
	public void printNodeList() {
		System.out.println("NODE LIST");
		for(Node n : nodes) {
			System.out.println(n.name);
			n.printAdjacentNodes();
		}
	}
	
	public void printNodeList2() {
		System.out.println("NODE LIST 2");
		for(int i = 0; i < nodes2.length; i++) {
			System.out.println(nodes2[i].name);
			nodes2[i].printAdjacentNodes2();
		}
	}
	
	
}
