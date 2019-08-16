
public class Uso_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ambas formas son validas
		int[] mi_matriz= new int[5];
		int mi_otra_matriz[] =new int[5];
		
		// Declaración simplificada/implícita
		int[] otra_matriz_mas={11,78,30,-85,5};
		
		mi_matriz[0]=3;
		mi_matriz[1]=4;
		mi_matriz[2]=6;
		mi_matriz[3]=1;
		mi_matriz[4]=8;
		
//		for (int i = 0; i < 5; i++) {
		for (int i = 0; i < mi_matriz.length; i++) {
//			System.out.println(mi_matriz[i]);
			System.out.println("El valor del indice " + i + " = " + mi_matriz[i]);
		}
		
	}

}
