
public class Libro {
	
	public Libro(String titulo, String autor, int ISBN) {
		
		this.titulo=titulo;
		
		this.autor=autor;
		
		this.ISBN=ISBN;
	}
	
	public String getDatos() {
		
		return "El título es "+ titulo + ". El autor es " + autor + " El ISBN es: " + ISBN;
	}
	
//	public boolean equals(Object obj) {
//		
//		if (obj instanceof Libro) {
//			
//			Libro otro=(Libro) obj;
//			
//			if(this.ISBN==otro.ISBN) {
//			
//				return true;
//			
//			} else {
//			
//				return false;
//			
//			}
//		
//		} else {
//		
//			return false;
//		
//		}
//	}
	
	
	
	private String titulo;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (ISBN != other.ISBN)
			return false;
		return true;
	}

	private String autor;
	
	private int ISBN;
}
