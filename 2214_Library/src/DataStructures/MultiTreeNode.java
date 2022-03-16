
package DataStructures;

import java.util.ArrayList;

/**
 * A MultiTreeNode is a tree node that can have any number of children
 * @author clatulip
 */
public class MultiTreeNode<T> {
    
    /**
     * Stores the element that is of type <generic>
     */
    private T element;
    /**
     * Stores links to other MultiTreeNodes in an indexed list
     */
    private ArrayList<MultiTreeNode<T>> children;

   
    /**
     * Default constructor creates an empty node
     */
    public MultiTreeNode() {
        children = new ArrayList<>();
        element = null;
    }

    /** 
     * Creates a node containing element
     * @param elem element to be stored
     */
    public MultiTreeNode(T elem) {
        children = new ArrayList<>();
        element = elem;
    }
    
    /**
     * Add a child node to this node, by adding it to the list
     * @param child 
     */
    public void addChild(MultiTreeNode<T> child) {
        children.add(child);
    }
    
    /**
     * Remove a child node from this node, by removing it from the list
     * @param child 
     */
    public void removeChild(MultiTreeNode<T> child) {
        children.remove(child);
    }
    
    /**
     * Find out how many child nodes this node has
     * @return size (int) of the arrayList of MultiTreeNodes
     */
    public int getNumChildren() {
        return children.size();
    }
    
    /**
     * Get the child node at index specified. Note that if the index isn't valid
     * then null is returned. No exception is thrown.
     * @param index int 
     * @return MultiTreeNode that was at specified index
     */
    public MultiTreeNode<T> getChild(int index) {
        if (index >= children.size()) return null; 
        return children.get(index);
    }
    
    /**
     * Returns an ArrayList of all the child nodes
     * @return arrayList that contains all the children of this node
     */
    public ArrayList<MultiTreeNode<T>> getChildren() {
        return children;
    }
    
    /**
     * Returns the element stored in this node
     * @return element stored in the node
     */
    public T getElement() {
        return element;
    }
    
    /**
     * Sets the element in this node to the passed in element
     * @param elem of generic type
     */
    public void setElement(T elem) {
        element = elem;
    }

    /**
     * Creates a string out of the element, the number of children, and each 
     * child
     * @return a string representing this node and it's offspring
     */
    @Override
    public String toString() {
        /*
        String temp = "MultiTreeNode{" + "element=" + element + 
                      ", num_children=" + children.size() + ", children=";
        for (int i = 0; i < children.size(); i++) {
            temp = temp.concat("\t child " + i + ": " + 
                   children.get(i).toString() + ", ");
        }
        temp = temp.concat("}");
        return temp;
        */
        return element.toString();
    }

   


    
    
    
}
