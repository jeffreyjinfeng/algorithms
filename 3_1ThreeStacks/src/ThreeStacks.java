import java.util.EmptyStackException;



/*cc150 3.1
 * Describe how you could use a single array to implement three stacks*/
public class ThreeStacks {

	public static void main(String[] args) {
		
		

	}
	
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1,-1,-1};
	
	void push(int stackNum, int value) throws Exception{
		if (stackPointer[stackNum] + 1 >= stackSize){
			throw new Exception("Full Stack");
		}
		stackPointer[stackNum]++;
		buffer[absTopOfStack(stackNum)] = value;
	}
	
	int pop(int stackNum) throws Exception{
		if (isEmpty(stackNum)){
			throw new EmptyStackException();
		}
		int value = buffer[absTopOfStack(stackNum)];
		buffer[absTopOfStack(stackNum)] = 0;
		stackPointer[stackNum]--;
		return value;
	}
	
	int peek(int stackNum){
		int index = absTopOfStack(stackNum);
		return buffer[index];
		
	}
	
	boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
	
	int absTopOfStack(int stackNum){
		return stackNum*stackSize + stackPointer[stackNum];
	}

}
