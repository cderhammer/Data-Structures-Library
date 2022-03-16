/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import ADTs.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * AMGraph.java A class that implements an unweighted, undirected graph The
 * implementation uses an Adjacency Matrix This is a simplified graph class that
 * does not use iterators The class includes a toString method to print out the
 * matrix The class also includes BFS and DFS methods that return ArrayLists
 *
 * @author clatulip, for ITSC 2214 Data Structures & Algorithms Class UNC
 * Charlotte, Spring 2019
 */
public class AMGraph<T> implements GraphADT<T> {

    private int numVertices;
    private final int DEFAULT_CAPACITY = 5;
    private boolean[][] matrix;
    private T[] vertices;

    /**
     * Default constructor
     */
    public AMGraph() {
        numVertices = 0;
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.matrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
    }

    /**
     * Constructor to facilitate unit testing
     */
    AMGraph(int capacity) {
        numVertices = 0;
        this.vertices = (T[]) (new Object[capacity]);
        this.matrix = new boolean[capacity][capacity];
    }

    /**
     * Adds the (generic) vertex to the graph
     *
     * @param vertex the vertex to be added
     */
    @Override
    public void addVertex(T vertex) {

        if (numVertices + 1 == DEFAULT_CAPACITY) {
            expandCapacity();
        } else if (numVertices < DEFAULT_CAPACITY) {
            numVertices++;
        }
        vertices[numVertices] = vertex;
        for (int i = 0; i < numVertices; i++) {
            matrix[numVertices][i] = false;
            matrix[i][numVertices] = false;
        }
        numVertices++;
        // TODO:
        // check if space, if not, expandCapacity (see method at bottomm)
        // add vertex to array
        // set all links in the matrix for this vertex to false 
        // Hint: you need to change booleans in both the column and row for vertex
        // increment

    }

    /**
     * Removes the specified vertex
     *
     * @param vertex the vertex to be removed
     */
    @Override
    public void removeVertex(T vertex) {
        int index = getIndex(vertex);
        System.out.println("index is: " + index);
        if (indexIsValid(index)) {
            // remove item from vertices by moving everything else up
            for (int i = index; i < numVertices - 1; i++) {
                vertices[i] = vertices[i + 1];
            }
            vertices[numVertices - 1] = null;

            // remove item from matrix, by moving columns left
            for (int i = index; i < numVertices - 1; i++) {
                for (int j = 0; j < numVertices; j++) {
                    matrix[j][i] = matrix[j][i + 1];
                }
            }
            // and rows up
            for (int i = 0; i < numVertices - 1; i++) {
                for (int j = index; j < numVertices - 1; j++) {
                    matrix[j][i] = matrix[j + 1][i];
                }
            }
            numVertices--;
        }
    }

    /**
     * Adds an edge between the two specified vertices
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void addEdge(T vertex1, T vertex2) {

        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);

        if (indexIsValid(index1) && indexIsValid(index2)) {
            matrix[index1][index2] = true;
            matrix[index2][index1] = true;

        }
    }

    /**
     * Removes the edge between the two specified vertices
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    @Override
    public void removeEdge(T vertex1, T vertex2) {
        int index1 = getIndex(vertex1);
        int index2 = getIndex(vertex2);

        if (indexIsValid(index1) && indexIsValid(index2)) {
            matrix[index1][index2] = false;
            matrix[index2][index1] = false;
        }
    }

    /**
     * Returns an ArrayList of T vertices arrived at through depth-first
     * traversal starting at specified vertex
     *
     * @param startVertex
     * @return array of vertices from depth-first traversal
     */
    @Override
    public ArrayList<T> depthFirstTraversal(T startVertex) {
        throw new UnsupportedOperationException("Not supported yet.");
        // IGNORE this - we will not implement this
    }

    /**
     * Returns an ArrayList of T vertices arrived at through breadth-first
     * traversal starting at specified vertex
     *
     * @param startVertex
     * @return array of vertices from breadth-first traversal
     */
    @Override
    public ArrayList<T> breadthFirstTraversal(T startVertex) {
        Integer x;
        ArrayList<T> resultsList = new ArrayList<T>();
        Queue<Integer> traversalQueue = new LinkedList<Integer>();
        boolean[] visited = new boolean[numVertices];
        // get index of starting vertice
        int startIndex = getIndex(startVertex);
        if (!indexIsValid(startIndex)) {
            return null;
        }

        // initialize visited array
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }
        // add first vertex to queue and mark it as visited
        traversalQueue.add(startIndex);
        visited[startIndex] = true;
        // keep pulling items off the queue, and
        // checking through all their adjacencies and
        // enqueue them if they haven't been visited
        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.poll();
            resultsList.add(vertices[x.intValue()]);
            for (int i = 0; i < numVertices; i++) {
                if (matrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.add(i);
                    visited[i] = true;
                }
            }
        }
        return resultsList;
    }

    /**
     * Returns true if this graph is connected, false otherwise
     *
     * @return true if this graph is connected
     */
    @Override
    public boolean isConnected() {
        // To be completed as a Programming Project
        for (int i = 0; i < numVertices; i++) {
            boolean found = false;
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j]) {
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;

        //TODO
        // for every vertex, run a breadth first search
        // if every one of them returns a results list that contains
        // all the other vertices (size of list is the same as numVertices)
        // then the graph is connected
    }

    @Override
    public boolean isEmpty() {
        if (numVertices == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return numVertices;
    }

    @Override
    public String toString() {
        String m = "\t\t\t";
        for (int i = 0; i < numVertices; i++) {
            m = m.concat(vertices[i].toString() + "\t");
        }
        m = m.concat("\n");
        for (int i = 0; i < numVertices; i++) {

            m = m.concat("\t " + vertices[i].toString() + "\t");
            for (int j = 0; j < numVertices; j++) {
                m = m.concat("\t" + matrix[i][j]);
            }
            m = m.concat("\n");
        }

        return "AMGraph{" + "numVertices=" + numVertices + ", matrix: \n" + m + "}";
    }

    private void expandCapacity() {
        T[] largerVertices = (T[]) (new Object[vertices.length * 2]);
        boolean[][] largerMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerMatrix[i][j] = matrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }
        vertices = largerVertices;
        matrix = largerMatrix;
    }

    private int getIndex(T vertex1) {
        // returns the index for the given vertex if found, otherwise returns -1
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertex1)) {
                return i;
            }
        }

        return -1;
    }

    private boolean indexIsValid(int index1) {
        if ((index1 == -1) || (index1 >= numVertices)) {
            return false;
        }
        return true;
    }

    /**
     * Creates and returns a deep copy of the matrix field. The accessor is
     * immutable.
     *
     * @return a deep copy of the matrix representing all edges
     */
    boolean[][] getEdges() {
        boolean[][] edges = new boolean[numVertices][];
        for (int i = 0; i < numVertices; i++) {
            edges[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return edges;
    }

    /**
     * Creates and returns a deep copy of the vertices field. The accessor is
     * immutable.
     *
     * @return a deep copy of the array representing all vertices
     */
    T[] getVertices() {
        return Arrays.copyOf(vertices, vertices.length);
    }

}
