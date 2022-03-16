package ADTs;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.NonComparableElementException;


/**
 * An interface for a Binary Tree
 * Specific binary tree implementations will implement this interface
 * For use in ITCS 2214 Data Structures & Algorithms
 * UNC Charlotte, 2016
 * @author clatulip
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT {
    
    /**
     * Adds the specified element to the proper location in this tree
     * @param element the element to be added to this tree
     */
    public void addElement(T element) throws NonComparableElementException;
    
    /**
     * Removes and returns the specified element from this tree
     * @param targetElement the element to be removed from the tree
     * @return  the element to be removed from the tree
     */
    public T removeElement(T targetElement) throws NonComparableElementException, ElementNotFoundException;
    
    /**
     * Removes all occurrences of the specified element from this tree
     * @param targetElement element to be removed from the tree
     */
    public void removeAllOccurrences(T targetElement) throws NonComparableElementException, ElementNotFoundException;
    
    /**
     * Removes and returns the smallest element from the tree
     * @return the smallest element from the tree
     */
    public T removeMin() throws EmptyCollectionException;
    
    /**
     * Removes and returns the largest element from the tree
     * @return the largest element from the tree
     */
    public T removeMax() throws EmptyCollectionException;
    
    /**
     * Returns (without removing) the smallest element from the tree
     * @return the smallest element from the tree
     */
    public T findMin() throws EmptyCollectionException;
    
     /**
     * Returns (without removing) the largest element from the tree
     * @return the largest element from the tree
     */
    public T findMax() throws EmptyCollectionException;
    
}
