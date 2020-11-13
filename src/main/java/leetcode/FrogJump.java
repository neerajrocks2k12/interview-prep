package leetcode;

public class FrogJump {
    public boolean canCross(int[] stones) {
        if (stones.length < 2 || stones[1] != 1)
            return false;
        return true;
    }
}