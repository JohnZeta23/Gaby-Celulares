package ClasesAbstractas;

public interface AgregarOVender {

	int ID = 0;
	int Cantidad = 0;
	public int Precio = 0;
	
	public void Query(String marca, String producto, int cantidad);
	
	public void Query2(String marca, String producto, int cantidad);
}
