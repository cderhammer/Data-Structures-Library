/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of AMGraph class methods.
 * @author cderh
 */
public class AMGraphTest {
    
    /**
     * Test of isEmpty method, of class AMGraph.
     */
    @Test
    public void testIsEmpty(){
        AMGraph<String> instance = new AMGraph<>();
        instance.addVertex("Conor");
        assertEquals(instance.size(), 1);
        instance.removeVertex("Conor");
        assertTrue(instance.isEmpty());
    }
    /**
     * Test of size method, of class AMGraph.
     */
    @Test
    public void testSize(){
        AMGraph<String> instance = new AMGraph<>();
        assertEquals(0, instance.size());
        instance.addVertex("Conor");
        
        assertEquals(1, instance.size());
        
    }
    /**
     * Test of addVertex method, of class AMGraph
     */
    @Test
    public void testAddVertex(){
        AMGraph<String> instance = new AMGraph<>(2);
        assertEquals(instance.size(), 0);
        
        instance.addVertex("Conor");
        instance.addVertex("bob");
        
        assertEquals(instance.size(), 2);
        
        String[] vertices = new String[2];
        
        vertices[0] = "Conor";
        vertices[1] = "bob";
        
        assertArrayEquals(vertices, instance.getVertices());
    }
    /**
     * Test of removeVertex method, of class AMGraph
     */
    @Test
    public void testRemoveVertex(){
        AMGraph<String> instance = new AMGraph<>(6);
        assertEquals(instance.size(), 0);
        
        instance.addVertex("Conor");
        instance.addVertex("bob");
        
        assertEquals(instance.size(), 4);

        instance.removeVertex("Conor");
        
        assertEquals(instance.size(), 1);
        
        instance.removeVertex("bob");
        
        assertEquals(instance.size(), 0);
        assertTrue(instance.isEmpty());
}
    /**
     * Test for addEdge method, of class AMGraph
     */
    @Test
    public void testAddEdge(){
        AMGraph<String> instance = new AMGraph<>(6);
        instance.addVertex("a");
        instance.addVertex("b");
        instance.addVertex("c");
        instance.addVertex("d");
        instance.addVertex("e");
        instance.addVertex("f");
        
        instance.addEdge("a", "b");
        instance.addEdge("a", "c");
        instance.addEdge("a", "d");
        instance.addEdge("b", "c");
        instance.addEdge("b", "e");
        instance.addEdge("d", "e");
        instance.addEdge("e", "f");
        
        assertEquals(instance.getEdges(), 7);
    }
    
    /**
     * Test for removeEdge method, of class AMGraph
     */
    @Test
    public void testRemoveEdge(){
        AMGraph<String> instance = new AMGraph<>(6);
        instance.addVertex("a");
        instance.addVertex("b");
        instance.addVertex("c");
        instance.addVertex("d");
        instance.addVertex("e");
        instance.addVertex("f");
        
        instance.addEdge("a", "b");
        instance.addEdge("a", "c");
        instance.addEdge("a", "d");
        instance.addEdge("b", "c");
        instance.addEdge("b", "e");
        instance.addEdge("d", "e");
        instance.addEdge("e", "f");
        
        assertEquals(instance.getEdges(), 7);
        
        String[] vertices = new String[2];
        vertices[0] = "a";
        vertices[1] = "d";
        
        assertArrayEquals(vertices, instance.getEdges());
        
        instance.removeEdge("a", "d");
    }
}
