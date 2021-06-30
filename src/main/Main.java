package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int nodeNumber = 0;
		int edgeNumber = 0;
		
		Node[] nodeList;

		String inputType = "";
		
		Graph graph = new Graph();

		try {
			File myObj = new File("src/resources/test_set1/check_v5_s1.dat");
			//	        File myObj = new File("src/resources/DMXA/dmxa0296.stp");
			Scanner myReader = new Scanner(myObj);

			while(myReader.hasNext()) {
				if(myReader.hasNext("NB_NODES")) {
					inputType = "testset";
					myReader.next("NB_NODES");
					nodeNumber = myReader.nextInt();
				} else if(myReader.hasNext("NB_ARCS")) {
					inputType = "testset";
					myReader.next("NB_ARCS");
					edgeNumber = myReader.nextInt();
				} else if(myReader.hasNext("Nodes")) {
					inputType = "data";
					myReader.next("Nodes");
					nodeNumber = myReader.nextInt();
				} else if(myReader.hasNext("Edges")) {
					inputType = "data";
					myReader.next("Edges");
					edgeNumber = myReader.nextInt();	
				} else {
					myReader.nextLine();
				}

				if(nodeNumber > 0 && edgeNumber > 0) {
					break;
				}
			}

			if(inputType == "testset") {
				myReader.nextLine();
				myReader.nextLine();
			}
			
			nodeList = new Node[nodeNumber];
			
			for(int i = 0; i < nodeNumber; i++) {
				Node node = new Node(i+"");
				
				nodeList[i] = node;
			}

			for(int i = 0; i < edgeNumber; i++) {
				if(inputType == "data") {
					//Descarta identificador "E"
					myReader.next();
				}

				if(myReader.hasNextInt()) {
					int startNode = myReader.nextInt();
					int endNode = myReader.nextInt();
					int cost = myReader.nextInt();
					
					if(inputType == "data") {
						//REQUISITO 13 descrição Trabalho
						startNode--;
						endNode--;
					}
					
					nodeList[startNode].addAjacentNodes(nodeList[endNode], cost);
					
					System.out.println(startNode + " --> " + endNode + " - CUSTO: " + cost);
				}
			}
			
			System.out.println("=====================================================");
			System.out.println("=====================================================");

			System.out.println("TAMANHO NODELIST: " + nodeList.length);

			
			for(int i = 0; i < nodeList.length; i++) {
				graph.addNode(nodeList[i]);
			}

			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		System.out.println("TIPO DE ENTRADA: " + inputType);
		System.out.println("NÚMERO DE NÓS: " + nodeNumber);
		System.out.println("NÚMERO DE ARESTAS: " + edgeNumber);
		
		System.out.println("=====================================================");
		System.out.println("=====================================================");
		
		graph.printNodeList();
		
		graph = Graph.calculateShortestPathFromSource(graph, graph.getNodes()[0]);
		
		System.out.println("=====================================================");
		System.out.println("=====================================================");

		Node[] nodes = graph.getNodes();
		
		for(int i = 0; i < nodes.length; i++) {
			System.out.println("NODE: " + nodes[i].name + " - " + nodes[i].getDistance());
			nodes[i].printShortestPath();
		}
		
		System.out.println("=====================================================");
		System.out.println("=====================================================");
		
		

	}

}
