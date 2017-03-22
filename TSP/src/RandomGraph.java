import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//credit goes to: http://www.sanfoundry.com/java-program-generate-random-undirected-graph-given-number-edges/

public class RandomGraph {
	PrintWriter rf = null;
	public int userInput = -1;
	public static int edgeCouldNotBeSet = 0;
	public static int edgeCouldNotBeSetMaximum = 40000;

	static private Map<Integer, List<Integer>> adjacencyList;

	public RandomGraph(int v) {
		adjacencyList = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= v; i++) {
			adjacencyList.put(i, new LinkedList<Integer>());
		}
		this.userInput = v;
	}

	public boolean setEdge(int to, int from) {
		boolean added = false;
		if (to > adjacencyList.size() || from > adjacencyList.size()) {
			System.out.println("The vertices does not exists");
		}
		if (to != from) { // avoid selfloops
			List<Integer> sls = adjacencyList.get(to);
			List<Integer> dls = adjacencyList.get(from);

			// avoid two edges to the same vertex
			if (!sls.contains(from) && !dls.contains(to)) {
				sls.add(from);
				dls.add(to);
				added = true;
			}
		}
		if (added == false) {
			this.edgeCouldNotBeSet = this.edgeCouldNotBeSet + 1;
		}
		// System.out.println(edgeCouldNotBeSet);
		// System.out.println(added + " for " + to + " and " + from);
		return added;
	}

	public List<Integer> getEdge(int to) {
		if (to > adjacencyList.size()) {
			System.out.println("The vertices does not exists");
			return null;
		}
		return adjacencyList.get(to);
	}

	public boolean checkNotConnectedVertices() {
		boolean notConnected = false;
		int j = 1;
		int minimum = GVL.minimumAmountOfEdgesPerVertex;
		LinkedList<Integer> storeEdgeListSize = new LinkedList<Integer>();

		for (List<Integer> edgeList : adjacencyList.values()) {
			// System.out.println("list: "+ j + " has size: " + edgeList.size()
			// + " " + edgeList);

			storeEdgeListSize.add(0, edgeList.size());
			
			//while there are edges with less then then the minimum amount of edges
			for (int jk = 0; jk < minimum; jk++) {
				if (storeEdgeListSize.contains(jk)) { 
					notConnected = true;
					break;
				}
			}
			j++;
		}
		return notConnected;
	}

	public void genGraphAndOutputFile(int size) {

		try {
			int minV = (int) Math.ceil((1 + Math.sqrt(1 + 8 * size)) / 2);
			int maxV = size + 1;

			Random random = new Random();
			// int v = Math.abs(random.nextInt(maxV - minV) + minV);
			int v = GVL.numberOfVerticesToGen;

			// System.out.println("Random graph has " + v + " vertices");

			RandomGraph rug = new RandomGraph(v);
			int amountOfAdditionelEdges = -1;
			int count = 1, to, from;
			boolean notAllVerticesConnected = true;
			boolean addedSuccessfully = false;

			while (count <= size || notAllVerticesConnected) {
				addedSuccessfully = false;
				to = Math.abs(random.nextInt(v + 1 - 1) + 1);
				from = Math.abs(random.nextInt(v + 1 - 1) + 1);

				// System.out.println("edgeCouldNotBeSet: " +
				// edgeCouldNotBeSet);
				if (edgeCouldNotBeSet > edgeCouldNotBeSetMaximum) {
					GVL.warningFlag = true;
					break;
				}

				addedSuccessfully = rug.setEdge(to, from);
				notAllVerticesConnected = checkNotConnectedVertices();

				if (notAllVerticesConnected && count <= size) {
					amountOfAdditionelEdges++;
					// System.out.println("forced to add new vertex from: " +
					// from + " to: " + to);
				}
				if (addedSuccessfully) {
					count++;
				}

			}

			System.out.println("The Adjacency List Representation: ");

			for (int i = 1; i <= v; i++) {
				System.out.print(i + " -> ");
				List<Integer> edgeList = rug.getEdge(i);
				if (edgeList.size() == 0)
					System.out.print("null");
				else {
					for (int j = 1;; j++) {
						if (j != edgeList.size())
							System.out.print(edgeList.get(j - 1) + " -> ");
						else {
							System.out.print(edgeList.get(j - 1));
							break;
						}
					}
				}
				System.out.println();
			}
			System.out.println("Vertices in random graph: " + v);
			// System.out.println("Random graph 	Edges: " +
			// (amountOfAdditionelEdges + size) + " Input was: " + size +
			// " generated more edges: " + amountOfAdditionelEdges);

			// start writing to file
			rf = new PrintWriter(GVL.outputFile); // overwrite old file
			rf.println("undirected\nnoWeightsFromFile");

			rf.println(adjacencyList.size());

			// int newX = 0;
			// int newY = 0;
			// int minX = (int) (GVL.edgeSpaceForWindow);
			// int maxX = (int) (GUIFrame.windowSizeX - GVL.edgeSpaceForWindow);
			// int minY = (int) (GVL.edgeSpaceForWindow);
			// int maxY = (int) (GUIFrame.windowSizeY - GVL.edgeSpaceForWindow);

			int newX = 0;
			int newY = 0;
			int minX = (int) (GVL.edgeSpaceForWindow);
			int maxX = (int) (GUIFrame.windowSizeX - (GVL.edgeSpaceForWindow));
			int minY = (int) (GVL.edgeSpaceForWindow);
			int maxY = (int) (GUIFrame.windowSizeY - (GVL.edgeSpaceForWindow));

			for (int i = 1; i <= v; i++) {
				newX = (int) Math.abs(Math.random() * (maxX - minX) + minX);
				newY = (int) Math.abs(Math.random() * (maxY - minY) + minY);
				rf.println(i + " " + newX + " " + newY);
			}

			for (int i = 1; i <= v; i++) {
				// rf.print(i + " -> ");
				List<Integer> edgeList = rug.getEdge(i);
				if (edgeList.size() == 0) {
					rf.print("null");
					System.out
							.println("Generating graph failed at least one not connected vertex!");
				} else {
					// System.out.println("to be printed edgeList" + edgeList);
					for (Integer kk : edgeList) {
						rf.print(i + " " + kk + " 0\n");
					}
				}
			}
			rf.print("#end");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		rf.close();
	}
}
