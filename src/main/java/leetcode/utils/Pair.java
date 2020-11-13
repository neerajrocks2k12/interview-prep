package leetcode.utils;

/**
 * This is for the scenarios when we need to use Pair class and is not available as part of jdk
 */
public class Pair<U, V> {
    private final U first;
    private final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int hashCode() {
        return 31 * this.first.hashCode() + this.second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        Pair<?, ?> thatPair = (Pair<?, ?>) obj;
        if(!thatPair.first.equals(this.first))
            return false;
        return thatPair.second.equals(this.second);
    }
}
