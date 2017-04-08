//
//
//public class Snippet {
//	public Vertex getNN(int current) {
//		// Vertex newest = visited.get(visited.size() - 1);
//		Vertex newest = visited.get(current);
//		Vertex newNewest = new Vertex("dummy", 0, 0, null);
//	
//		int selectedWeight = Integer.MAX_VALUE;
//		int tempWeight = -1;
//		int newNewestID = -1;
//	
//		for (Neighbor nbr = newest.adjList; nbr != null; nbr = nbr.next) {
//	
//			if (!gotVisited(newest)) {
//				tempWeight = nbr.weight;
//	
//				if (tempWeight < selectedWeight) {
//					selectedWeight = nbr.weight;
//	
//					newNewestID = nbr.vertexNum;
//					newNewest = graph.adjLists[newNewestID];
//	
//				}
//			}
//		}
//		return newNewest;
//	
//	}
//	
//	public boolean allGotVisted() {
//		boolean check = false;
//		int tempCheck = 0;
//	
//		for (Vertex tempVertex : visited) {
//			for (int i = 0; i < graph.adjLists.length; i++) {
//				if (tempVertex == graph.adjLists[i]) {
//					System.out.println("tempCheck: " + tempCheck);
//					tempCheck++;
//				}
//			}
//		}
//		if (tempCheck == graph.adjLists.length) {
//			check = true;
//		}
//	
//		return check;
//	}
//	
//	public void doNN() {
//		int i = 0;
//		Vertex current = startVertex;
//	
//		while (!allGotVisted()) {
//			current = getNN(i);
//			System.out.println("current name :" + current.name);
//			System.out.println("visited list: " + visited);
//			i++;
//	
//		}
//	}
//	
//	public void getNearestFromCurrent(int current) {
//		int selectedWeight = Integer.MAX_VALUE;
//		int tempWeight2 = -1;
//		// System.out.println("selectedWeight + 1 = " + (selectedWeight + 1));
//		// System.out.println("selectedWeight + 0 = " + selectedWeight);
//		Vertex newest = visited.get(visited.size() - 1); // visited.get(current);
//	
//		for (Neighbor nbr = newest.adjList; nbr != null; nbr = nbr.next) {
//			// nbr.setWeight(v);
//			tempWeight2 = nbr.weight;
//			// System.out.println("tempWeight2: " + tempWeight2);
//			if (tempWeight2 <= selectedWeight && selectedWeight >= 0) {
//	
//				System.out.println(tempWeight2 + " <= " + selectedWeight
//						+ " && " + selectedWeight + " >= 0: true");
//	
//				if (!gotVisited(graph.adjLists[nbr.vertexNum])) {
//					selectedWeight = tempWeight2;
//	
//					System.out.println("graph.adjLists[nbr.vertexNum]: "
//							+ graph.adjLists[nbr.vertexNum].name);
//					visited.add(graph.adjLists[nbr.vertexNum]);
//					System.out.println("visited to string: " + visited);
//				}
//			}
//		}
//		// checkVisited(newest);
//		System.out.println("tempWeight: " + selectedWeight);
//	
//		// Vertex startVertex = visited[current];
//	}
//	
//	public void getNearestNeighbour() {
//		for (int i = 0; i < graph.adjLists.length; i++) {
//			getNearestFromCurrent(i);
//		}
//	
//	}
//	
//	public boolean gotVisited(Vertex vertex) {
//		boolean check = false;
//		check = visited.contains(vertex);
//		return check;
//	}
//	
//	public boolean checkVisited(Vertex vertex) {
//		boolean wasVisited = true;
//		boolean check = true;
//	
//		// for (int i = 0; i <= visited.size(); i++) {
//		check = visited.contains(vertex);
//		// System.out.println("check for " + vertex.name + " is: " + check);
//		if (!visited.contains(vertex)) {
//			wasVisited = false;
//			// System.out.println("wasVisited for " + vertex.name + " is: " +
//			// wasVisited);
//		}
//		// }
//		return wasVisited;
//	}
//}