package edu.cpp.cs241.kmdo;

public class BinaryTree<T> implements BinaryTreeInterface<T> 
{
	private BinaryNode<T> root;
	
	public BinaryTree()
	{
		this(null);
	}
	
	public BinaryTree(T rootData)
	{
		this(rootData, null, null);
	}
	
	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	}
	
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
	{
		root = new BinaryNode<>(rootData);
		
		if ((leftTree != null) && (!leftTree.isEmpty()))
			root.setLeftChild(leftTree.root);
		
		if((rightTree != null) && (!rightTree.isEmpty()))
		{
			if(rightTree != leftTree)
				root.setRightChild((rightTree.root));
			else
				root.setRightChild(rightTree.root);
		}
		
		if ((leftTree != null) && (leftTree != this))
			leftTree.clear();
		
		if((rightTree != null) && (rightTree != this))
			rightTree.clear();
	}

	
	@Override
	public T getRootData() {
		T rootData = null;
		
		if(root != null)
			rootData = root.getData();
		return rootData;
	}
	
	public void setRootData(T newData)
	{
		root.setData(newData);
	}
	
	public void setRootNode(BinaryNodeInterface<T> newRoot)
	{
		root = (BinaryNode<T>) newRoot;
	}

	public BinaryNode<T> getRootNode()
	{
		return root;
	}
	
	@Override
	public int getHeight() 
	{
	    if(root != null)
		return root.getHieght();
	    return 0;
	}

	@Override
	public int getNumberOfNodes() 
	{
	    if(root != null)
		return root.getNumberOfNodes();
	    return 0;
	}

	@Override
	public boolean isEmpty() 
	{
	    return root == null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root = null;
	}

	@Override
	public void setTree(T rootData) {
		root = new BinaryNode<>(rootData);
	}

	@Override
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree) {
		privateSetTree(rootData, (BinaryTree<T>) leftTree, (BinaryTree<T>) rightTree);
	}
	
	public void inorderTraverse()
	{
		inorderTraverse(root);
	}
	
	private void inorderTraverse(BinaryNodeInterface<T> node)
	{
		if(node != null)
		{
			inorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + " ");
			inorderTraverse(node.getRightChild());
		}
	}
	
	public void preorderTraverse()
	{
		preorderTraverse(root);
	}
	
	private void preorderTraverse(BinaryNodeInterface<T> node)
	{
		if(node != null)
		{
			System.out.print(node.getData() + " ");
			inorderTraverse(node.getLeftChild());
			inorderTraverse(node.getRightChild());
		}
	}
	
	public void postorderTraverse()
	{
		postorderTraverse(root);
	}
	
	private void postorderTraverse(BinaryNodeInterface<T> node)
	{
		if(node != null)
		{
			inorderTraverse(node.getLeftChild());
			inorderTraverse(node.getRightChild());
			System.out.print(node.getData() + " ");
		}
	}

}
