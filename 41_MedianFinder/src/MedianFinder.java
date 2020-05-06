import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @authour winner
 * @Date 2020/5/5 16:21
 */
public class MedianFinder {

    //大元素使用小顶堆
    private PriorityQueue<Integer> minHeap;
    //小元素使用大顶堆
    private PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        //优先加入小顶堆，小顶堆元素个数与大顶堆个数相等或者多1
        minHeap.add(num);
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
            if (maxHeap.peek() > minHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(tmp);
            }
        }

        if (!maxHeap.isEmpty()) {
            if (maxHeap.peek() > minHeap.peek()) {
                int tmp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(tmp);
            }
        }

    }

    public double findMedian() {
        if (minHeap.size() == 0) {
            return 0;
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (Double.valueOf(minHeap.peek()) + Double.valueOf(maxHeap.peek())) / 2;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }
}
