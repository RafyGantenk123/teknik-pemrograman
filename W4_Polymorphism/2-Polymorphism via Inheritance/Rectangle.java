public class Rectangle extends Shape
{
    private final double length;
    private final double width;

    public Rectangle(double l, double w)
    {
        super("Rectangle");
        length = l;
        width = w;
    }
    @Override
    public double area()
    {
        return length * width;
    }
    @Override
    public String toString()
    {
        return super.toString() + " of length " + length + " and width " + width;
    }
}