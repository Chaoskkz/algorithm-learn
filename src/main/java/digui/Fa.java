package digui;

import java.util.HashMap;
import java.util.Map;

/**
 * @author masun
 * @date 2021/12/3
 */
public class Fa {

    private static final Map<Position2, Long> CACHE = new HashMap<>(16);

    static {
        Position2 p1 = new Position2(1, 0);
        Position2 p2 = new Position2(0, 1);
        CACHE.put(p1, 1L);
        CACHE.put(p2, 1L);
    }


    public static Long findWay(int x, int y) {
        Position2 position2 = new Position2(x, y);
        if (CACHE.containsKey(position2)) {
            return CACHE.get(position2);
        }
        if (x < 0 || y < 0) {
            return 0L;
        }
        long l = findWay(x - 1, y) + findWay(x, y - 1);
        CACHE.put(position2, l);
        return l;
    }

}
