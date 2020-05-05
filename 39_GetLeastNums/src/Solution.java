import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @authour winner
 * @Date 2020/5/5 15:52
 */
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k <= 0) {
            return new int[]{};
        }
        //java 大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                heap.add(arr[i]);
            } else {
                if (heap.peek() > arr[i]) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }
        }

        int[] result = new int[k];
        int i = 0;
        for (int num : heap) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,1};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr, 1)));
    }
}
