
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Solution
 * UVa 12519
 * https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1756
 * @author Joe
 */

public class TheFarnsworthParabox {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = "";
		
		while (!(line = in.readLine()).equals("0 0")) {
			String arrL[] = line.split(" ");
			int v = Integer.parseInt(arrL[0]);
			int e = Integer.parseInt(arrL[1]);
			
			Graph g = new Graph(v, e*2);
			
			
			for (int i = 0; i < e*2; i++) {
				arrL = in.readLine().split(" ");
				int src = Integer.parseInt(arrL[0]);
				int dest = Integer.parseInt(arrL[1]);
				int weight = Integer.parseInt(arrL[2]);
				
				g.edge[i].src = src-1;
				g.edge[i].dest = dest-1;
				g.edge[i].weight = weight;
				
				g.edge[i+1].src = dest-1;
				g.edge[i+1].dest = src-1;
				g.edge[i+1].weight = -weight;
				i++;
			}
			
			out.write((g.BellmanFord(g, 0)?"Y":"N")+"\n");
			
		}
		
		
		in.close();
		out.close();
	}
	
	
	public static class Edge {
		int src, dest, weight;
		public Edge() {
			src = dest = weight = 0;
		}
	}
	public static class Graph {

		int V, E;
		Edge edge[];

		public Graph(int v, int e) {
			V = v;
			E = e;
			edge = new Edge[e];
			for (int i = 0; i < e; ++i)
				edge[i] = new Edge();
		}

		public boolean BellmanFord(Graph graph, int src) {
			int V = graph.V, E = graph.E;
			int dist[] = new int[V];
			for (int i = 0; i < V; ++i)
				dist[i] = Integer.MAX_VALUE;
			dist[src] = 0;

			for (int i = 1; i < V; ++i) {
				for (int j = 0; j < E; ++j) {
					int u = graph.edge[j].src;
					int v = graph.edge[j].dest;
					int weight = graph.edge[j].weight;
					if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
						dist[v] = dist[u] + weight;
				}
			}

			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					return true;
			}
			return false;
		}

	}
}

