package Trees;

public class BinarySearchTree {
	
	private BinaryTreeNode<Integer> root;
	
	public BinarySearchTree( BinaryTreeNode<Integer> root){
		this.root = root;
	}
	
	public BinaryTreeNode<Integer> GetRoot(){
		return root;
	}
	
	public void AddEntry(int newData){
		if(root == null){
			root = new BinaryTreeNode<Integer>( newData );
		}
		else{
			AddEntry(root, newData);
		}
	}
	
	private void AddEntry(BinaryTreeNode<Integer> root, int newData){
		if(newData <= root.GetData()){
			if(root.GetLeft() == null){
				root.SetLeft(new BinaryTreeNode<Integer>(newData));
			}
			else{
				AddEntry(root.GetLeft(), newData);
			}
		}
		else{
			if(root.GetRight() == null){
				root.SetRight(new BinaryTreeNode<Integer>(newData));
			}
			else{
				AddEntry(root.GetRight(), newData);
			}
		}
	}
	
	public void Remove(int removeData){
		if(root.GetData() == removeData){
			throw new RuntimeException("dont delete root :P");
			}
		Remove(root, removeData, null);
	}
	
	private void Remove(BinaryTreeNode<Integer> root, int removeData, BinaryTreeNode<Integer> parent){
		if(root == null ){
			System.out.println("does not exist");
		}
		else if(root.GetData() == removeData){
			//case 1 is leaf
			if(root.GetLeft() == null && root.GetRight() == null){
				System.out.println("case 1");
				if(parent.GetLeft() != null){
					if(parent.GetLeft().GetData() == removeData){
						parent.SetLeft(null);
					}
					else{
						parent.SetRight(null);
					}
				}
				else{
					parent.SetRight(null);
				}
			}
			//case 2 no left
			else if(root.GetLeft() == null){
				System.out.println("case 2");
				if(parent.GetLeft() != null){
					if(parent.GetLeft().GetData() == removeData){
						parent.SetLeft(root.GetRight());
					}
					else{
						parent.SetRight(root.GetRight());
					}
				}
				else{
					parent.SetRight(root.GetRight());
				}
			}
			//casse 3 no right
			else if(root.GetRight() == null){
				System.out.println("case 3");
				if(parent.GetLeft() != null){
					if(parent.GetLeft().GetData() == removeData){
						parent.SetLeft(root.GetLeft());
					}
					else{
						parent.SetRight(root.GetLeft());
					}
				}
				else{
					parent.SetRight(root.GetLeft());
				}
			}
			//case 4 two nodes
			else{
				System.out.println("case 4");
					root.SetData(root.GetLeft().RightMost().GetData());
					if(root.GetLeft().RightMost().GetLeft() == null){
//						root.GetLeft().RemoveRigthMost(root);
						Remove(root.GetLeft(), root.GetLeft().RightMost().GetData(), root);
					}
					else if(root.GetLeft() == root.GetLeft().RightMost()){
						/*
						while(root.GetLeft().RightMost().GetLeft() != null){
							root.GetLeft().SetData(root.GetLeft().GetLeft().GetData());
							parent = root;
							root = root.GetLeft();
						}
//						root.GetLeft().RemoveRigthMost(root);
						 */
						root.GetLeft().SetData(root.GetLeft().GetLeft().GetData());
						Remove(root.GetLeft().GetLeft(), root.GetLeft().GetLeft().GetData(), root.GetLeft());
					}
				}
			}
		else{
			if(removeData < root.GetData()){
				System.out.println("less");
				Remove(root.GetLeft(), removeData, root);
			}
			else{
				System.out.println("greater");
				Remove(root.GetRight(), removeData, root);
			}
		}
	}
	
	public BinaryTreeNode<Integer> Predecessor(int findData){
		if(root.GetData() == findData){
			if(root.GetLeft() != null){
				return root.GetLeft().RightMost();
			}
			else{
				return null;
			}
		}
		return Predecessor(root, findData, root);
	}
	
	private BinaryTreeNode<Integer> Predecessor(BinaryTreeNode<Integer> root, int findData, BinaryTreeNode<Integer> topRoot){
		if(root == null){
			System.out.println("root = null");
			return null;
		}
		else if(root.GetData() == findData){
			BinaryTreeNode<Integer> predecessor = null;
			if(root.GetLeft() != null){
				return root.GetLeft().RightMost();
			}
			else{
				while (topRoot != null) {
					if (findData == topRoot.GetData()) {
						// by now we might found our predecessor
						break;
					} 
					else if (findData < topRoot.GetData()) {
						topRoot = topRoot.GetLeft();
					} 
					else if (findData > topRoot.GetData()) {
						predecessor = topRoot;
						topRoot = topRoot.GetRight();
					}
				}
				return predecessor;
			}
		}
		else if(root.GetData() > findData){
			return Predecessor(root.GetLeft(), findData, topRoot);
		}
		else{
			return Predecessor(root.GetRight(), findData, topRoot);
		}
	}
	
	public BinaryTreeNode<Integer> Sucessor(int findData){
		if(root.GetData() == findData){
			if(root.GetRight() != null){
				return  root.GetRight();
			}
			else{
				return null;
			}
		}
		return Sucessor(root, findData, null, root);
	}
	
	private BinaryTreeNode<Integer> Sucessor(BinaryTreeNode<Integer> root, int findData, BinaryTreeNode<Integer> parent, BinaryTreeNode<Integer> topRoot){
		if(root == null){
			return null;
		}
		else if(root.GetData() == findData){
			if(root.GetRight() != null){
				return root.GetRight();
			}
			else{
					BinaryTreeNode<Integer> sucessor = null;
					while (topRoot != null) {
						if (findData == topRoot.GetData()) {
							// by now we might found our predecessor
							break;
						} 
						else if (findData > topRoot.GetData()) {
							topRoot = topRoot.GetRight();
						} 
						else if (findData < topRoot.GetData()) {
							sucessor = topRoot;
							topRoot = topRoot.GetLeft();
						}
					}
					return sucessor;
			}
		}
		else if(root.GetData() > findData){
			return Sucessor(root.GetLeft(), findData, root, topRoot);
		}
		else{
			return Sucessor(root.GetRight(), findData, root, topRoot);
		}
	}

}
