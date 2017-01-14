import java.util.Arrays;
import java.util.Objects;

/**
 * Rotate an array of n elements to the right by k steps
 * n = 7, k = 3, the array [1, 2, 3, 4, 5, 6, 7] => [5, 6, 7, 1, 2, 3, 4]
 */
public class ArrayUtils {

    // return a new array from the original array
    public int[] rotate(int[] arr, int k) {
        if(k <= 0 || Objects.isNull(arr) || arr.length == 1) {
            return arr;
        }
        int n = arr.length;
        if(k > n) {
            k = k % n;
        }
        int[] rotatedArr = new int[n];
        for(int i = 0; i < n; i++) {
            if(i + k < n) {
                rotatedArr[i + k] = arr[i];
            } else {
                rotatedArr[i + k - n] = arr[i];
            }
        }
        return rotatedArr;
    }

    /*
     * rotate the array directly on itself
     * Repeatedly Find the element that the current element will be swapped to
     * Set the current element to its swapping element
     * when the index of the element back to 0, it's done
     */
    public void inlineRotate(int[] arr, int k) {
        if(k <= 0 || Objects.isNull(arr) || arr.length == 1) {
            return;
        }
        int n = arr.length;
        if(k > n) {
            k = k % n;
        }
        int index = 0;
        int elem  = arr[index];

        do {
            int swappingIndex = index + k;
            if(index + k >= n) {
                swappingIndex = index + k - n;
            }
            // before swap
            int temp = arr[swappingIndex];

            // swap
            arr[swappingIndex] = elem;
            elem = temp;

            index = swappingIndex;
        } while(index != 0);

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        ArrayUtils util = new ArrayUtils();
        util.inlineRotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
