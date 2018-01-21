package edu.cpp.cs241.kmdo;

public interface BinaryTreeInterface<T> extends TreeInterface<T>
{
	public void setTree(T rootData);
	
	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree);
}
