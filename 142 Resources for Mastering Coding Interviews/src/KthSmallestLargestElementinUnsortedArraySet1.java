import javax.swing.JOptionPane;

public class KthSmallestLargestElementinUnsortedArraySet1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] array_de_ints = {5,8,1,10,3};
		
		int[] array_de_ints = {1,5,8,10,3};
		
		int kth = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un valor: "));
				
		KthSmallestElementinUnsortedArraySet1_Solution solution = 
				new KthSmallestElementinUnsortedArraySet1_Solution(array_de_ints, kth);
	
		System.out.println("El #" + kth + " valor más chico del array es: " + solution.solution());
	}

}

class Sort {
	public Sort(int[] array) {
		array_to_order = array;
	}
	
	public Sort() {}
	
	public int[] insertion_sort(int [] array){
		
		for (int j = 0; j < array.length-1; j++) {
			int min_position=j;
			
			for (int i = j+1; i < array.length; i++) 
				if ( array[i] < array[min_position] ) 
					min_position=i;
				
			int aux = array[min_position];
			array[min_position] = array[j];
			array[j] = aux;
			
		}
		return array;
	}
	
	private int [] array_to_order;
}

class KthSmallestElementinUnsortedArraySet1_Solution{
	public KthSmallestElementinUnsortedArraySet1_Solution (int [] array, int kth){
		this.array = array;
		this.kth = kth;
	}
	
	public int solution(){
		Sort sorting_array = new Sort();
		sorting_array.insertion_sort(this.array);
		return this.array[this.kth-1];
	}
	
	private int [] array;
	private int kth;
}













