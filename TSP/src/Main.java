import java.io.IOException;
import java.util.Scanner;

//Based on the tutorial from Sesh Venugopal on YouTube: https://www.youtube.com/watch?v=zVrPdF7f4-I
public class Main {

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu();
		menu.printMenu();
		GVL.menuSelector = -1;

		while (GVL.menuSelector == -1) { // avoid input error
			menu.getUserChoice();
		}

		menu.executeMenu(GVL.menuSelector);

//		GVL.graph = new Graph(GVL.file);
//		if ((GVL.noWeightsFromFile.equals("noWeightsFromFile"))) {
//			GVL.graph.setAllWeights();
//		}
//
//		GVL.graph.print();
//
//		GUIGraph jp = new GUIGraph(GVL.graph);
//
//		GUIFrame jf = new GUIFrame(jp);

//		System.out.println("Enter the number of edges: ");
//		Scanner sc = new Scanner(System.in);
//		GVL.numberOfEdgesToGen = sc.nextInt();
//		System.out.println("Enter the number of Vertices: ");
//		GVL.numberOfVerticesToGen = sc.nextInt();
//
//		RandomGraph rndGraph = new RandomGraph(GVL.numberOfEdgesToGen);
//		rndGraph.genGraphAndOutputFile(GVL.numberOfEdgesToGen);
//
//		if (GVL.warningFlag) {
//			System.out.println("Warning: Graph proprtion do not match!");
//		}
		// System.out.println("--------------------------------------------------------------");
		// rndGraph.checkNotConnectedVertices();
		// sc.close(); // done reading close scanner
	}
}
