import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static Scanner sc = new Scanner(System.in);
	
	

	public void printMenu() {
		System.out.println("Menu: ");
		System.out.println("1. generate random TSP: ");
		System.out.println("2. use TSP input file:  ");

	}

	public void getUserChoice() {

		try {
			GVL.menuSelector = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
		}
	}

	public void executeMenu(int selection) throws IOException {
//		Scanner sc = new Scanner(System.in);
		switch (selection) {
		case 1:
			System.out.println("----------------------------------");
			System.out.println("Enter the number of edges: ");
			
			GVL.numberOfEdgesToGen = sc.nextInt();
			System.out.println("Enter the number of Vertices: ");
			GVL.numberOfVerticesToGen = sc.nextInt();

			RandomGraph rndGraph = new RandomGraph(GVL.numberOfEdgesToGen);
			rndGraph.genGraphAndOutputFile(GVL.numberOfEdgesToGen);

			if (GVL.warningFlag) {
				System.out.println("Warning: Graph proprtion do not match!");
			}
//			printMenu();
//			executeMenu(selection);
			break;
		case 2:
			System.out.println("----------------------------------");

			System.out.print("Enter graph input file name (with filename extension): ");
			
//			GVL.file = sc.nextLine();

			GVL.graph = new Graph(GVL.file);
			if ((GVL.noWeightsFromFile.equals("noWeightsFromFile"))) {
				GVL.graph.setAllWeights();
			}

			GVL.graph.print();

			GUIGraph jp = new GUIGraph(GVL.graph);

			GUIFrame jf = new GUIFrame(jp);

			break;
		default:
			System.out.println("Invalid selection.");
			break;
		}
	}
}
