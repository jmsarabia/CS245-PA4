
public class ArrayQueue implements Queue{
	
	private Object[] arr;
	private int head;
	private int tail;
	
	
	public ArrayQueue()
	{
		//Default size: 10
		arr = new Object[10];
		head = 0;
		tail = 0;
	}
	
	public void enqueue(Object item)
	{
		if(isFull())
		{
			grow_queue();
		}
		
		arr[tail] = item;
		tail++;
		tail = circleBack(tail, arr.length);
	}
	
	public Object dequeue()
	{
		if(empty())
		{
			return null;
		}
		// May need a check here concerning the space that should be between the tail and the head
		Object item = arr[head];	//Don't need to replace with null b/c when we get back to it, we won't care what's there                                                                                                                                                                                                                                                                             
		head++;
		head = circleBack(head, arr.length);
		return item;
	}
	
	
	
	private void grow_queue()
	{
		Object[] tmp_arr = new Object[arr.length * 2];
		//If head hasn't moved, copy whole array to tmp_arr, else copy with head used as parameter
		if (head == 0)	//could be head == tail
		{
			System.arraycopy(arr, 0, tmp_arr, 0, arr.length);
			tail = arr.length - 1;
		}
		else
		{
			//Copy everything from head to end
			System.arraycopy(arr, head, tmp_arr, 0, arr.length-head);
			//Copy everything from beginning to head
			System.arraycopy(arr, 0, tmp_arr, arr.length-head, head-1);
			
			tail = arr.length - 1;
		}
		arr = tmp_arr;
		head = 0;
	}
	
	public boolean empty()
	{
		//TODO: Is there a mod function for this?
		if (head == tail)
			return true;
		return false;
	}
	
	//Circle back to beginning of array at 0
	public int circleBack(int num, int length)
	{
		if(num >= length)
		{
			return num%length;
		}
		return num;
	}
	
	//Check array is full; tried to do with global variable int size before
	public boolean isFull()
	{
		int next = tail + 1;
		int index = circleBack(next, arr.length);
		if(index == head)
		{
			return true;
		}
		return false;	
	}
	
	/*private void printArr()
	{
		System.out.println("[ ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(i);
			if(i != arr.length -1)
			{
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}
*/
}
