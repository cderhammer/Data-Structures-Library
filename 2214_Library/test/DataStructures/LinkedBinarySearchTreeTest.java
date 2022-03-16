/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.ElementNotFoundException;
import Exceptions.EmptyCollectionException;
import Exceptions.NonComparableElementException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cderh
 */
public class LinkedBinarySearchTreeTest {

    public LinkedBinarySearchTreeTest() {
    }

    @Test
    public void testAddElement() throws NonComparableElementException {
        System.out.println("testAddElement");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        assertEquals(instance.size(), 3);
        assertFalse(instance.isEmpty());

    }

    @Test
    public void testRemoveElement() throws NonComparableElementException {
        System.out.println("testRemoveElement");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        try {
            instance.removeElement("a");
            assertEquals(instance.size(), 2);
            instance.removeElement("b");
            assertEquals(instance.size(), 1);
            instance.removeElement("c");
            assertEquals(instance.size(), 0);
        } catch (ElementNotFoundException enf) {
            System.out.println("no such element");
        }
        assertTrue(instance.isEmpty());

    }

    @Test
    public void testRemoveAllOccurences() throws NonComparableElementException {
        System.out.println("testRemoveAllOccurences");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        instance.addElement("a");
        instance.addElement("a");
        instance.addElement("a");
        instance.addElement("c");

        assertEquals(instance.size(), 4);
        assertFalse(instance.isEmpty());
        try {
            instance.removeAllOccurrences("a");
        } catch (ElementNotFoundException enf) {
            System.out.println("no such element");
        }

        assertEquals(instance.size(), 1);
    }

    @Test
    public void testRemoveMin() throws NonComparableElementException {
        System.out.println("testRemoveMin");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        try {
            instance.removeMin();
            assertEquals(instance.size(), 2);
            assertTrue(instance.contains("b"));
            assertTrue(instance.contains("c"));
            instance.removeMin();
            assertEquals(instance.size(), 1);
            assertTrue(instance.contains("c"));
            instance.removeMin();
            assertTrue(instance.isEmpty());
        } catch (EmptyCollectionException ece) {
            System.out.println("no such collection");
        }

    }

    @Test
    public void testFindMin() throws NonComparableElementException {
        System.out.println("testFindMin");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();

        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        try {
            instance.findMin();
            assertTrue("a", true);
            instance.removeMin();
            instance.findMin();
            assertTrue("b", true);
            instance.removeMin();
            instance.findMin();
            assertTrue("c", true);
        } catch (EmptyCollectionException ece) {
            System.out.println("no collection");
        }
        assertEquals(instance.size(), 1);
    }

    @Test
    public void testContains() throws NonComparableElementException {
        System.out.println("testContains");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();

        instance.addElement("Hello");
        instance.addElement("Hello");
        instance.addElement("Hello");
        instance.addElement("Goodbye");
        instance.addElement("How are you?");

        assertEquals(instance.size(), 5);

        instance.contains("Hello");
        instance.contains("Goodbye");
        instance.contains("How are you?");

        try {
            instance.removeElement("How are you?");
            assertEquals(instance.size(), 4);
            instance.contains("Hello");
            instance.contains("Goodbye");
            instance.removeAllOccurrences("Hello");

        } catch (ElementNotFoundException ece) {
            System.out.println("no such element");
        }
        assertEquals(instance.size(), 1);
        instance.contains("Goodbye");
    }

    @Test
    public void testFind() throws NonComparableElementException {
        System.out.println("testFind");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();

        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        assertEquals(instance.size(), 3);

        try {
            instance.find("c");
            assertTrue("c", true);
            instance.find("b");
            assertTrue("b", true);
            instance.find("a");
            assertTrue("a", true);

            instance.removeElement("c");
            instance.find("c");
            assertTrue("c", false);
        } catch (ElementNotFoundException enf) {

        }
    }

    @Test
    public void testNodeDepth() throws NonComparableElementException {
        System.out.println("testNodeDepth");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();

        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");
        instance.addElement("d");
        instance.addElement("e");
        instance.addElement("f");

        assertEquals(instance.size(), 6);
        try {
            instance.nodeDepth("c");
            assertEquals("c", 1, 1);
            instance.nodeDepth("e");
            assertEquals("e", 2, 2);

        } catch (ElementNotFoundException enf) {
            System.out.println("No such element");
        }
    }
    
    @Test
    public void testFindMax() throws NonComparableElementException {
        System.out.println("testFindMax");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();

        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        try {
            instance.findMax();
            assertTrue("c", true);
            instance.removeMax();
            instance.findMax();
            assertTrue("b", true);
            instance.removeMax();
            instance.findMax();
            assertTrue("a", true);
        } catch (EmptyCollectionException ece) {
            System.out.println("no collection");
        }
        assertEquals(instance.size(), 1);
    }
    @Test
    public void testRemoveMax() throws NonComparableElementException {
        System.out.println("testRemoveMax");
        LinkedBinarySearchTree<String> instance = new LinkedBinarySearchTree<String>();
        instance.addElement("a");
        instance.addElement("b");
        instance.addElement("c");

        try {
            instance.removeMax();
            assertEquals(instance.size(), 2);
            assertTrue(instance.contains("b"));
            assertTrue(instance.contains("c"));
            instance.removeMax();
            assertEquals(instance.size(), 1);
            assertTrue(instance.contains("c"));
            instance.removeMax();
            assertTrue(instance.isEmpty());
        } catch (EmptyCollectionException ece) {
            System.out.println("no such collection");
        }

    }
    }

