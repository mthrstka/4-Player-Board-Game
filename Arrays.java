
import java.util.stream.*;



public class Arrays {

	public Arrays() {
		// TODO Auto-generated constructor stub
	}

	
	public static void setArray(int[] Arr) {
		
		for (int i = 0; i < 3; i++) {
			
			//set a temp int from 1-20
			int temp = (int)(Math.random()*20)+1;
			
			//if statement to check if the current temp is in the array to make array unique
			if (IntStream.of(Arr).anyMatch(x -> x == temp)) {
				i--;
			} else {
				
				Arr[i] = temp;
				System.out.print(Arr[i] + " ");
			}
			

		}
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int pl1[] = new int[20];
		int pl2[] = new int[20];
		

		
		
		setArray(pl1);
		System.out.println();
		setArray(pl2);
		
		
		
	}


}
