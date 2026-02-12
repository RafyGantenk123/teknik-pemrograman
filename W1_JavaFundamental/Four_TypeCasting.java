class ConvertDataType { static short 
    methodOne(long l) { int i = (int) l; 
    return (short)i;
    }
    public static void main(String[] args) { double d = 10.25; float f = (float) d;
    byte b = (byte) methodOne((long) f); System.out.println(b);
    }
    }


public class Four_TypeCasting {
    public static void main(String[] args) {
        ConvertDataType.main(args);
}
}