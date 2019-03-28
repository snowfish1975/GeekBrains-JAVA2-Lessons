public class Main {

    private static final int SIZE = 10000000;
    private static final int h = SIZE / 2;
    private static float[] arr = new float[SIZE];
    private static float[] a1 = new float[SIZE];
    private static float[] a2 = new float[SIZE];

    public static void main(String[] args) {
        System.out.println( single(arr) );
        System.out.println( multy(arr) );
    }

    private static long single(float[] arr){
        long start = System.currentTimeMillis();
        calculate(arr);
        long end = System.currentTimeMillis();
        return end-start;
    }

    private static long multy(float[] arr){
        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Thread th1;
        Thread th2;

        th1 = new Thread(() -> Main.calculate(a1));
        th1.start();
        th2 = new Thread(() -> Main.calculate(a2));
        th2.start();

        try{
            th1.join();
            th2.join();
        } catch(InterruptedException e){
            System.out.println("ERROR: Interrupted Exception occured...");
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        long end = System.currentTimeMillis();
        return end-start;
    }

    public static void calculate(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
