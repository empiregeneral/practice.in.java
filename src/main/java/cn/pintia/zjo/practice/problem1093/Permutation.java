package cn.pintia.zjo.practice.problem1093;

public class Permutation {
    private static void swap(int arr[], int i, int j){
        if(arr.length==0 || i<0 || j<0) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printAll(int arr[], int n){
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void perm(int arr[], int start, int end){
        if(start == end){
            printAll(arr, start+1);
        }else{
            int i;
            for(i = start; i <= end; i++){
                swap(arr, start, i);
                perm(arr, start+1, end);
                swap(arr, start, i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 30};
        perm(arr, 0, arr.length - 1);
    }
}
