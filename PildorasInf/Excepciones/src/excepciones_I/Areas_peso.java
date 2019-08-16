package excepciones_I;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Areas_peso {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada=new Scanner(System.in);
		
		System.out.println("Elige una opción: \n1) Cuadrado \n2) Rectángulo \n3) Triángulo \n4) Círculo");
		 
		
		try{
			figura=entrada.nextInt();
			
			// entrada.close(); -> si ocurrre una excepción, ésta línea no es ejecutada
			// pasa directo al catch
		} catch (Exception e) {
			System.out.println("Ocurrió un error");
		} finally {
			entrada.close();
		}
		
		entrada.close();
		 
		 switch(figura) {
		 	case 1:
		 		int lado=Integer.parseInt(JOptionPane.showInputDialog("Introduce el lado"));
		 		
		 		System.out.println(Math.pow(lado, 2));
		 		
		 		break;
		 	
		 	case 2:
		 		int base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
		 		
		 		int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
		 		
		 		System.out.println("El área del rectángulo es" + base*altura);
		 		
		 		break;
		 	
		 	case 3:
		 		base=Integer.parseInt(JOptionPane.showInputDialog("Introduce la base"));
		 		
		 		altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce la altura"));
		 		
		 		System.out.println("El área del triángulo es" + (base*altura)/2);
		 		
		 		break;
		 	
		 	case 4:
		 		int radio=Integer.parseInt(JOptionPane.showInputDialog("Introduce el radio"));
		 		
		 		System.out.println("El área del triángulo es: " + Math.PI*Math.pow(radio,2));
		 		
		 		break;
		 		
		 	default:
		 		System.out.println("Opción incorrecta");
		 }
		 
		 // - - - - - SEGUNDA PARTE
		 
		 int altura=Integer.parseInt(JOptionPane.showInputDialog("Introduce tu altura en cm: "));
		 
		 System.out.print("Si eres hombre tu peso ideal es: " + (altura-110) + " kg");
		 
		 System.out.print("Si eres mujer tu peso ideal es: " + (altura-120) + " kg");
		 
		 
	}
	
	static int figura;

}
