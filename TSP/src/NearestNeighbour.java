import java.util.ArrayList;
import java.util.Random;

public class NearestNeighbour {
	ArrayList<Vertex> visited = new ArrayList<Vertex>();

	public Graph graph = new Graph();
	
	public Vertex vertexS = null;
	public int vertexSint = 0;
	
	public Vertex vertexV = null;
	public int vertexVint = 0;

	public NearestNeighbour(Graph graph) {
		this.graph = graph;
	}

	public int getNearestNeighbourFrom(int current){
		int newCurrent = -1;
		
		int selectedWeight = Integer.MAX_VALUE;
		int tempWeight = -1;
		int newNewestID = -1;
		
		for (Neighbor nbr = graph.adjLists[current].adjList; nbr != null; nbr = nbr.next) {
			if (!graph.adjLists[nbr.vertexNum].visited) {
				tempWeight = nbr.weight;
				if (tempWeight < selectedWeight) {
					selectedWeight = nbr.weight;

					newNewestID = nbr.vertexNum;
					if(nbr.next == null){
						return newNewestID;
					}
				}
			}
		}
		return newNewestID;
	}

	public void doNearestNeighbour() {
		
		Random r = new Random();
		int low = 0;
		int high = graph.adjLists.length;
		int vertexSint = 0; //r.nextInt(high - low) + low; //get start position
		boolean notDone = true;
		int oldVertexVint = 0;
		
		graph.adjLists[vertexSint].visited = true;
		vertexS = graph.adjLists[vertexSint];
		System.out.println("visited: " + visited);
		visited.add(vertexS);
		
		vertexVint = getNearestNeighbourFrom(vertexSint); //get closest V from S
		vertexV = graph.adjLists[vertexVint]; // V
		visited.add(vertexV);
		System.out.println("visited: " + visited);
		
		while(notDoneYet() && notDone){ //step 4. halfway
			oldVertexVint = vertexVint;
			vertexVint = getNearestNeighbourFrom(vertexVint);
			if(vertexVint != -1){
				graph.adjLists[vertexVint].visited = true;
				vertexV = graph.adjLists[vertexVint]; // V
				visited.add(vertexV);
			}
			if(vertexVint == -1){
				notDone = false;
			}

			System.out.println("visited: " + visited);
		}
		
//		visited.add(vertexV);
		
	}
	
	public boolean notDoneYet(){
		for(Vertex vertex : graph.adjLists){
			if(vertex.visited == false){
				return true;
			}
		}
		return false;
	}

	public void selectStart() {
		Random r = new Random();
		int low = 0;
		int high = graph.adjLists.length;
		int vertexSint = 0; //r.nextInt(high - low) + low;

		graph.adjLists[vertexSint].visited = true;
		vertexS = graph.adjLists[vertexSint];
		visited.add(vertexS);
	}
}
