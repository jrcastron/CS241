package Heap;

public class HeapRe {

	private static final int DEFAULT_CAPACITY = 100;

	private int[] data;
	private int lastIndex;
	private int swaps = 0;

	public int getSwaps(){
		return swaps;
	}
	
	public HeapRe() {
		this(DEFAULT_CAPACITY);
	}

	public HeapRe(int capacity) {
		data = new int[capacity + 1];
		lastIndex = 0;
	}

	public void add(int[] newEntry) {
		if (lastIndex == data.length - 1) {
			increaseCapacity();
		}
		for(int i = 0; i < newEntry.length; i++){
			lastIndex++;
			data[lastIndex] = newEntry[i];
		}
		for(int rootIndex = lastIndex; rootIndex > 0; rootIndex--){
			reheap(rootIndex);
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
		reheap(1);
		return res;
	}

	private void reheap(int rootIndex) {
		int cursorIndex = rootIndex;
			while(cursorIndex < lastIndex) {
				int leftChildIndex = cursorIndex * 2;
				int rightChildIndex = cursorIndex * 2 + 1;
				int largerChildIndex = leftChildIndex;
				if (rightChildIndex <= lastIndex && data[rightChildIndex] > data[largerChildIndex]) {
					largerChildIndex = rightChildIndex;
				}
				if (largerChildIndex <= lastIndex && data[largerChildIndex] > data[cursorIndex]) {
					int temp = data[largerChildIndex];
					data[largerChildIndex] = data[cursorIndex];
					data[cursorIndex] = temp;
					swaps++;
					cursorIndex = largerChildIndex;
				}
				else{
					cursorIndex = lastIndex;
				}
		}
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
