
public class ArrayStack implements Stack {

	private Object[] arr;
	private int top;
	
	public ArrayStack()
	{
		arr = new Object[10];
		top = -1;
	}
	
	public void push(Object item)
	{
		//If top has reached the end of array
		if(top + 1 == arr.length)
		{
			grow_arr();
		}
		// Class notes
		arr[++top] = item;
		
	}
	protected void grow_arr()
	{
		Object[] tmp = new Object[2*arr.length];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		arr = tmp;
	}
	
	//Use peek to find the object, return the object and set original object to null
	public Object pop()
	{
		if(empty())
		{
			return null;
		}
		Object topObject = peek();
		arr[top] = null;
		top--;
		return topObject;
	}
	
	//Return object at current top
	public Object peek()
	{
		if(empty())
			return null;
		return arr[top];
	}
	//Treating the state of "empty" if top = -1, as the top reached the beginning of the array
	public boolean empty()
	{
		if(top == -1)
		{
			return true;
		}
		return false;
	}
}
