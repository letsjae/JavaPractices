package usoThreads;

public class SincronizandoHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hilosVarios hilo1=new hilosVarios();
		
		hilosVarios2 hilo2=new hilosVarios2(hilo1);
		
		hilo2.start();
		
		hilo1.start();
		
		System.out.println("Terminadas las tareas");
	}

}

class hilosVarios extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Ejecutando hilo" + getName());
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class hilosVarios2 extends Thread {
	public hilosVarios2(Thread hilo) {
		this.hilo=hilo;
	}
	
	
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Ejecutando hilo" + getName());
			
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private Thread hilo;
}