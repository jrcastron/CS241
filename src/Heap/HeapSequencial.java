package Heap;

public class HeapSequencial {
	
	private static final int DEFAULT_CAPACITY = 100;

	private int[] data;
	private int lastIndex;
	private int swaps = 0;

	public int getSwaps(){
		return swaps;
	}
	
	public HeapSequencial() {
		this(DEFAULT_CAPACITY);
	}

	public HeapSequencial(int capacity) {
		data = new int[capacity + 1];
		lastIndex = 0;
	}

	public void add(int newEntry) {
		if (lastIndex == data.length - 1) {
			increaseCapacity();
		}
		lastIndex++;
		data[lastIndex] = newEntry;
		int cursorIndex = lastIndex;
		while (cursorIndex > 1) {
			int parentIndex = cursorIndex / 2;
			if (data[parentIndex] < data[cursorIndex]) {
				int tmp = data[parentIndex];
				data[parentIndex] = data[cursorIndex];
				data[cursorIndex] = tmp;
				swaps++;
				cursorIndex = cursorIndex / 2;
			}
			else{
				break;
			}
		}
	}

	private void increaseCapacity() {
		int[] data2 = new int[data.length * 2];
		for(int i = 0; i < data.length; i++) {
			data2[i] = data[i];
		}
		data = data2;
	}

	public int removeMax() {
		if (isEmpty()) {
			throw new RuntimeException("Empty heap. No element to get.");
		}
		int res = data[1];
		data[1] = data[lastIndex];
		lastIndex--;
		int cursor = 1;
		while(cursor < lastIndex){
			int leftChild = cursor * 2;
			int rightChild = cursor * 2 + 1;
			int bigger = leftChild;
			if (rightChild <= lastIndex && data[rightChild] > data[bigger]) {
				bigger = rightChild;
			}
			if (bigger <= lastIndex && data[bigger] > data[cursor]) {
				int temp = data[bigger];
				data[bigger] = data[cursor];
				data[cursor] = temp;
				swaps++;
				cursor = bigger;
			} else {
				break;
			}
		}
		return res;
	}

	public int getMax() {
		if (lastIndex == 0) {
			throw new RuntimeException("Empty heap. No max element.");
		}
		return data[1];
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public int getSize() {
		return lastIndex;
	}

	public void clear() {
		lastIndex = 0;
	}

	public String toString() {
		String res = "[";
		for(int i = 1; i <= lastIndex; i++) {
			res += data[i] + "  ";
		}
		res += "]";
		return res;
	
	}
	
	public String printTen(){
		String res = "[";
		for(int i = 1; i <= 10; i++) {
			res += data[i] + "  ";
		}
		res += "]";
		return res;
	}

}
