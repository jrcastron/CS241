package Trees;

public class BinaryTreeNode<T> {
	
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;
	
	public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T data){
		this.left = left;
		this.right = right;
		this.data = data;
	}
	
	public BinaryTreeNode( T data ){
		this.data = data;
		left = null;
		right = null;
	}
	
	public BinaryTreeNode<T> GetLeft(){
		return left;
	}
	
	public BinaryTreeNode<T> GetRight(){
		return right;
	}
	
	public T GetData(){
		return data;
	}
	
	public void SetLeft(BinaryTreeNode<T> left){
		this.left = left;
	}
	
	public void SetRight(BinaryTreeNode<T> right){
		this.right = right;
	}
	
	public void SetData(T data){
		this.data = data;
	}
	
	public void PreOrderTraversal( BinaryTreeNode<T> root ){
		if( !(root == null)){
			System.out.print(root.GetData() + " ");
			PreOrderTraversal(root.GetLeft());
			PreOrderTraversal(root.GetRight());
		}
	}
	
	public void InOrderTraversal( BinaryTreeNode<T> root ){
		if( !(root == null)){
			InOrderTraversal(root.GetLeft());
			System.out.print(root.GetData() + " ");
			InOrderTraversal(root.GetRight());
		}
	}
	
	public void PostOrderTraversal( BinaryTreeNode<T> root ){
		if( !(root == null)){
			PostOrderTraversal(root.GetLeft());
			PostOrderTraversal(root.GetRight());
			System.out.print(root.GetData() + " ");
		}
	}
	
	public BinaryTreeNode<T> RightMost(){
		if(right == null){
			return this;
		}
		else{
			return right.RightMost();
		}
	}
	
	public BinaryTreeNode<T> LeftMost(){
		if(left == null){
			return this;
		}
		else{
			return left.LeftMost();
		}
	}
	
	//not needed any more
	public void RemoveRigthMost(BinaryTreeNode<T> parent){
		if(right == null){
			parent.SetLeft(null);
		}
		else if(right.GetRight() == null){
			this.SetRight(null);
		}
		else{
			right.RemoveRigthMost(parent);
		}
	}

}
