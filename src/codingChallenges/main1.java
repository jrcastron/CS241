package codingChallenges;
import java.util.*;

public class main1 {
	
	public static void main(String args[]){
	}

	//questian 1
	static int kDifference(int[] a, int k) {
		int num = 0;
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		for(int i = 0; i < a.length; i++){
			ht.put(a[i], i);
		}
		for(int i = 0; i < a.length; i++){
			if(ht.containsKey(a[i] + k)){
				num++;
			}
		}
		return num;
		
    }
	
	
	//questian 2
    static String[] ReduceFraction(String[] fractions) {

    	String[] array = new String[fractions.length];
    	for(int i = 0; i < fractions.length; i++){
    		String str = fractions[i];
    		String[] nums = str.split("/");
    		int num = Integer.parseInt(nums[0]);
    		int dem = Integer.parseInt(nums[1]);
    		int gcd = GCD(num, dem);
    		array[i] = (num/gcd) + "/" + (dem/gcd);
    	}
    	
    	return array;

    }
    
    static int GCD(int num, int dem){
    	if(num == 0 || dem == 0){
    		return num+dem;
    	}
    	else{
    		return GCD(dem, num%dem);
    	}
    }
    
    //question 3
    static LinkedListNode removeNodes(LinkedListNode list, int x) {

    	LinkedListNode head = null;
    	LinkedListNode tail = null;

    	while(list != null){
        	int i = list.val;
        	if(i <= x){
        		if(head == null){
        			head = new LinkedListNode(i);
        			tail = head;
        		}
        		else{
        			tail.next = new LinkedListNode(i);
        			tail = tail.next;
        		}
        	}
        	list = list.next;
    	}
    	return head;
    }
    
    public static class LinkedListNode{
        int val;
        LinkedListNode next;
    
        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    };
    
    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }
}
	
