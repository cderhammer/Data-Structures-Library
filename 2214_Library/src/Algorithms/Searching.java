package Algorithms;

/**
 * SortingComp.java
 *
 * @author Lewis/Chase, modified by Perez Quinones and Latulipe
 */
public class Searching<T> {

    /**
     * ******************************************************************
     * Searches the specified array of objects using a linear search algorithm.
     *
     * @param data
   *******************************************************************
     */
    public static <T extends Comparable> boolean linearSearch(T[] data, T target) {
        int index = 0;
        int max = data.length;
        boolean found = false;

        while (!found && index < max) {
            if (data[index] == null) {
                break;
            }
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            index++;
        }

        return found;
    }

    /**
     * ******************************************************************
     * Searches the specified array of objects using a linear search algorithm.
     *
     * @param <T>
     * @param data
   *******************************************************************
     */
    public static <T extends Comparable> T linearSearch2(T[] data, T target) {
        T element = null;
        int index = 0;
        int max = data.length;
        boolean found = false;

        while (!found && index < max) {
            if (data[index] == null) {
                break;
            }
            if (data[index].compareTo(target) == 0) {
                element = data[index];
                found = true;
            }
            index++;
        }

        return element;
    }

}
