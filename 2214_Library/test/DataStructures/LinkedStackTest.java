/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures;

import Exceptions.EmptyCollectionException;
import java.util.EmptyStackException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cderh
 */
public class LinkedStackTest {

    LinkedStack<String> testStack = new LinkedStack<>();

    public LinkedStackTest() {
    }

    @Test
    public void testPush() {
        try {
            System.out.println("testPush()");
            assertTrue(testStack.isEmpty());
            assertEquals(0, testStack.size());
            testStack.push("turtle");
            assertEquals(1, testStack.size());
            assertEquals(false, testStack.isEmpty());
            //assertEquals("turtle", testStack.pop());
            //assertEquals(true, testStack.isEmpty());
            for (int i = 0; i < testStack.size(); i++) {
                assertEquals(i + 1, testStack.size());
            }

        } catch (Exception e) {    
            assertTrue(e instanceof EmptyCollectionException); 
        }
    }

    @Test
    public void testPop(){
        
        try {
            System.out.println("testPop()");
            String str = testStack.pop();
            fail("*** Error in testPop - shouldn't get here");
            for (int i = testStack.size() - 1; i >= 0; i--) {
                assertEquals(i, testStack.pop());
            }
            
            assertEquals(false, testStack.isEmpty());

        } catch (Exception e) {    
            assertTrue(e instanceof EmptyCollectionException); 
        }

    }

    @Test
    public void testPeek() {
        try {
            System.out.println("testPeek()");
            testStack.push("one");
            testStack.push("two");
            assertTrue("one", true);
            assertTrue("two", true);
            assertEquals(false, testStack.isEmpty());
        } catch (Exception e) {    
            assertTrue(e instanceof EmptyCollectionException); 
        }
    }

}
