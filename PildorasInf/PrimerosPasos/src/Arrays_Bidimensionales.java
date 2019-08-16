
public class Arrays_Bidimensionales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matriz= new int[4][5];
//		
//		matriz[0][0] = 25;
//		matriz[0][1] = 20;		
//		matriz[0][2] = 15;		
//		matriz[0][3] = 10;
//		matriz[0][4] = 5;
//		
//		matriz[1][0] = 30;
//		matriz[1][1] = 35;
//		matriz[1][2] = 40;
//		matriz[1][3] = 45;
//		matriz[1][4] = 50;
//		
//		matriz[2][0] = 40;
//		matriz[2][1] = 50;
//		matriz[2][2] = 55;
//		matriz[2][3] = 60;
//		matriz[2][4] = 65;
//		
//		matriz[3][0] = 70;
//		matriz[3][1] = 75;
//		matriz[3][2] = 80;
//		matriz[3][3] = 85;
//		matriz[3][4] = 90;
//	
//	
//		// Dos bucles for, para la 1era dim y otro para la 2da.
//		
//		for(int i=0; i<4;i++) {
//			System.out.println(" ");
//			for (int j=0; j<5; j++) {
//				System.out.print(matriz[i][j] + " ");
//			}
//			
//		}
		
		int matriz[][] = {
				{25,20,15,10,5},
				{30,35,40,45,50},
				{40,50,55,60,65},
				{70,75,80,85,90}
			};
		
		for(int i=0; i<4;i++) {
			System.out.println(" ");
			for (int j=0; j<5; j++) {
				System.out.print(matriz[i][j] + " ");
			}
		}
		
		for(int[] fila:matriz) {
			System.out.println();
			for(int z: fila) {
				System.out.print(z + " ");
			}
		}

	}
}
