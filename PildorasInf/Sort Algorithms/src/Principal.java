import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
	
		int[] ints_array = {1,5,8,10,3};
		int[] ints_array_1 = {5,1,4,8,3,2};
		
		Sort sorting_alg = new Sort();
		
		sorting_alg.selection_sort(ints_array);
		
		sorting_alg.insertion_sort(ints_array);
		
		for(int integer:ints_array) {
			System.out.println(integer);
		}
		
	}
}


