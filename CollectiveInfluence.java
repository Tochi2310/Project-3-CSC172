package tonwuaso_p3;

import java.util.LinkedList;
import java.util.Queue;

public class CollectiveInfluence {
 //Ball(i,r)---> Ball(Node, Radius)
 //This method adds a ball to a node if it has been visited already
 // It is used to calculate the collective influence
public static int Ball(int node, int radius) {
	if(radius ==0)
		return 0;

 //Make a queue using a linked list. Will be used to visit the ndoes in the graph
	Queue<Integer> queue = new LinkedList<>();
	boolean [] visited = new boolean[GraphLayout.graphLayout.vertex+1];
	queue.add(node);
	visited[node] = true; //If the node has been visited then the sum stays the same
	int sum=0;
	
	//This analyzes the queue 
	int dequeue = 1;
	while(!queue.isEmpty() && radius > 0) {
		//Count number of nodes needed to be dequeued for next round
		int nextRoundDequeue = 0;
		for(int i = dequeue; i > 0; i--) {
			int currentNode = queue.poll();
			//Add current node's neighbors to the queue for next round
			for (int adjNode : GraphLayout.graphLayout.nodes.get(currentNode)) {
				//add univsted nodes to visiting list
				if(!visited[adjNode]) {
					queue.add(adjNode);
					visited[adjNode] = true;
					sum += GraphLayout.graphLayout.nodes.get(adjNode).size() - 1;
					nextRoundDequeue++;
				}
			}
			
		}
		dequeue = nextRoundDequeue;
		radius--; 
	}
	//Calculate collective influence
	sum = sum * (GraphLayout.graphLayout.nodes.get(node).size()-1);
	return sum;
}
//SigmaBall(i, r) --> i = node and r = radius 
//SigmaBall = exact collective influence
//This is a method to calculate the exact collective influence 
//CI(i,r) = (countDegree(i)-1) * sum(countDegree for all elements of sigmaBall(i,r))
public static int sigmaBall(int node, int radius) {
	if (radius ==0)
		return 0;
	/* 
	 * In order to detect the nodes that lie inside a given distance from another node, Breadth-first search is used here.
	 * In this process, as we move further away from our starting node,
	 * we keep count of the links we travel along.
	 */
	
	//Make another queue using a linked list. Will be used to visit node in the graph
	Queue<Integer> Queue = new LinkedList<>(GraphLayout.graphLayout.nodes.get(node));
	boolean[] visited = new boolean[GraphLayout.graphLayout.vertex+1];
	visited[node] = true;
	//Enhanced for loop that helps iterate through all the elements
	 for (int adjNode : GraphLayout.graphLayout.nodes.get(node))
		 visited[adjNode] = true;
	 int sum =0;
	 
	 //This analyzes the queue 
	 int DQ = GraphLayout.graphLayout.nodes.get(node).size();
	
	 while(radius > 1) {
		 //count number of nodes needed to be dequeued for nex
		 int NextDQ =0;
		 for(int i=DQ; i>0; i--) {
			 int current = Queue.poll();
			 //Add current node's neighbors to the queue for next round
			 for(int adjNode : GraphLayout.graphLayout.nodes.get(current)) {
				 //Add univisted nodes to visiting list
				 if(!visited[adjNode]) {
					 Queue.add(adjNode);
					 visited[adjNode] = true; 
					 
					 NextDQ++;
				 }
			 }
		 }
		 DQ = NextDQ;
		 radius--;
	 }
	
	while(!Queue.isEmpty()) { //While the queue is empty, the neighbor is set to the head of the queue 
		int adjNode = Queue.poll();
		sum += GraphLayout.graphLayout.nodes.get(adjNode).size() -1;
				
	}
	
	//Calculate collective influence
	sum = sum * (GraphLayout.graphLayout.nodes.get(node).size()-1);
	return sum;
	
}






}
	
	

