class Neighbor {
	public int vertexNum;
	public int weight = 0;
	public Neighbor next;

	public Neighbor(int vnum, Neighbor nbr, int weight) {
		this.vertexNum = vnum;
		next = nbr;
		this.weight = weight;
	}
	
	public void setWeight(int target){
		int xStart = GVL.graph.adjLists[vertexNum].x;
		int yStart = GVL.graph.adjLists[vertexNum].y;
		int xEnd = GVL.graph.adjLists[target].x;
		int yEnd = GVL.graph.adjLists[target].y;
		int xDis = -1;
		int yDis = -1;
		double dis = -1;
		
		xDis = Math.abs(xStart - xEnd);
		yDis = Math.abs(yStart - yEnd);
		dis = Math.sqrt((xDis * xDis)+ (yDis * yDis));
		this.weight = (int) dis;
	}
}