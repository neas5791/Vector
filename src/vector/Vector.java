package vector;


public class Vector {

	public Vector(){
		
	}
	
	/**
	 * Overloaded constructor 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Static method to calculate the addition of two vectors, 
	 * sometimes called the parallelogram law or triangle law.
	 * @param v1	the first vector
	 * @param v2	the second vector
	 * @return the vector resultant
	 */
	public static Vector add(Vector v1, Vector v2){
		return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
	}
	
	/**
	 * Calculate the difference between to vectors, 
	 * the resultant vector closes the triangle
	 * @param v1	the first vector
	 * @param v2	the second vector
	 * @return the resultant vector
	 */
	public static Vector minus(Vector v1, Vector v2){
		return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
	}
	
	/**
	 * 
	 * @param scalar the value to alter the vector by
	 * @return the scaled vector
	 */
	public static Vector scalarMultiplication(double scalar, Vector v){
		return new Vector(scalar * v.x, scalar * v.y, scalar * v.z);
	}
	
	/**
	 * Sometimes the dot product is called the scalar product.  
	 * The dot product is also an example of an inner product and 
	 * so on occasion you may hear it called an inner product.
	 * a.b = <a1,a2,a3>.<b1,b2,b3> = a1*b1 + a2*b2 + a3*b3
	 * @param v a vector
	 * @return the dot product of two vectors
	 */	
	public static double dotProduct(Vector v1, Vector v2){
		return ((v1.x * v2.x) + (v1.y * v2.y) + (v1.z * v2.z));
	}
	
	/**
	 * @param v the other vector which  
	 * @return
	 */
	public double includedAngle(Vector v1, Vector v2){
		return includedAngleRadian(v1,v2) * (180/Math.PI);
	}
	
	private double includedAngleRadian(Vector v1, Vector v2){
		return Math.acos(Vector.dotProduct(v1, v2)/(v1.magnitude()*v2.magnitude()));
	}
	
	/**
	 * @return The magnitude, or length, of the vector
	 * 
	 * Often denoted by ||ü||
	 */
	public double magnitude(){
		return (Math.sqrt((this.x*this.x) + (this.y * this.y) + (this.z * this.z)));
	}
	
	/**
	 * Any vector with magnitude of 1, ||ü|| = 1 , is called a unit vector.
	 * @return the unit vector
	 */
	public Vector unitVector(){
		return new Vector(this.x/this.magnitude(),this.y/this.magnitude(), this.z/this.magnitude());
	}
	
	/**
	 * a x b = < a2*b3-a3*b1, a3*b1-a1*b3, a1*b2-a2*b1 >
	 * 
	 * where 
	 *   a = < a1, a2, a3 >
	 *   b = < b1, b2, b3 >
	 * 
	 * Solved by method of co-factors.
	 * 
	 * @param v1
	 * @param v2
	 * @return < a > x < b > 
	 * if <a> x <b>  = 0 then vectors are parallel.
	 * it <a> x <b> != 0 then <a> x <b> is orthogonal to both <a> and <b>
	 */
	public static Vector crossProduct(Vector v1, Vector v2){
//		
//		<   x  ,   y  ,   z  >
//		< v1.x , v1.y , v1.z >
//		< v2.x , v2.y , v2.z >
//		
//		x =  v1.y * v2.z - v1.z * v2.y
//		y = -v1.x * v2.z + v1.z * v2.x
//		z =  v1.x * v2.y - v1.y * v2.x
//		
		return new Vector(v1.y*v2.z-v1.z*v2.y, -v1.x * v2.z + v1.z * v2.x, v1.x * v2.y - v1.y * v2.x);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return String.format("< %5.2f,  %5.2f, %5.2f >",x, y, z);
	}
	
	public double getX(){return x;}
	public double getY(){return y;}
	public double getZ(){return z;}
	
	public void setX(double x){ this.x = x; }
	public void setY(double y){ this.y = y; }
	public void setZ(double z){ this.z = z; }
	
	private double x = 0;
	private double y = 0;
	private double z = 0;
}
