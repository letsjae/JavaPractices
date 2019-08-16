import javax.swing.JOptionPane;

public class Uso_Arrays2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] paises = new String[8];
//		
//		paises[0]="España";
//		paises[1]="México";
//		paises[2]="Colombia";
//		paises[3]="Perú";
//		paises[4]="Chile";
//		paises[5]="Argentina";
//		paises[6]="Ecuador";
//		paises[7]="Venezuela";
//		
//		for(int i=0; i<paises.length; i++) {
//			System.out.println("País " + (i+1) + " " + paises[i]);
//		}
		
//		String[] paises_Otra_Vez= {"España","México","Colombia","Perú","Chile","Argentina","Ecuador","Venezuela"};
		
		// Reconoce hasta donde debe llegar
//		for(String elemento:paises) {
//			System.out.println("País: " + elemento);
//		}
		
//		String[] mas_paises= n(int)Math.round(Math.random()*100);ew String[5];
		
//		for (int i = 0; i < mas_paises.length; i++) {
//			mas_paises[i]=JOptionPane.showInputDialog("Introduzca un pais");
//		}
//		
//		for(String elemento: mas_paises) {
//			System.out.println("País: " + elemento);;
//		}
		
		int[] aleatorios= new int[150];
		
		for(int i=0;i<aleatorios.length;i++) {
//			aleatorios[i]=(int)Math.round(Math.random()*100);
			aleatorios[i]=(int)(Math.random()*100);
		}
		
		for(int numero:aleatorios) {
			System.out.print(numero+" ");
		}
		
	}

}
