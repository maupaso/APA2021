package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int nodeNumber = 0;
		int edgeNumber = 0;
		
		String inputType = "";

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
        	
        	for(int i = 0; i < edgeNumber; i++) {
        		if(inputType == "data") {
        			//Descarta identificador "E"
        			myReader.next();
        		}
        		
        		if(myReader.hasNextInt()) {
	        		int startNode = myReader.nextInt();
	        		int endNode = myReader.nextInt();
	        		int cost = myReader.nextInt();
	        		
	        		System.out.println(startNode + " --> " + endNode + " - CUSTO: " + cost);
        		}
        		
        	}

        	
        	

        	myReader.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	      }
		
	    System.out.println("TIPO DE ENTRADA: " + inputType);
	    System.out.println("NÚMERO DE NÓS: " + nodeNumber);
	    System.out.println("NÚMERO DE ARESTAS: " + edgeNumber);
		
	}

}
