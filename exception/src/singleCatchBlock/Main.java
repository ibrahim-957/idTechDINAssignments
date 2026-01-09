package singleCatchBlock;

public class Main {
    public static void main(String[] args) {
        try{
            int[] arr = new int[10];
            System.out.println(arr[11]);

            int result = 10/0;
            System.out.println(result);
        }
        catch (Exception e){
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
