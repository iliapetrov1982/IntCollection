public class Main {
    public static void main(String[] args) {
        IntCollection intCol = new IntCollection();
        // add
        System.out.println("add:");
        intCol.add(1);
        intCol.add(10);
        intCol.add(2);
        intCol.add(6);
        intCol.add(12);
        intCol.add(31);
        System.out.println(intCol);
        System.out.println();
        // remove
        System.out.println("remove by index:");
        intCol.remove(2);
        System.out.println(intCol);
        System.out.println();
        // search by value
        System.out.println("search by value:");
        System.out.println(intCol.indexOf(34));  // fail
        System.out.println(intCol.indexOf(10));  // success
        System.out.println();
        // search by index
        System.out.println("search by index:");
        System.out.println((intCol.elementData[2]));
        System.out.println();
        // max value
        System.out.println("max value:");
        System.out.println((intCol.getMax()));
        System.out.println();
        // min value
        System.out.println("min value:");
        System.out.println((intCol.getMin()));
        System.out.println();
        // mean count
        System.out.println("mean:");
        System.out.println((intCol.countMean()));
        System.out.println();
    }
}
