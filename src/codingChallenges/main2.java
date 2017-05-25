package codingChallenges;

public class main2 {
	public static void main(String args[]){
	
	//Test one
		class Solution {
		    class LinkedListNode{
		        int val;
		        LinkedListNode next;
		    
		        LinkedListNode(int node_value) {
		            val = node_value;
		            next = null;
		        }
		    };
		    
		    public LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
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
		    
		    public LinkedListNode distinct(LinkedListNode head) {
		    	LinkedListNode sol = null;
		        LinkedListNode tail = null;
		        while(head!=null){
			        if(sol == null) {
			            sol = new LinkedListNode(head.val);
			            tail = sol;
			        }
			        else {
			        	LinkedListNode temp = sol;
			        	boolean flag = false;
			        	while(temp!=tail.next){
				        	if(head.val == temp.val){
	                            flag = true;
				        	}
				        	temp = temp.next;
				        }
			        	if(!flag){
				            tail.next = new LinkedListNode(head.val);
				            tail = tail.next;
			        	}
			        }
			        head = head.next;
		        }
		        
		        return sol;
		    }
		    
		    //part 2
		    int getIntegerComplement(int n) {
		    	int[] num = new int[17];
		    	int sol = 0;
		    	for(int i = 0; i < num.length; i++){
		    		num[i] = 0;
		    	}
                int index = 0;
		    	while(n > 0){
		    		num[index++] = n%2;
                    n = n/2;
		    	}
        
		    	for(int i = num.length - 1; i >= 0; i--){
                    if(num[i] == 1){
                        for(int j = i; j >= 0; j--){
                            if(num[j] == 0){
                               sol = sol +(int)(Math.pow(2,j));
                            }
                        }
                        break;
                    }
		    	}

		    	return sol;
		    }


		    //part3
		    String isPangram(String[] strings) {

		    	String sol = "";
		    	int sum = 0;
		    	char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'
		    			, 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		    	for(int i = 0; i < strings.length; i++){
		    		sum = 0;
		    		for(char letter : letters){
		    			if(strings[i].indexOf(letter)!=-1){
		    				sum++;
		    			}
		    		}
		    		if(sum == 26){
		    			sol += "1";
		    		}
		    		else{
		    			sol += "0";
		    		}
		    	}

		    	return sol;
		    }
	}
	}
}
