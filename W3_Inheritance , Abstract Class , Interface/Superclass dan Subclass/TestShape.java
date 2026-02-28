public class TestShape {
    public static void main (String[]args){
        // Test Circle
        Circle c1 = new Circle ();
        Circle c2 = new Circle (10);
        Circle c3 = new Circle (5, "blue", false);

         System.out.print("\n"
            + c1.toString() + "\n"
            + "Radius = " + c1.getRadius() + "\n"
            + "Area = " + c1.getArea() + "\n"
            + "Perimeter = " + c1.getPerimeter() + "\n"
            + "Color = " + c1.getColor() + "\n"
            + "Filled = " + c1.isFilled() + "\n"
        );

        System.out.print("\n"
            + c2.toString() + "\n"
            + "Radius = " + c2.getRadius() + "\n"
            + "Area = " + c2.getArea() + "\n"
            + "Perimeter = " + c2.getPerimeter() + "\n"
            + "Color = " + c2.getColor() + "\n"
            + "Filled = " + c2.isFilled() + "\n"
        );

        System.out.print("\n"
            + c3.toString() + "\n"
            + "Radius = " + c3.getRadius() + "\n"
            + "Area = " + c3.getArea() + "\n"
            + "Perimeter = " + c3.getPerimeter() + "\n"
            + "Color = " + c3.getColor() + "\n"
            + "Filled = " + c3.isFilled() + "\n"
        );

        // Test Rectangle
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(7, 5);
        Rectangle r3 = new Rectangle(100, 56, "red", true);

        System.out.println("\n"
            + r1.toString() + "\n"
            + "Length = " + r1.getLength() + "\n"
            + "Width = " + r1.getWidth() + "\n"
            + "Area = " + r1.getArea() + "\n"
            + "Perimeter = " + r1.getPerimeter() + "\n"
            + "Color = " + r1.getColor() + "\n"
            + "Filled = " + r1.isFilled() + "\n"
        );

        System.out.println("\n"
            + r2.toString() + "\n"
            + "Length = " + r2.getLength() + "\n"
            + "Width = " + r2.getWidth() + "\n"
            + "Area = " + r2.getArea() + "\n"
            + "Perimeter = " + r2.getPerimeter() + "\n"
            + "Color = " + r2.getColor() + "\n"
            + "Filled = " + r2.isFilled() + "\n"
        );

        System.out.println("\n"
            + r3.toString() + "\n"
            + "Length = " + r3.getLength() + "\n"
            + "Width = " + r3.getWidth() + "\n"
            + "Area = " + r3.getArea() + "\n"
            + "Perimeter = " + r3.getPerimeter() + "\n"
            + "Color = " + r3.getColor() + "\n"
            + "Filled = " + r3.isFilled() + "\n"
        );


        // Test Square
        Square s1 = new Square(10);
        Square s2 = new Square(67, "green", true);

        System.out.print("\n"
            + s1.toString() + "\n"
            + "Side = " + s1.getSide() + "\n"
            + "Area = " + s1.getArea() + "\n"
            + "Perimeter = " + s1.getPerimeter() + "\n"
            + "Color = " + s1.getColor() + "\n"
            + "Filled = " + s1.isFilled() + "\n"
        );

        System.out.print("\n"
        + s2.toString() + "\n"
        + "Side = " + s2.getSide() + "\n"
        + "Area = " + s2.getArea() + "\n"
        + "Perimeter = " + s2.getPerimeter() + "\n"
        + "Color = " + s2.getColor() + "\n"
        + "Filled = " + s2.isFilled() + "\n"
        );
    }
}