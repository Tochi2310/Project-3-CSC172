package tonwuaso_p3;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class StopContagion {

 public static void main(String[] args)	throws IOException{
	 
	 //Gets the number of nodes to remove
	 String numNodes = args[args.length-2];
	 int numOfNodes = Integer.parseInt(numNodes);
	
	 
	 //Passes the path to the file as a parameter and retrieves the file
	 String file = args[args.length - 1];
	 Scanner sc = new Scanner(Paths.get(file));
	 
	 //check degree 
	 boolean degree = false;
	 int radius = 2; //Check radius
	 
	 for(int i=0; i <= args.length -2; i++) {
		 if (args[i].equals("-d")) {
			 degree = true;
		 }
		 if (args[i].equals("-r")) {
			 if (args.length == i +4) {
				 radius = Integer.parseInt(args[i +1]);

			 }
		 }
	 }
	 boolean begin = true;
	 if(begin) {
		 //build graph
		 //This loop will execute tbe code block once, before checking if the condition is true
		 // Then it will repeat the loop as long as the condition is true.
		 do { int node = sc.nextInt();
		       int adjNode = sc.nextInt();
		       GraphLayout.graphLayout.addNode(node, adjNode);
		      
		 } 
		 while (sc.hasNextInt());
		 int[] CI = new int[GraphLayout.graphLayout.vertex+1];
		 
		 for (int j = numOfNodes; j > 0; j--) {
			 //Will help find the maxiumum influence
			 int maxInfluence = 0;
			 for (int i =1; i<= GraphLayout.graphLayout.vertex; i++) {
				 //Checks degree or collective influence 
				 if(degree) CI[i] = GraphLayout.graphLayout.nodes.get(i).size();
				 else CI[i] = CollectiveInfluence.sigmaBall(i, radius);
				 
				 //Find Maxiumum
				 if(CI[i] > CI[maxInfluence])
					 maxInfluence = i;
					 
				 }
			 //Removes maximum influence node
			 System.out.println(maxInfluence+ " " + CI[maxInfluence]);
			 GraphLayout.graphLayout.removeNode(maxInfluence);
				 
			 }
	 }else {
		 System.out.println("Problem when reading input");
		 }
	 sc.close();
	 }
 }


