package Trees;
import java.util.*;

public class main {

	public static void main(String args[]){
		BinarySearchTree tree1;
		BinaryTreeNode<Integer> root;
		Scanner k = new Scanner(System.in);
		
		String str;
		System.out.println("Please enter values: ");
		str = k.nextLine();
		String[] nums = str.split(" ");
		int[] finalArray = new int[nums.length];
		for(int i = 0; i < nums.length; i++){
			finalArray[i] = Integer.parseInt(nums[i]);
		}
		
		root = new BinaryTreeNode<Integer>(finalArray[0]);
		tree1 = new BinarySearchTree(root);
		for(int i = 1; i < finalArray.length; i++){
			tree1.AddEntry(finalArray[i]);
		}
		
		System.out.println("PreOrder:");
		tree1.GetRoot().PreOrderTraversal(tree1.GetRoot());
		System.out.println("\nInOrder:");
		tree1.GetRoot().InOrderTraversal(tree1.GetRoot());
		System.out.println("\nPostOrder:");
		tree1.GetRoot().PostOrderTraversal(tree1.GetRoot());
		
		boolean exit = false;
		String message = ("Command? \nI Insert value\nD Delete value\nP Find predecessor"
				+ "\nS findSucessor\nE exit program\nH display message");
		System.out.println(message);
		while(!exit){
			System.out.println("command? ");
			str = k.nextLine();
			switch(str){
			case "I":{
				System.out.println("enter value to insert: ");
				tree1.AddEntry(k.nextInt());
				System.out.println("\nInOrder:");
				tree1.GetRoot().InOrderTraversal(tree1.GetRoot());
				break;
			}
			case "D":{
				System.out.println("enter value to delete: ");
				tree1.Remove(k.nextInt());
				System.out.println("\nInOrder:");
				tree1.GetRoot().InOrderTraversal(tree1.GetRoot());
				break;
			}
			case "P":{
				System.out.println("enter value to get predecessor of: ");
				BinaryTreeNode<Integer> temp = tree1.Predecessor(k.nextInt());
				if(temp != null){
					System.out.println(temp.GetData());
				}
				else{
					System.out.println("null");
				}
				System.out.println("\nInOrder:");
				tree1.GetRoot().InOrderTraversal(tree1.GetRoot());
				break;
			}
			case "S":{
				System.out.println("enter value to get sucessor of: ");
				BinaryTreeNode<Integer> temp = tree1.Sucessor(k.nextInt());
				if(temp != null){
					System.out.println(temp.GetData());
				}
				else{
					System.out.println("null");
				}
					System.out.println("\nInOrder:");
					tree1.GetRoot().InOrderTraversal(tree1.GetRoot());
				break;
			}
			case "E":{
				System.out.println("Bye :3");
				exit = true;
				break;
			}
			case "H":{
				System.out.println(message);
				break;
			}
			}
		}
		
	}
	
}
