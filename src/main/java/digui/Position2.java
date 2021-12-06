package digui;

import java.util.Objects;

/**
 * @author masun
 * @date 2021/12/3
 */
public class Position2 {

    private int x;
    private int y;

    public Position2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position2 position2 = (Position2) o;
        return x == position2.x && y == position2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
