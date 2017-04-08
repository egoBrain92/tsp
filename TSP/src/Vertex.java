class Vertex {
	String name;

	int x = 0;
	int y = 0;
	boolean visited = false;
	
	Neighbor adjList;

	Vertex(String name, int x, int y, Neighbor neighbors) {
		this.name = name;
		this.x = x;
		this.y = y;
		this.adjList = neighbors;
	}
	@Override
	public String toString(){
		String returnString = "(" + name + " " + x + " " + y + ")";
		return returnString;
		
	}
}