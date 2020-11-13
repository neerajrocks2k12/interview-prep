package leetcode;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Arrays;

public class FrogJump {
    /**
     * If you are using java 8 which has javafx package you can use the Pair class from javafx.util Package
     * Otherwise continue to use below
     * @param <U>
     * @param <V>
     */
    class Pair <U, V> {
        private final U first;
        private final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            if(obj == null || getClass() != obj.getClass())
                return false;
            Pair<?, ?> thatPair = (Pair<?, ?>) obj;
            if(!this.first.equals(thatPair.first))
                return false;
            return this.second.equals(thatPair.second);
        }

        @Override
        public int hashCode() {
            return 31 * this.first.hashCode() + this.second.hashCode();
        }
    }
    private int targetPosition;
    private Set<Integer> positions = new HashSet<>();
    Map<Pair<Integer, Integer>, Boolean> t = new HashMap<>();

    private boolean solve(int currentPos, int lastJump) {
        if(currentPos == targetPosition)
            return true;
        if(currentPos > targetPosition ||
                currentPos < 0 ||
                !positions.contains(currentPos))
            return false;
        Pair<Integer, Integer> key = new Pair<>(currentPos, lastJump);
        if(t.containsKey(key))
            return t.get(key);
        boolean result = false;
        if((currentPos + lastJump - 1) != currentPos) {
            Pair<Integer, Integer> key1 = new Pair<>(currentPos + lastJump - 1, lastJump - 1);
            if(!t.containsKey(key1))
                t.put(key1, solve(currentPos + lastJump - 1, lastJump - 1));
            result |= t.get(key1);
            if(result) {
                t.put(key, result);
                return result;
            }
        }

        if((currentPos + lastJump) != currentPos) {
            Pair<Integer, Integer> key2 = new Pair<>(currentPos + lastJump, lastJump);
            if(!t.containsKey(key2))
                t.put(key2, solve(currentPos + lastJump, lastJump));
            result |= t.get(key2);
            if(result) {
                t.put(key, result);
                return result;
            }
        }

        if((currentPos + lastJump + 1) != currentPos) {
            Pair<Integer, Integer> key3 = new Pair<>(currentPos + lastJump + 1, lastJump + 1);
            if(!t.containsKey(key3))
                t.put(key3, solve(currentPos + lastJump + 1, lastJump + 1));
            result |= t.get(key3);
            if(result) {
                t.put(key, result);
                return result;
            }
        }
        t.put(key, result);
        return result;
    }


    public boolean canCross(int[] stones) {
        if(stones.length < 2 || stones[1] != 1)
            return false;
        targetPosition = stones[stones.length - 1];
        Arrays.stream(stones).forEach(a -> positions.add(a));
        return solve(1, 1);
    }
}