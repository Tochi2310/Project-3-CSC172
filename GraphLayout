package tonwuaso_p3;
import java.util.ArrayList;
import java.util.LinkedList;

//This class sets the layout for the graph
public class GraphLayout {
   public static GraphLayout graphLayout = new GraphLayout();
   
   int vertex;
   int degree;
   ArrayList<LinkedList<Integer>> nodes;
   
   
   //Constructor
   public GraphLayout() {
	   vertex = 0;
	   degree = 0;
	   nodes = new ArrayList<>();
	   nodes.add(new LinkedList<>());
   }
   //Adds new LinkedList to list of nodes
   public void addLinkedList(int size) {
	   while (nodes.size() < size+1) {
		   nodes.add(new LinkedList<>());
		   vertex++;
	   }
   }
   
   //Forms adjacency list; contains connected vertices
   public void addNode(int node, int adjNode) {
	   if(nodes.size() < node+1) 
		   addLinkedList(node);
	   nodes.get(node).addLast(adjNode);   //Appends the specified element to the end of this list.
	   if (nodes.size() < adjNode +1) addLinkedList(adjNode);
	   nodes.get(adjNode).addLast(node);
   }
   
   //Method removes node from graph and returns the updated list without the node
   public LinkedList<Integer> removeNode(int node){
	   for(int neighbor : nodes.get(node))
		   nodes.get(neighbor).remove((Integer) node);
	   @SuppressWarnings("unchecked")
	   LinkedList<Integer> neighbors = (LinkedList<Integer>) nodes.get(node).clone(); //Creates and exact copy of the orginal object. Will help return the updated list witihout the node. 
	   nodes.get(node).clear();
	   return neighbors;
		   
   }
   //Prints the graph
   public static void printGraph() {
	   for(int i =1; 1<= graphLayout.vertex; i++) {
		   System.out.print(i + " : ");
		   for(@SuppressWarnings("unused") int neighbor : graphLayout.nodes.get(i))
			   System.out.println();
	   }
	   System.out.println();
   }
   
   
}
