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
	
	public Vector add(Vector v){
		return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
	}

	public Vector minus(Vector v){
		return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
	}
	
	public Vector scalarMultiplication(double scalar){
		return new Vector(scalar * this.x, scalar * this.y, scalar * this.z);
	}
	
	public double dotProduct(Vector v){
		return ((this.x * v.x) + (this.y * v.y) + (this.z * v.z));
	}
	
	public double angle(Vector v){
	
		return Math.acos(dotProduct(v)/(this.magnitude()*v.magnitude()))* (180/Math.PI);
	}
	
	
	public double magnitude(){
		return (Math.sqrt((this.x*this.x) + (this.y * this.y) + (this.z * this.z)));
	}
	
	public Vector unitVector(){
		return new Vector(this.x/this.magnitude(),this.y/this.magnitude(), this.z/this.magnitude());
	}
		
	public double getX(){return x;}
	public double getY(){return y;}
	public double getZ(){return z;}
	
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public void setZ(double z){
		this.z = z;
	}
	
	public String toString(){
		//System.out.printf("%4.5f\t%4.5f\t%4.5f", (float) getX(), (float) getY(), (float) getZ());
		return this.x + ", " + this.y + ", " + this.z;
	}
	
	public static void main(String[] args){
		Vector v1 = new Vector(-6,8,0);
		Vector v2 = new Vector(5,12,0);
		
		System.out.println(v1.dotProduct(v2));
		System.out.println(v1.angle(v2) + " deg");
		
		System.out.print("<"+v1+"> + <" + v2 + "> = <");
		System.out.print(v1.add(v2));
		System.out.println(">");
		
		System.out.print("<"+ v1 +"> - <" + v2 + "> = <");
		System.out.print(v1.minus(v2));
		System.out.println(">");
	}
}