package java2.lesson5;

public class Main {

    public static void main(String s[]) {
        Main o = new Main();
        o.methodOne();
        o.methodTwo();
    }

    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;

    public float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void methodOne() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println(String.format("Время выполнения метода 1: %s.", String.valueOf(System.currentTimeMillis() - a)));
    }

    public void methodTwo() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF_SIZE];
        float[] arr2 = new float[HALF_SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;

        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF_SIZE);
        System.arraycopy(arr, HALF_SIZE, arr2, 0, HALF_SIZE);
        long split = System.currentTimeMillis();
        System.out.println(String.format("Время разделения массива: %s.", String.valueOf(split - start)));

        new Thread() {
            public void run() {
                float[] a1 = calculate(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] a2 = calculate(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, HALF_SIZE);
        System.arraycopy(arr2, 0, arr, HALF_SIZE, HALF_SIZE);
        System.out.println(String.format("Время склейки массива: %s.", String.valueOf(System.currentTimeMillis() - connect)));
        System.out.println(String.format("Время выполнения метода 2: %s.", String.valueOf(System.currentTimeMillis() - start)));
    }


}
