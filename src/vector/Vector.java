package vector;


public class Vector {
	private double x = 0;
	private double y = 0;
	private double z = 0;
	
	public Vector(){
		
	}
	
	public Vector (double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
//	/**
//	 * This is sometimes called the parallelogram law or triangle law.
//	 * @param v a vector to 
//	 * @return the vector resultant
//	 */
//	public Vector add(Vector v){
//		return Vector.add(this, v);
//	}

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
	
//	/**
//	 * Calculate the difference between to vectors, the resultant vector
//	 * closes the triangle
//	 * @param v a vector
//	 * @return the resultant vector
//	 */
//	public Vector minus(Vector v){
//		return Vector.minus(this, v);
//	}
	
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
	
//	/**
//	 * Sometimes the dot product is called the scalar product.  
//	 * The dot product is also an example of an inner product and 
//	 * so on occasion you may hear it called an inner product.
//	 * a.b = <a1,a2,a3>.<b1,b2,b3> = a1*b1 + a2*b2 + a3*b3
//	 * @param v a vector
//	 * @return the dot product of two vectors
//	 */
//	public double dotProduct(Vector v){
//		return Vector.dotProduct(this, v);
//	}
	
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

//	/**
//	 * Calculates the cross product between this and another Vector.
//	 * The result is a vector normal to the plane formed by the two vectors
//	 * @param v Vector 
//	 * @return
//	 */
//	public Vector crossProduct(Vector v){
//		return Vector.crossProduct(this, v);
//	}
	
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
	
	public double getX(){return x;}
	public double getY(){return y;}
	public double getZ(){return z;}
	
	public void setX(double x){ this.x = x; }
	public void setY(double y){ this.y = y; }
	public void setZ(double z){ this.z = z; }
	
	public String toString(){
		return String.format("< %5.2f,  %5.2f, %5.2f >",x, y, z);
	}
	
	public static void main(String[] args){
		
		Vector v1 = new Vector(1, 4, -7);
		Vector v2 = new Vector(2, -1, 4);
		Vector v3 = new Vector(0, -9, 18);

		
		double volume = Vector.dotProduct(v1, Vector.crossProduct(v2, v3));
		
		if (volume == 0)
			System.out.println("These points are on the same plane!");
		else
			System.out.println("We got volume!");
		
	}
}

//**********************************************************************************
//this all worked beaut 
//Vector v1 = new Vector(1,0,0);
//Vector v2 = new Vector(1,1,1);
//Vector v3 = new Vector(2,-1,3);
//
//Vector v4m = Vector.crossProduct(Vector.minus(v1, v2),Vector.minus(v1, v3));
//
//// PQ and PR are vectors on the plane formed by the three points v1, v2, v3
//System.out.println("PQ = " + Vector.minus(v1, v2));
//System.out.println("PR = " + Vector.minus(v1, v3));
//// v4m is the plane orthogonal to the plane formed by v1, v2, v3 
//System.out.println(v4m);
//*********************************************************************************









//Vector v1 = new Vector(-6,8,0);
//Vector v2 = new Vector(5,12,0);
//
//System.out.println(v1.dotProduct(v2));
//System.out.println(v1.angleDegree(v2) + " deg");
//
//System.out.print(v1 + " + " + v2 + " = ");
//System.out.println(v1.add(v2));
//
//
//System.out.print(v1 +" - " + v2 + " = ");
//System.out.println(v1.minus(v2));
//
//
//v1 = new Vector(2,1,-1);
//v2 = new Vector(-3,4,1);
//
//System.out.println(Vector.crossProduct(v1, v2));
//System.out.println(Vector.crossProduct(v2, v1));
//System.out.println(Vector.crossProduct(Vector.minus(v1, v2),Vector.minus(v1, v3)));
//System.out.println(Vector.crossProduct(Vector.minus(v1, v2),Vector.minus(v1, v3)).unitVector());
//System.out.println(Vector.dotProduct(Vector.crossProduct(Vector.minus(v1, v2),Vector.minus(v1, v3)).unitVector(), v1));
//System.out.println(Vector.dotProduct(Vector.crossProduct(Vector.minus(v1, v2),Vector.minus(v1, v3)).unitVector(), v2));
//System.out.println(Vector.dotProduct(Vector.crossProduct(Vector.minus(v1, v2),Vector.minus(v1, v3)).unitVector(), v3));
//System.out.println("PQ = " + Vector.add(v1, v2));
//System.out.println("PR = " + Vector.add(v1, v3));
//System.out.println(Vector.crossProduct(Vector.add(v1, v2),Vector.add(v1, v3)));
//System.out.println(Vector.crossProduct(Vector.add(v1, v2),Vector.add(v1, v3)).unitVector());
//System.out.println(Vector.dotProduct(Vector.crossProduct(Vector.add(v1, v2),Vector.add(v1, v3)).unitVector(), v1));
//System.out.println(Vector.dotProduct(Vector.crossProduct(Vector.add(v1, v2),Vector.add(v1, v3)).unitVector(), v2));
//System.out.println(Vector.dotProduct(Vector.crossProduct(Vector.add(v1, v2),Vector.add(v1, v3)).unitVector(), v3));
//System.out.println(v4a);
//System.out.println(Vector.crossProduct(v4m, v4m));
