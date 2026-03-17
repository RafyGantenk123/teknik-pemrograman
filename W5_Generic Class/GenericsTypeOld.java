//No 1
public class GenericsTypeOld {

    private Object t; // Menyimpan data bertipe Object → bisa apa saja (tidak type-safe)

    public Object get() {
        return t; // Mengembalikan nilai sebagai Object (tipe asli tidak diketahui)
    }

    public void set(Object t) {
        this.t = t; // Menyimpan nilai ke field t
    }

    public static void main(String args[]) {

        GenericsTypeOld type = new GenericsTypeOld(); // Membuat objek

        type.set("Java"); // Menyimpan String sebagai Object

        String str = (String) type.get(); 
        // Casting dari Object ke String
        // Berisiko ClassCastException jika isinya bukan String

        System.out.println(str);
    }
}