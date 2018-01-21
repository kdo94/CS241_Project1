package edu.cpp.cs241.kmdo;

public class BinaryNode<T> implements BinaryNodeInterface <T>
{
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	public BinaryNode()
	{
		this(null);
	}
	
	public BinaryNode(T newData)
	{
		this(newData, null, null);
	}
	
	public BinaryNode(T newData, BinaryNode<T> newLeftChild, BinaryNode<T> newRightChild)
	{
		data = newData;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	@Override
	public T getData() 
	{
		return data;
	}

	@Override
	public void setData(T newData) 
	{
		data = newData;
	}

	@Override
	public BinaryNodeInterface<T> getLeftChild() 
	{
		return leftChild;
	}

	@Override
	public BinaryNodeInterface<T> getRightChild() 
	{
		return rightChild;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> newLeftChild) 
	{
		leftChild = (BinaryNode<T>) newLeftChild;
	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> newRightChild) 
	{
		rightChild = (BinaryNode<T>) newRightChild;
	}

	@Override
	public boolean hasLeftChild() 
	{
		return leftChild != null;
	}

	@Override
	public boolean hasRightChild() 
	{
		return rightChild != null;
	}

	@Override
	public boolean isLeaf() 
	{
		return (leftChild == null) && (rightChild == null);
	}

	@Override
	public int getNumberOfNodes() 
	{
		int leftNumberOfNodes = 0;
		int rightNumberOfNodes = 0;
		
		if(leftChild != null)
			leftNumberOfNodes = leftChild.getNumberOfNodes();
		
		if(rightChild != null)
			rightNumberOfNodes = rightChild.getNumberOfNodes();
		
		return leftNumberOfNodes + rightNumberOfNodes + 1;
	}

	@Override
	public int getHieght() 
	{
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode<T> node)
	{
		int height = 0;
		
		if(node != null)
			height = 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
		
		return height;
	}

	@Override
	public BinaryNode<T> copy() 
	{
	    BinaryNode<T> newRoot = new BinaryNode<>(data);
	    
	    if(leftChild != null)
		newRoot.setLeftChild(leftChild.copy());
	    
	    if(rightChild != null)
		newRoot.setRightChild(rightChild.copy());
	    
	    return newRoot;
	}

}
