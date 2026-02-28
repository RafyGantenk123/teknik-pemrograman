public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle() {
        length = 1.0;
        width = 1.0;
    }

    public Rectangle(double l, double w){
        length = l;
        width = w;
    }

    public Rectangle (double l, double w, String c, boolean f){
        super(c,f);
        length = l;
        width = w;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double w){
        width = w;
    }

    public double getLength() {
        return length;
    }

    public void setLength (double l){
        length = l;
    }
    public double getArea (){
        return length * width;
    }
    public double getPerimeter(){
        return 2 * (length + width);
    }

    @Override
    public String toString(){
            return "A Rectangle with width =" + width +" and length " + length + " which is a subclass of " + super.toString();
        }


}