package clasesPropias;

public class MetodosGenericos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombres[]= {"Jey", "Jael", "J"};
		
//		String elementos=MisMatrices.getElementos(nombres);
		
//		System.out.println(elementos);
		
		
		System.out.println(MisMatrices.getMenor(nombres));
		
		
				
	}

}

class MisMatrices{
	public static <T extends Comparable> T getMenor(T[] a) {
		 if (a==null || a.length==0) {
			return null;
		}
		 
		 T elementoMenor=a[0];
		 
		 for (int i = 1; i < a.length; i++) {
			if (elementoMenor.compareTo(a[i]) >0) {
				elementoMenor=a[i];
			}
		}
		 
		 return elementoMenor;
	}
}