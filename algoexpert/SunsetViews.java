package algoexpert;

import com.sun.jdi.ArrayReference;
import com.sun.jdi.IntegerType;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class SunsetViews {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        // Write your code here.
        boolean isWest = !direction.equals("EAST");

        return getViews(buildings, isWest);
    }

    private ArrayList<Integer> getViews(int[] buildings, boolean isWest) {
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        if (isWest) {
            for (int i = 0; i < buildings.length; i++) {
                if (buildings[i] > max) {
                    deque.push(i);
                    max = buildings[i];
                }
            }
        } else {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if (buildings[i] > max) {
                    deque.push(i);
                    max = buildings[i];
                }
            }
        }
        while (!deque.isEmpty()) {
            if (isWest) {
                result.add(deque.poll());
            } else {
                result.add(deque.pop());
            }
        }
        return result;
    }
}
