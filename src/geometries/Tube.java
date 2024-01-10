package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * Class Tube is the basic class representing a tube in Euclidean geometry
 */
public class Tube extends RadialGeometry {
    /**
     * The radius of the tube
     */
    protected final Ray axis;

    /**
     * @param radius the radius of the tube
     * @param axis the axis of the tube
     */
    public Tube(double radius, Ray axis) {
        super(radius);
        this.axis = axis;
    }
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
    /**
     * @param p the point at which to calculate the normal vector
     * @return the normal vector of the tube at the point
     */
    @Override
    public Vector getNormal(Point p) {
        double t = axis.getT(p);
        Point o =  axis.getPoint(t);
        return o.subtract(p).normalize();
    }

}
