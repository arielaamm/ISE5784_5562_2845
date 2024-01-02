package primitives;

public class Ray {
    private Point head;
    private Vector direction;

    public Ray(Point head,Vector direction) {
        this.head = head;
        this.direction = direction;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Ray other)
                && this.head.equals(other.head)
                && this.direction.equals(other.direction);
    }

    @Override
    public String toString() {
        return "head=" + head.toString() +
                ", direction=" + direction.toString();

    }
}
