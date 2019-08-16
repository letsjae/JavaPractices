package usoThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Banco b=new Banco();
		
		for (int i = 0; i < 100; i++) {
			EjecucionTransferencias r=new EjecucionTransferencias(b, i, 2000);
			
			Thread t= new Thread(r);
			
			t.start();
		}
	}

}

class Banco{
	public Banco() {
		
		cuentas=new double[100];
		
		for (int i = 0; i < cuentas.length; i++) {
			
			cuentas[i]=2000;
			
		}
		
//		saldoSuficiente=cierreBanco.newCondition(); 
	}
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
		
//		cierreBanco.lock();
		
//		try {
			
			while (cuentas[cuentaOrigen]<cantidad) { // mientras esta condicion sea verdad, el hilo debe permanecer a la espera
				
//				saldoSuficiente.await(); // Ademas de ponerse a la espera se libera el bloqueo
				
				wait();
			}
			
//			if (cuentas[cuentaOrigen]<cantidad) {
//				
//				System.out.println("----------CANTIDAD INSUFICIENTE: " + cuentaOrigen + "-----SALDO: " + cuentas[cuentaOrigen] + "-----" + cantidad);
//				
//				return;
//			
//			} else {
//				
//				System.out.println("----------CANTIDAD OK " + cuentaOrigen);
//				
//			}
			
			System.out.println(Thread.currentThread());
			
			cuentas[cuentaOrigen]-=cantidad;
			
			System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);
			
			cuentas[cuentaDestino]+=cantidad;
			
			System.out.printf(" Saldo total: %10.2f%n", getSaldoTotal());
			
//			saldoSuficiente.signalAll();
			
			notifyAll();
		
//		} finally {
//		
//			cierreBanco.unlock();
//		
//		}

	}
	
	public double getSaldoTotal(){
		double sumaCuentas=0;
		
		for (double c : cuentas) {
			sumaCuentas+=c;
		}
		
		return sumaCuentas;
	}
	
	
	private final double[] cuentas;
	
	private Lock cierreBanco=new ReentrantLock();
	
	private Condition saldoSuficiente;
	
}

class EjecucionTransferencias implements Runnable{
	public EjecucionTransferencias(Banco b, int de, double max) {
		
		banco=b;
		
		deLacuenta=de;
	
		cantidadMax=max;
	}
	
	public void run() {
		
		try {
			while (true) {
				
				int paraLaCuenta=(int)(100*Math.random());
				
				double cantidad=cantidadMax*Math.random();
				
				banco.transferencia(deLacuenta, paraLaCuenta, cantidad);
				
				Thread.sleep((int) Math.random()*10);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
	
	private Banco banco;
	
	private int deLacuenta;
	
	private double cantidadMax;
}

























