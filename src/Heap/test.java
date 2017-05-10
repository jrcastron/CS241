package Heap;
import java.util.*;

public class test {
	public static void main(String args[]){
		
		Scanner k = new Scanner(System.in);
		Random r = new Random();
		HeapSequencial Hs = new HeapSequencial();
		HeapRe Hr = new HeapRe();
		
		int flag = 0;
		int swapsS = 0;
		int swapsR = 0;
		while(flag >= 0){
		System.out.println("Run with random integers: enter 1\nRun with set integers 1 - 100: enter 2"
				+ "\nenter a negative number to quite");
		int wich = k.nextInt();
		if((wich == 1)&&(wich >= 0)){
			System.out.println("use sequential: enter 1\nuse reheap: enter2\nenter a negative number to quite");
			int wich2 = k.nextInt();
			int rando;
			if((wich2 == 1)&&(wich2 >= 0)){
				Hs.clear();
				Vector<Integer> v = new Vector<>();
				while(v.size() < 101){
					rando = r.nextInt(101);
					if(!v.contains(rando)){
						v.addElement(rando);
					}
				}
				for(int i = 0; i < v.size(); i++){
					Hs.add(v.elementAt(i));
				}
				System.out.println("sequential swaps done: " + Hs.getSwaps());
				swapsS = swapsS + Hs.getSwaps();
			}
			else if(wich2 >= 0){
				Hr.clear();
				Vector<Integer> v2 = new Vector<>();
				while(v2.size() < 101){
					rando = r.nextInt(101);
					if(!v2.contains(rando)){
						v2.addElement(rando);
					}
				}
				int[] array1 = new int[100];
				for(int i = 0; i < 100; i++){
					array1[i] = v2.elementAt(i);
				}
				Hr.add(array1);
				System.out.println("reHeap swaps done: " + Hr.getSwaps());
				swapsR = swapsR + Hr.getSwaps();
			}
		}
		else if(wich >= 0){
			System.out.println("use sequential: enter 1\nuse reheap: enter2\n"
					+ "enter negative number to quite");
			int wich2 = k.nextInt();
			if((wich2 == 1)&&(wich2 >= 0)){
				Hs.clear();
				for(int i = 1; i < 101; i++){
					Hs.add(i);
				}
				for(int i = 0; i < 10; i++){
					Hs.removeMax();
				}
				System.out.println(Hs.printTen());
				System.out.println("sequential swaps done: " + Hs.getSwaps());
				swapsS = swapsS + Hs.getSwaps();
			}
			else if((wich2 == 2)&&(wich2 >= 0)){
				Hr.clear();
				int[] array1 = new int[100];
				for(int i = 0; i < 100; i++){
					array1[i] = i+1;
				}
				Hr.add(array1);
				for(int i = 0; i < 10; i++){
					Hr.removeMax();
				}
				System.out.println(Hr.printTen());
				System.out.println("reHeap swaps done: " + Hr.getSwaps());
				swapsR = swapsR + Hr.getSwaps();
			}
			else {
				flag = -1;
			}
		}
		else{
			flag = -1;
		}
		}
		swapsS = swapsS / 2;
		swapsR = swapsR / 2;
		System.out.println("sequential average swaps: " + swapsS);
		System.out.println("reHeap average swaps: " + swapsR);
	}
}
