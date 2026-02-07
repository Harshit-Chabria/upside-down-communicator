import java.util.*;

interface MathOperation {
    int operate(int a, int b);
}

class GenericStorage<T> {
    private T item;

    public GenericStorage(T item) {
        this.item = item;
    }

    public void display() {
        System.out.println("Stored Item: " + item);
    }
}

class NumericStorage<T extends Number> {
    private T number;

    public NumericStorage(T number) {
        this.number = number;
    }

    public void displayValue() {
        System.out.println("Numeric Value: " + number.doubleValue());
    }
}

public class JavaGenericsDemo {

    public static <T extends Comparable<T>> T findMax(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) max = b;
        if (c.compareTo(max) > 0) max = c;
        return max;
    }

    public static void displayList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static double sumOfList(List<? extends Number> list) {
        double sum = 0.0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }

    public static void main(String[] args) {
        GenericStorage<String> stringStore = new GenericStorage<>("Hello Christ University");
        GenericStorage<Integer> intStore = new GenericStorage<>(100);
        stringStore.display();
        intStore.display();

        NumericStorage<Double> doubleStore = new NumericStorage<>(99.99);
        doubleStore.displayValue();

        System.out.println("Max of 10, 20, 15: " + findMax(10, 20, 15));
        System.out.println("Max of Apple, Zebra, Mango: " + findMax("Apple", "Zebra", "Mango"));

        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);

        System.out.print("Unbounded Wildcard: ");
        displayList(intList);

        System.out.println("Upper Bounded Sum: " + sumOfList(doubleList));

        addIntegers(intList);
        System.out.print("Lower Bounded (After Adding): ");
        displayList(intList);

        MathOperation multiplication = (a, b) -> a * b;
        System.out.println("Functional Interface (10 * 5): " + multiplication.operate(10, 5));

        List<String> names = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "Ruby"));
        names.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted List using Lambda: " + names);

        System.out.println("\nAdvantages:");
        System.out.println("1. Generics: Stronger type checks at compile time and elimination of casts.");
        System.out.println("2. Lambda: Concise code, improves readability, and enables functional programming.");
    }
}