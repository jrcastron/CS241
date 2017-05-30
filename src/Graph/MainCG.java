package Graph;

import java.io.*;
import java.util.*;

public class MainCG {
	public static void main(String args[])throws IOException{

		Scanner k = new Scanner(System.in);
		Scanner file1 = new Scanner(new File("city.dat"));
		Scanner file2 = new Scanner(new File("road.dat"));
		List<int[]> edge = new ArrayList<int[]>();
		Map<String, String[]> dataKey = new HashMap<String, String[]>();
		Map<Integer, String[]> dataLabel = new HashMap<Integer, String[]>();
		
		while(file1.hasNextLine()){
			int temp = file1.nextInt();
			String code = file1.next();
			String data1 = "";
			while(!file1.hasNextInt()){
				data1 += file1.next();
			}
			String data2 = file1.next();
			String data3 = file1.next();
			file1.nextLine();
			String[] data = {temp + "",code,data1,data2,data3};
			dataKey.put(code, data);
			dataLabel.put(temp, dataKey.get(code));
			if(!file1.hasNext()){
				break;
			}
		}
		
		CityGraph<String[]> graph = new CityGraph<String[]>(dataLabel.size());
		
		while(file2.hasNextInt()){			
			graph.addEdge(file2.nextInt(), file2.nextInt(), file2.nextInt());
			if(file2.hasNextLine()){
				file2.nextLine();
			}
		}
		
		for(int i = 1; i < dataLabel.size() + 1; i++){
			graph.setLabel(i, dataLabel.get(i));
		}
		
		boolean flag = false;
		while(!flag){
			System.out.println("Command?");
			String pick = k.nextLine();
			switch(pick){
			case "H":{
				System.out.println("Q\tQuery the information by entering city code.\n"
						+ "D\tFind the minimum distance between two cities.\n"
						+ "I\tInstert a road by entering two city codes and distances\n"
						+ "R\tRemove an existing road by entering two city codes.\n"
						+ "H\tDisplay this message.\n"
						+ "E\tExit.");				
				break;
			}
			case "Q":{
				System.out.println("city code:");
				String[] temp = dataKey.get(k.nextLine());
				for(int i = 0; i < temp.length; i++){
					System.out.print(temp[i] + " ");
				}
				System.out.println();
				break;
			}
			case "D":{
				System.out.println("City codes:");
				String[] temp1 = dataKey.get(k.next());
				int src = Integer.parseInt(temp1[0]);
				String[] temp2 = dataKey.get(k.next());
				int trg = Integer.parseInt(temp2[0]);
				k.nextLine();
				Stack<Integer> trace = graph.dijistra(src, trg);
				System.out.println("The minimum distance between " + temp1[2] + " and " + temp2[2] +
						" is " + graph.getDistance(Integer.parseInt(temp2[0]))
								+ " through route: ");
				if(trace != null){
					while (!trace.isEmpty()) {
						String[] temp3 = graph.getLabel(trace.pop());
						System.out.print(temp3[1] + ", ");
					}
					System.out.println();
				}
				break;
			}
			case "I":{
				System.out.println("City codes and distance:");
				try{
					String[] temp1 = dataKey.get(k.next());
					int src = Integer.parseInt(temp1[0]);
					String[] temp2 = dataKey.get(k.next());
					int trg = Integer.parseInt(temp2[0]);
					int dist = k.nextInt();
					k.nextLine();
					if(!graph.isEdge(src, trg)){
						graph.addEdge(src, trg, dist);
						System.out.println("You have inserted a road from " + temp1[2] + " to " + temp2[2] +
								" with distance " + graph.getWeight(src, trg));
					}
					else{
						System.out.println("a road between these cities already exists, please remove it first.");
					}
				}
				catch(NullPointerException e){
					System.out.println("one of the city codes doesn't exist");
				}
				break;
			}
			case "R":{
				System.out.println("City codes:");
				String[] temp1 = dataKey.get(k.next());
				try{
					int src = Integer.parseInt(temp1[0]);
					String[] temp2 = dataKey.get(k.next());
					int trg = Integer.parseInt(temp2[0]);
					k.nextLine();
					graph.removeEdge(src, trg);
					if(!graph.isEdge(src, trg)){
						System.out.println("The road from " + temp1[2] + " to " + temp2[2] + " doesn't exist");
					}
				}
				catch(NullPointerException e){
					System.out.println("one of the city codes doesn't exist");
				}
				break;
			}
			case "E":{
				flag = true;
				break;
			}
			default:{
				pick = "H";
			}
			}
		}
		file1.close();
		file2.close();
		
	}
}
