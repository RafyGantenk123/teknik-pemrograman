public class Square extends Rectangle{
    public Square(double side){
        super(side, side);
    }

    public Square(double side, String c, boolean f){
        super(side, side, c, f);
    }

    public double getSide(){
        return getWidth();
    }

    public void setSide(double side){
        super.setWidth(side);
        super.setLength(side);
    }

    public double getArea(){
        return super.getArea();
    }

    public double getPerimeter(){
        return super.getPerimeter();
    }

    @Override
    public void setLength(double side){
        setSide(side);
    }

    @Override
    public void setWidth(double side){
        setSide(side);
    }

    @Override
    public String toString(){
        return "A Square with side=" + getSide() + ", which is a subclass of " + super.toString();
    }
}