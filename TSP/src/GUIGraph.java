import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GUIGraph extends JPanel implements ActionListener {

	public Graph graph = new Graph();
	Timer tm = new Timer(GVL.guiUpdateRate, this); // 10ms updaterate = 100fps

	public GUIGraph(Graph graph) {
		this.graph = graph;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // needed for compatibility
		g.setColor(Color.blue);

		paintGraph(g);

		tm.start();
	}

	public void paintGraph(Graphics g) {

		int xAdjusted = 0;
		int yAdjusted = 0;

		int xLineStart = 0;
		int yLineStart = 0;

		int xLineEnd = 0;
		int yLineEnd = 0;

		g.setColor(Color.blue);
		for (int v = 0; v < graph.verticesCounter; v++) {

			xAdjusted = (graph.adjLists[v].x) - (GVL.vertexDotSize / 2);
			yAdjusted = (graph.adjLists[v].y) - (GVL.vertexDotSize / 2);

			// adjust for city dot size so that dot center is actual position
			// are centered
			g.fillOval(xAdjusted, yAdjusted, GVL.vertexDotSize,
					GVL.vertexDotSize);

			for (Neighbor nbr = graph.adjLists[v].adjList; nbr != null; nbr = nbr.next) {

				xLineStart = graph.adjLists[v].x;
				yLineStart = graph.adjLists[v].y;

				xLineEnd = graph.adjLists[nbr.vertexNum].x;
				yLineEnd = graph.adjLists[nbr.vertexNum].y;

				// paint edges
				g.drawLine(xLineStart, yLineStart, xLineEnd, yLineEnd);
			}
		}
		// paint starting dot in red ontop of everything else
		g.setColor(Color.red);
		xAdjusted = (graph.adjLists[0].x) - (int) (GVL.vertexDotSize / 2);
		yAdjusted = (graph.adjLists[0].y) - (int) (GVL.vertexDotSize / 2);
		g.fillOval(xAdjusted, yAdjusted, GVL.vertexDotSize, GVL.vertexDotSize);
		g.setColor(Color.blue);
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
