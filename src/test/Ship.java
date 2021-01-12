package test;

import java.util.Hashtable;
import java.util.function.Function;

public class Ship {
    private final int[] containers;

    public Ship(int containerCount, Function<Integer, Integer> fillContainer) {
        containers = new int[containerCount];

        for (int i = 0; i < containerCount; i++) {
            this.containers[i] = fillContainer.apply(i);
        }
    }

    public int peekContainer(int containerIndex) {
        return this.containers[containerIndex];
    }

    public static void main(String[] args) {
        Ship ship = new Ship(10, containerIndex -> containerIndex);

        for (int i = 0; i < 10; i++) {
            System.out.println("Container: " + i + ", cargo: " + ship.peekContainer(i));
        }
    }
}