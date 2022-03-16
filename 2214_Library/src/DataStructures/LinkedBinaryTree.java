/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.BinaryTreeADT;
import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface, 
 * but no iterators
 * @author Lewis & Chase (modified by clatulip)
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected BTNode<T> root;
    protected int modCount;

    /* default constructor */
    public LinkedBinaryTree() {
        root = null;
        modCount = 0;
    }

    /**
     * Constructor that takes an element
     * @param element 
     */
    public LinkedBinaryTree(T element) {
        root = new BTNode<T>(element);
        modCount = 1;
        
    }
    
    /**
     * Constructor that takes an element and left and right trees to be the root
     * @param element the element to be stored at the root
     * @param left the left sub-tree to attach to the root
     * @param right the right sub-tree to attach to the root
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        root = new BTNode<T>(element);
        root.setLeftChild(left.root);
        root.setRightChild(right.root);
        modCount++;
    }
    
    /**
     * Returns the element at the root of this tree
     * @return T the (generic) element at the root
     * @throws EmptyCollectionException 
     */
    @Override
    public T getRootElement() throws EmptyCollectionException {
        return (T)(root.getElement());
    }

    /**
     * Determine whether a given element is present in the tree
     * @param targetElement the element to search for
     * @return true if the element is found, false otherwise
     */
    @Override
    public boolean contains(T targetElement) {
        // start searching at the root, by calling private recursive search
        BTNode<T> current = findNode(targetElement, root);
        
        // if, searching from root, we didn't find it, throw exception.
        if (current == null)
            return false;
        else 
            return true;
        
    }

    /**
     * Find looks to see if a target element is in the tree, if it is,
     * it returns a reference to that element. If element is not found,
     * an exception is thrown. It is expected that a call to 'contains' has 
     * first verified the presence of the element.
     * @param targetElement, element to search for
     * @return Element reference to the element
     * @throws ElementNotFoundException 
     */
    @Override
    public T find(T targetElement) throws ElementNotFoundException {
        // start searching at the root, by calling private recursive search
        BTNode<T> current = findNode(targetElement, root);
        
        // if, searching from root, we didn't find it, throw exception.
        if (current == null)
            throw new ElementNotFoundException("LinkedBinaryTree");
        
        // otherwise, return the element found
        return current.getElement();
    }

    // private method that recursively searches through sub-trees searching for element
    private BTNode<T> findNode(T targetElement, BTNode<T> next) {
        if (next == null)
            return null;
        if (next.getElement().equals(targetElement)) 
            return next;
        BTNode<T> temp = findNode(targetElement, next.getLeftChild());
        
        if (temp == null)
            temp = findNode(targetElement, next.getRightChild());
        
        return temp;
    }
    
    /**
     * Gives the depth in the tree of the specified node,
     * if the element is not found, an exception is thrown
     * It is expected that 'contains' has been called first
     * to verify the presence of the node before calling nodeDepth
     * @param targetElement the element we are looking for
     * @return the depth if node is found
     * @throws ElementNotFoundException 
     */
    public int nodeDepth(T targetElement) throws ElementNotFoundException {
        // start searching at the root, by calling private recursive search
        int depthCount = findNodeDepth(targetElement, root, 0);
        
        // if, searching from root, we didn't find it, throw exception.
        if (depthCount == -1)
            throw new ElementNotFoundException("LinkedBinaryTree");
        
        // otherwise, return the element found
        return depthCount;
        
    }
    
    /**
     * private recursive helper function for calculating node depth
     * @param targetElement element we are looking for
     * @param next sub-tree to search
     * @param depth counter to keep track of levels
     * @return 
     */
    private int findNodeDepth(T targetElement, BTNode<T> next, int depth) {
        int temp = depth;
        if (next == null)
            return -1;
        if (next.getElement().equals(targetElement)) 
            return depth;
        temp  = findNodeDepth(targetElement, next.getLeftChild(), depth + 1);
        
        if (temp == -1)
            temp = findNodeDepth(targetElement, next.getRightChild(), depth + 1);
        
        return temp;
    }

    /**
     * Returns whether or not the tree is empty
     * @return boolean true if the tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (modCount == 0) return true;
        return false;
    }

    /**
     * Returns the number of nodes in the tree
     * @return int the number of nodes in the tree
     */
    @Override
    public int size() {
        return modCount;
    }

    
    
 

   
    
}

