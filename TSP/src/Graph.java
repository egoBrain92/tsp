import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

public class Graph {

	Vertex[] adjLists;
//	Vertex[] adjLists = new ArrayList<Vertex>();

	public int edgeCounter = 0;
	public int verticesCounter = 0;

	public Graph(String file) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(file));

		int graphType = -1;
		graphType = sc.nextInt();// sc.next();

		String noWeightsFromFile = sc.next();

		boolean useSecoundEdgeAppearance = true;

		switch (graphType) {
		case 10:
			useSecoundEdgeAppearance = false;
			break;
		case 20:
			useSecoundEdgeAppearance = true; //todo
			break;
		default:
			System.out.println("Invalid graphType in input file: " + graphType);
			break;
		}

		adjLists = new Vertex[sc.nextInt()];

		readVertices(sc);

		readEdges(sc, useSecoundEdgeAppearance);

	}

	public Graph() {

	}

	public void readVertices(Scanner sc) {
		for (int v = 0; v < adjLists.length; v++) {
			String name = sc.next();
			int xPositionOfVertex = sc.nextInt();
			int yPositionOfVertex = sc.nextInt();

			adjLists[v] = new Vertex(name, xPositionOfVertex,
					yPositionOfVertex, null);
			this.verticesCounter = this.verticesCounter + 1;
		}
	}

	public void readEdges(Scanner sc, boolean graphType) {
		while (sc.hasNext()) { // && (sc.next().equals("#end"))) {
			// read vertex names and translate to vertex numbers
			String nextElement = sc.next();
			if (nextElement.equals(GVL.endOfGraphFile)) {
				break;
			}
			int v1 = indexForName(nextElement);
			int v2 = indexForName(sc.next());

			int weight = sc.nextInt();

			// weight = calcWeight(v1, v2, weight);
			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacency list

			adjLists[v1].adjList = new Neighbor(v2, adjLists[v1].adjList,
					weight);
			if (graphType) {
				adjLists[v2].adjList = new Neighbor(v1, adjLists[v2].adjList,
						weight);
			}
			this.edgeCounter = this.edgeCounter + 1;
		}
	}

	public void setAllWeights() {
		for (int v = 0; v < verticesCounter; v++) {
			for (Neighbor nbr = this.adjLists[v].adjList; nbr != null; nbr = nbr.next) {
				nbr.setWeight(v);
			}
		}
	}

	public boolean isConnected(int indexOfVertexToCheck, int connectedOrNot) {
		boolean isConnected = false;
		int tempAnwser = -1;
		for (Neighbor nbr = adjLists[indexOfVertexToCheck].adjList; nbr != null; nbr = nbr.next) {
			tempAnwser = nbr.vertexNum;
			// System.out.println("-- " + tempAnwser + " --");

			if (tempAnwser == connectedOrNot) {
				isConnected = true;
				System.out.println("[check]" + tempAnwser + " linked "
						+ connectedOrNot + " = " + isConnected);
				break;
			}
		}
		return isConnected;
	}

	public int indexForName(String name) {
		for (int v = 0; v < verticesCounter; v++) {
			if (adjLists[v].name.equals(name)) {
				return v;
			}
		}
		// only executes when the input file is not correctly formated.
		return -1;
	}

	public void print() {
		System.out.println();
		System.out.println("Vertices: " + verticesCounter + " Edges: "
				+ edgeCounter);
		for (int v = 0; v < adjLists.length; v++) {
			System.out.print(adjLists[v].name + "[" + (v ) + "]");
			for (Neighbor nbr = adjLists[v].adjList; nbr != null; nbr = nbr.next) {
				System.out.print(" -" + "(" + nbr.weight + ")" + "-> "
						+ adjLists[nbr.vertexNum].name + "[" + nbr.vertexNum
						+ "]");
			}
			System.out.println();
		}
	}

	public Vertex[] getAdjLists() {
		return adjLists;
	}

	public Graph getGraph() {
		return this;
	}
}