/*
 * 
 * Name: Xinyuan Zhang
 * Class: CS480
 * 
 * Assignment 3
 * Due: 2019/11/12
 * Problem Number: /
 * 
 * Description: 
 *  File given for Point3D object. 
 *  1. add method normalize, which returns a normalized Point3D object
 *  
 *  2. add method distance, which calculates the distance between 2 Point3D objects
 *  
 *  3. add method guassianPotential, which calculates the potential function between 2 creatures
 *  
 */

/**
 * Point3D.java - a three-dimensional point with double values
 * 
 * History:
 * 
 * 10 October 2019
 * 
 * - Add norm() method
 * 
 * - Add more constructors for convenience
 * 
 * (Zezhou Sun <szz314159@gmail.com>)
 * 
 * 18 February 2011
 * 
 * - made members private and added accessors
 * 
 * - added documentation
 * 
 * - added toString() method
 * 
 * (Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>)
 * 
 * 30 January 2008
 * 
 * - created
 * 
 * (Tai-Peng Tian <tiantp@gmail.com>)
 */

/**
 * A three-dimensional point with double values.
 * 
 * @author Tai-Peng Tian <tiantp@gmail.com>
 * @author Jeffrey Finkelstein <jeffrey.finkelstein@gmail.com>
 * @since Spring 2008
 */
public class Point3D {
	/** The origin, (0, 0, 0). */
	public static final Point3D ORIGIN = new Point3D(0, 0, 0);
	/** The x component of this point. */
	private final double x;
	/** The y component of this point. */
	private final double y;
	/** The z component of this point. */
	private final double z;

	/**
	 * Instantiates this point with the three specified components.
	 * 
	 * @param x The x component of this point.
	 * @param y The y component of this point.
	 * @param z The z component of this point.
	 */
	public Point3D(final double x, final double y, final double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point3D(final float x, final float y, final float z) {
		this.x = (double)x;
		this.y = (double)y;
		this.z = (double)z;
	}

	public Point3D(final Point3D p) {
		this.x = p.x();
		this.y = p.y();
		this.z = p.z();
	}

	/**
	 * Returns the String representation of this object.
	 * 
	 * @return The String representation of this object.
	 */
	@Override
	public String toString() {
		return "Point[" + this.x + ", " + this.y + ", " + this.z + "]";
	}

	/**
	 * Gets the x component of this point.
	 * 
	 * @return The x component of this point.
	 */
	public double x() {
		return this.x;
	}

	/**
	 * Gets the y component of this point.
	 * 
	 * @return The y component of this point.
	 */
	public double y() {
		return this.y;
	}

	/**
	 * Gets the z component of this point.
	 * 
	 * @return The z component of this point.
	 */
	public double z() {
		return this.z;
	}

	public double norm() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public double dotProduct(Point3D b) {
		return this.x*b.x()+this.y*b.y()+this.z*b.z();
	}
	
	public Point3D crossProduct(Point3D b) {
		return new Point3D(this.y*b.z()-this.z*b.y(), 
						   this.z*b.x()-this.x*b.z(), 
						   this.x*b.y()-this.y*b.x());
	}
	
	// normalize a Point3D object
	public Point3D normalize() {
		return new Point3D(this.x/this.norm(), this.y/this.norm(), this.z/this.norm());
	}
	
	// calculate distance between two Point3D objects
	public double distance(Point3D that) {
		return Math.sqrt(Math.pow(this.x-that.x,2)+Math.pow(this.y-that.y,2)+Math.pow(this.z-that.z,2));
	}
	
	// calculate Guassian potential function between two Point3D objects
	public Point3D guassianPotential(Point3D q, float scale) {
		double x = (scale*(q.x-this.x)*Math.pow(Math.E, -Math.pow((this.x-q.x),2)-Math.pow((this.y-q.y),2)-Math.pow((this.z-q.z),2)));
		double y = (scale*(q.y-this.y)*Math.pow(Math.E, -Math.pow((this.x-q.x),2)-Math.pow((this.y-q.y),2)-Math.pow((this.z-q.z),2)));
		double z = (scale*(q.z-this.z)*Math.pow(Math.E, -Math.pow((this.x-q.x),2)-Math.pow((this.y-q.y),2)-Math.pow((this.z-q.z),2)));
		return new Point3D(x,y,z);
	}

}
