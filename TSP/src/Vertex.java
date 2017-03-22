class Vertex {
	String name;

	int x = 0;
	int y = 0;

	Neighbor adjList;

	Vertex(String name, int x, int y, Neighbor neighbors) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.adjList = neighbors;
	}
}