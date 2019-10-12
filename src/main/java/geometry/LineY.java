package geometry;

import java.util.Objects;

public class LineY {

    public int y1;
    public int y2;


    public LineY(int y1, int y2) {
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineY lineY = (LineY) o;
        return y1 == lineY.y1 &&
                y2 == lineY.y2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y1, y2);
    }
}
