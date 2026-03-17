// No 4
public class GenericsMethods {

    // Java Generic Method
    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {

        // Versi asli:
        // return g1.get().equals(g2.get());

        // Versi lebih aman (menghindari NullPointerException)
        return java.util.Objects.equals(g1.get(), g2.get());
    }

    public static void main(String args[]) {

        GenericsType<String> g1 = new GenericsType<>();
        g1.set("Java");

        GenericsType<String> g2 = new GenericsType<>();
        g2.set("Java");

        // Versi asli (menyebut tipe):
        // boolean isEqual = GenericsMethods.<String>isEqual(g1, g2);

        // Versi ideal (type inference oleh compiler)
        boolean isEqual = GenericsMethods.isEqual(g1, g2);

        // Tes hasil
        System.out.println("Apakah sama? " + isEqual);

        /*
         * This feature, known as type inference, allows you to invoke
         * a generic method as an ordinary method, without specifying 
         * a type between angle brackets 
         */

        // Compiler will infer the type that is needed
    }
}