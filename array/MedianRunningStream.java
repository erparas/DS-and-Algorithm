package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianRunningStream {

	public Queue<Integer> minHeap;
	public Queue<Integer> maxHeap;
	public int numElements;

	public  MedianRunningStream()
	{
		minHeap = new PriorityQueue<Integer>();
		maxHeap = new PriorityQueue<Integer>(new maxHeapComparator());
		numElements = 0;

	}
	public void addNumberToStream(int num)
	{
		maxHeap.add(num);
		if(numElements%2==0)
		{
			if(minHeap.isEmpty())
			{
				numElements++;
				return;
			}
			else
			{
				if(maxHeap.peek()>minHeap.peek())
				{
					Integer max1 = maxHeap.poll();
					Integer min1 = minHeap.poll();
					maxHeap.add(min1);
					minHeap.add(max1);
				}
			}
		}
		else
			minHeap.add(maxHeap.poll());
		numElements++;
	}

	public Double getMedian()
	{
		if(numElements%2!=0)
			return new Double(maxHeap.peek());
		else
			return (maxHeap.peek()+minHeap.peek())/2.0;
					
	}

	public static void main(String[] args)
	{

		MedianRunningStream stream = new MedianRunningStream();
		stream.addNumberToStream(1);
		System.out.println(" Median : "+stream.getMedian());
		stream.addNumberToStream(5);
		stream.addNumberToStream(10);
		stream.addNumberToStream(12);
		stream.addNumberToStream(2);
		System.out.println(" Median : "+stream.getMedian());
		stream.addNumberToStream(3);
		stream.addNumberToStream(8);
		stream.addNumberToStream(9);
		System.out.println(" Median : "+stream.getMedian());


	}

	private class maxHeapComparator implements Comparator<Integer>
	{
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2-o1;
		}

	}
}
