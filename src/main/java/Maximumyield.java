public class Maximumyield {
	
	// result will hold the result of which numbers get selected
	public static int[] result;	
	
	//use recursive algorithm 
	public int max(int[] n) {
		
		int len = n.length;		
		
		// if the array has 1 element
		if (len == 1)
			return n[0];
		
		// if the array has 2 elements
		if (len == 2)
			if (n[0]>n[1])
				return n[0];
			else
				return n[1];
	
		// if the array has more than 2 elements
		int[] n1 = new int[len-1];		
		System.arraycopy(n, 0, n1, 0, len-1);
		
		int[] n2 = new int[len-2];
		System.arraycopy(n, 0, n2, 0, len-2);
		
		if ((n[len-1] + max(n2))>max(n1)){
			result[len-1] = n[len-1];
			result[len-2] = 0;
			return n[len-1] + max(n2);
		}else{
			result[len-2] = n[len-2];
			result[len-1] = 0;
			return max(n1);
		}		
		
	}
	
	//main method
	public static void main(String[] args){
		// test with a simple array
		int[] n = {147, 206, 52, 240, 300, 1, 20, 398}; 
		
		result = new int[n.length];
				
		for(int i = 0;i < result.length; i++){
			result[i] = 0;
		}		
				
		Maximumyield maxyield = new Maximumyield();
			
		
		System.out.println("Total should return " + maxyield.max(n) + " units");
		
		System.out.print("The original mine is  ");
		for(int i = 0;i < n.length; i++){
			System.out.print(n[i] + " ");
		}
		
		System.out.println("");
		
		System.out.print("The optimal is  ");
		for(int i = 0;i < result.length; i++){
			System.out.print(result[i] + " ");
		}

		
	}
}
