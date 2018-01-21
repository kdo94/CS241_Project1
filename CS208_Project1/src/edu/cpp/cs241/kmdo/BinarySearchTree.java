	package edu.cpp.cs241.kmdo;

public class BinarySearchTree<T extends Comparable<? super T>>
	extends BinaryTree<T> implements SearchTreeInterface<T>
{

    public BinarySearchTree()
    {
	this(null);
    }
    
    public BinarySearchTree(T rootEntry)
    {
	setRootNode(new BinaryNode<T>(rootEntry));
    }
    
    public void setTree(T rootData)
    {
	throw new UnsupportedOperationException();
    }
    
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
	throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean contains(T entry)
    {
	return getEntry(entry) != null;
    }

    @Override
    public T getEntry(T entry)
    {
	return findEntry(getRootNode(), entry);
    }
    
    private T findEntry(BinaryNodeInterface<T> rootNode, T entry)
    {
	T result = null;
	
	if(rootNode != null)
	{
	    T rootEntry = rootNode.getData();
	    
	    if(entry.equals(rootEntry))
		result = rootEntry;
	    else if(entry.compareTo(rootEntry) > 0)
		result = findEntry(rootNode.getLeftChild(), entry);
	    else
		result = findEntry(rootNode.getRightChild(), entry);
	}
	
	return result;
    }

    @Override
    public T addEntry(T newEntry)
    {
	T result = null;
	
	if(isEmpty())
	    setRootNode(new BinaryNode<T>(newEntry));
	else
	    result = addEntry(getRootNode(), newEntry);
	
	return result;
    }
    
    private T addEntry(BinaryNodeInterface<T> rootNode, T newEntry)
    {
	assert rootNode != null;
	T result = null;
	int comparision = newEntry.compareTo(rootNode.getData());
	
	if(comparision == 0)
	{
	    result = rootNode.getData();
	    rootNode.setData(newEntry);
	}
	else if(comparision < 0)
	{
	    if(rootNode.hasLeftChild())
		result = addEntry(rootNode.getLeftChild(), newEntry);
	    else
		rootNode.setLeftChild(new BinaryNode<T>(newEntry));
	}
	else
	{
	    assert comparision > 0;
	    if(rootNode.hasRightChild())
		result = addEntry(rootNode.getRightChild(), newEntry);
	    else
		rootNode.setRightChild(new BinaryNode<T>(newEntry));
	}
	
	return result;
    }

    @Override
    public T remove(T entry)
    {
	T oldEntry = null;
	BinaryNodeInterface<T> newRoot = removeEntry(getRootNode(), entry, oldEntry);
	setRootNode(newRoot);
	return oldEntry;
    }
    
    private BinaryNode<T> removeEntry(BinaryNode<T> rootNode, T entry, T oldEntry)
    {
	if(rootNode != null)
	{
	    T rootData = rootNode.getData();
	    int comparision = entry.compareTo(rootData);
	    if(comparision == 0)
	    {
		oldEntry = rootData;
		rootNode = removeFromRoot(rootNode);
	    }
	    else if(comparision < 0)
	    {
		BinaryNode<T> leftChild = (BinaryNode<T>) rootNode.getLeftChild();
		BinaryNode<T> subtreeRoot = removeEntry(leftChild, entry, oldEntry);
		rootNode.setLeftChild(subtreeRoot);
	    }
	    else
	    {
		BinaryNode<T> rightChild = (BinaryNode<T>) rootNode.getRightChild();
		rootNode.setRightChild(removeEntry(rightChild, entry, oldEntry));
	    }
	}
	
	return rootNode;
    }
    
    private BinaryNode<T> removeFromRoot(BinaryNode<T> rootNode)
    {
	if(rootNode.hasLeftChild() && rootNode.hasRightChild())
	{
	    BinaryNode<T> leftSubtreeRoot = (BinaryNode<T>) rootNode.getLeftChild();
	    BinaryNode<T> largestNode = findLargest(leftSubtreeRoot);
	    rootNode.setData(largestNode.getData());
	    rootNode.setLeftChild(removeLargest(leftSubtreeRoot));
	}
	else if(rootNode.hasRightChild())
	    rootNode = (BinaryNode<T>) rootNode.getRightChild();
	else
	    rootNode = (BinaryNode<T>) rootNode.getLeftChild();
	return rootNode;
    }
    
    private BinaryNode<T> findLargest(BinaryNode<T> rootNode)
    {
	if(rootNode.hasRightChild())
	    rootNode = findLargest((BinaryNode<T>)rootNode.getRightChild());
	return rootNode;
    }
    
    private BinaryNode<T> removeLargest(BinaryNode<T> rootNode)
    {
	if(rootNode.hasRightChild())
	{
	    BinaryNode<T> rightChild = (BinaryNode<T>) rootNode.getRightChild();
	    rightChild = removeLargest((BinaryNode<T>) rootNode.getRightChild());
	    rootNode.setRightChild(rightChild);
	}
	else
	    rootNode = (BinaryNode<T>) rootNode.getLeftChild();
	
	return rootNode;
    }

}
