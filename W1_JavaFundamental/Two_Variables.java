
class Constants { 
    public static void main(String[] args) { 
        final double CM_PER_INCH = 2.54; double paperWidth = 8.5; double paperHeight = 11;
        System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}

class Constants2 { 
    public static final double CM_PER_INCH = 2.54; public static void main(String[] args) { 
        double paperWidth = 8.5; double paperHeight = 11;
        System.out.println("Paper size in centimeters: " + paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}


public class Two_Variables {
    public static void main(String[] args) {
        System.err.println("\n");
        System.out.println("output Constants =");
        Constants.main(args);
        System.out.println("\noutput Constants2 =");
        Constants2.main(args);
    }
}