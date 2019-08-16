class Sort {
	public Sort() {}
	/* Simplest Sort */
	public int[] selection_sort(int [] array){		
		for (int i = 0; i < array.length-1; i++) {
			int min_position=i;
			for (int j = i+1; j < array.length; j++) 
				if ( array[j] < array[min_position] ) 
					min_position=j;
				
			int aux = array[min_position];
			array[min_position] = array[i];
			array[i] = aux;			
		}
		return array;
	}
	
	public int[] insertion_sort(int [] array) {
		for(int i=1; i < array.length; i++) {
			
			int aux=array[i];
			int j = i-1;
			
			while( j >= 0 && array[j] > aux) {
				array[j+1] = array[j];
				j=j-1;
			}
			
			array[j+1]=aux;
			
			
//			for(int j=i-1; j>-1; j--) {
//				if (array[i] < array[j]) {
//					larger_element_position = j;
//				}
//			}
			
//			for(int j=0; j<i; j++) {
//				if (array[j] > array[i]) {
//					larger_element_position = j-1;
//				}
//			}
//			
//			if (larger_element_position != i) {
//				int aux = array[i];
//				
//				for (int k = i; k > larger_element_position; k--) {
//					array[k]=array[k-1];
//				}
//				array[larger_element_position]=aux;
//			}
		}
		return array;
	}
	
	
	
}