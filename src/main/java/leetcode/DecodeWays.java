package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    private Map<Integer, Integer> t = new HashMap<>();

    private int decodeWays(String s, int i) {
        if (i == s.length())
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        if (i == s.length() - 1)
            return 1;

        if (t.containsKey(i))
            return t.get(i);
        int ans = decodeWays(s, i + 1);
        if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
            ans += decodeWays(s, i + 2);
        t.put(i, ans);
        return t.get(i);
    }

    public int numDecodings(String s) {
        return decodeWays(s, 0);
    }
}
