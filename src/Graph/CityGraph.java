package Graph;
import java.util.*;

public class CityGraph<T> {
	
	private int[][] edges;
	private T[] labels;
	private int[] distances;

	@SuppressWarnings("unchecked")
	public CityGraph(int n) {
		edges = new int[n + 1][n + 1];
		labels = (T[]) new Object[n + 1];
		distances = new int[n + 1];
	}
	
	public int getDistance(int label){
		return distances[label];
	}

	public boolean isEdge(int src, int trg) {
		return edges[src][trg] > 0;
	}

	public int getWeight(int src, int trg) {
		return edges[src][trg];
	}

	public void addEdge(int src, int trg, int distance) {
		edges[src][trg] = distance;
	}

	public void removeEdge(int src, int trg) {
		edges[src][trg] = 0;
	}

	public T getLabel(int vertex) {
		return labels[vertex];
	}
	

	public int[] neightbors(int vertex) {
		int count = 0;
		for(int i = 1; i < edges.length; i++) {
			if (edges[vertex][i] > 0) {
				count++;
			}
		}
		int[] nei = new int[count];
		int index = 0;
		for(int i = 0; i < edges.length; i++) {
			if (edges[vertex][i] > 0) {
				nei[index++] = i;
			}
		}
		return nei;
	}

	public void setLabel(int vertex, T label) {
		labels[vertex] = label;
	}

	public int size() {
		return labels.length;
	}

	public Stack<Integer> dijistra(int src, int trg) {
		Map<Integer, Integer> prevMap = new HashMap<Integer, Integer>();
		Queue<Integer> distQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return distances[o1] - distances[o2];
			}
		});
		for(int i = 1; i < labels.length; i++) {
			distances[i] = (i == src ? 0 : Integer.MAX_VALUE);
			distQueue.add(i);
		}

		while(!distQueue.isEmpty()) {
			Integer current = distQueue.poll();
			if (distances[current] == Integer.MAX_VALUE) {
				break;
			}
			int[] neis = neightbors(current);
			for(int n : neis) {
				int atl = distances[current] + getWeight(current, n);
				if (distQueue.contains(n) && atl < distances[n]) {
					distances[n] = atl;
					prevMap.put(n, current);
					distQueue.remove(n);
					distQueue.add(n);
				}
			}
		}

		//System.out.println(prevMap);
		// print out the path
		Stack<Integer> trace = new Stack<Integer>();
		trace.push(trg);
		int current = trg;
		while (current != src) {
			if (prevMap.containsKey(current)) {
				current = prevMap.get(current);
				trace.push(current);
			} else {
				System.out.println("No shortest path.");
				return null;
			}
		}
		return trace;
	}


}
