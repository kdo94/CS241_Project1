package edu.cpp.cs241.kmdo;

public interface SearchTreeInterface<T extends Comparable<? super T>> extends TreeInterface<T>
{
    public boolean contains(T entry);
    
    public T getEntry(T entry);
    
    public T addEntry(T newEntry);
    
    public T remove(T entry);
}
