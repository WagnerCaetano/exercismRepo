import java.util.Objects;

public class Queen {
    private int x;
    private int y;

    public Queen(int x , int y)
    {
        if(x < 0)
            throw new IllegalArgumentException("Queen position must have positive row.");
        if(y < 0)
            throw new IllegalArgumentException("Queen position must have positive column.");
        if(x >=8)
            throw new IllegalArgumentException("Queen position must have row <= 7.");
        if(y >=8)
            throw new IllegalArgumentException("Queen position must have column <= 7.");
        this.x = x;
        this.y = y;
    }

    public int getRow() {
        return this.x;
    }

    public int getColumn() {
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return x == queen.x &&
                y == queen.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Queen's position is ("+this.x+","+this.y+")";
    }
}
