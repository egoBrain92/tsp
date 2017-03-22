import java.io.File;

import javax.swing.Timer;

public class GVL {
	public static Graph graph = new Graph();
	public static int menuSelector = -1;

	public static int numberOfEdgesToGen = -1;

	public static int numberOfVerticesToGen = -1;

	public static String file = "output.txt";
	public static File outputFile = new File("output.txt");

	public static String endOfGraphFile = "#end";
	public static String noWeightsFromFile = "noWeightsFromFile";

	public static int vertexDotSize = 8;

	public static int guiUpdateRate = 5;

	public static double edgeSpaceForWindow = vertexDotSize * vertexDotSize;

	public static boolean warningFlag = false;

	public static int minimumAmountOfEdgesPerVertex = 2;

	// public static int edgeCouldNotBeSet = 0;
	// public static int edgeCouldNotBeSetMaximum = 1000;
}
