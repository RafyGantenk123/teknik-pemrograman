public class Circle extends Shape { 
    private double radius;

    public Circle() { 
        // 1st (default) constructor
        radius = 1.0;
    }
    
    public Circle(double r) { // 2nd constructor
        radius = r;
    }

    public Circle(double r, String c, boolean f) {
        super(c, f); // memanggil constructor Shape(String, boolean)
        radius = r;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double r){
        radius = r;
    }

    
    public double getArea() {
        return radius * radius * Math.PI;
    }


    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    
   @Override
   public String toString(){
        return "A Circle with radius=" + radius +", which is a subclass of " + super.toString();
    }
}