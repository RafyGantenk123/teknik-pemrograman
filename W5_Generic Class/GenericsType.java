//No 2
public class GenericsType<T> {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        GenericsType<String> type = new GenericsType<>(); // casting type jadi disini
        type.set("Java"); // valid
        String str = type.get(); // tidak perlu type casting lagi 
        System.out.println(str); 

        GenericsType type1 = new GenericsType(); // raw type | WARNING: GenericsType is a raw type. References to generic type GenericsType<T> should be parameterized
        type1.set("Java Raw"); // valid | WARNING: Type safety: The method set(Object) belongs to the raw type GenericsType. References to generic type GenericsType<T> should be parameterized
        String str1 = (String) type1.get(); // wajib type casting 
        System.out.println(str1); 

        type1.set(10); // valid and autoboxing support | WARNING: Type safety: The method set(Object) belongs to the raw type GenericsType. References to generic type GenericsType<T> should be parameterized
        Integer ing = (Integer) type1.get(); 
        System.out.println(ing); 
    }
}
