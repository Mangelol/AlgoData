import java.util.*;

class Main {
    public static void main(String[] args) {

        int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400 };
        int runs = 5000;
        double min;
        Random rnd = new Random();
        BinaryTree tree = new BinaryTree();

        System.out.println("# Binary search vs Lookup");
        System.out.printf("#%7s\t%9s\t%9s\n", "n", "Binary Search", "Lookup");

        for (int n : sizes) {
            System.out.printf("%8d\t", n);

            for (int i = 0; i < n; i++){
                tree.add((rnd.nextInt(n) + i*n), rnd.nextInt(100));
            }
            int[] array = new int[n];
            for(int i = 0; i < n;i++){
                array[i] = rnd.nextInt(n);
            }
            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < runs; i++) {

                long t0 = System.nanoTime();
                //tree.binary_search(array, 99);
                long t1 = System.nanoTime();

                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%9.0f\t", min);

            min = Double.POSITIVE_INFINITY;
            for (int i = 0; i < runs; i++) {
                long t0 = System.nanoTime();
                tree.lookup((rnd.nextInt(n) + i*n));
                long t1 = System.nanoTime();

                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }
            System.out.printf("%9.0f\t\n", min);
        }
    }
}