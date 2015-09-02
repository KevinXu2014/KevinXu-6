public class Maximumyield {
	
	public static int[] x;	
	
	public int max(int[] n) {
		
		int len = n.length;		
		
		if (len == 1)
			return n[0];
		
		if (len == 2)
			if (n[0]>n[1])
				return n[0];
			else
				return n[1];
	
		
		int[] n1 = new int[len-1];		
		System.arraycopy(n, 0, n1, 0, len-1);
		
		int[] n2 = new int[len-2];
		System.arraycopy(n, 0, n2, 0, len-2);
		
		if ((n[len-1] + max(n2))>max(n1)){
			x[len-1] = n[len-1];
			x[len-2] = 0;
			return n[len-1] + max(n2);
		}else{
			x[len-2] = n[len-2];
			x[len-1] = 0;
			return max(n1);
		}		
		
	}
	
	public static void main(String[] args){
		int[] n = {147, 206, 52, 240, 300, 1, 2, 3}; 
		
		x = new int[n.length];
				
		for(int i = 0;i < x.length; i++){
			x[i] = 0;
		}		
				
		Maximumyield xx = new Maximumyield();
			
		System.out.println(xx.max(n));
		
		for(int i = 0;i < 8; i++){
			System.out.print(x[i] + " ");
		}

		
	}
}
