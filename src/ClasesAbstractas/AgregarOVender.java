package ClasesAbstractas;

public interface AgregarOVender {

	int ID = 0;
	int Cantidad = 0;
	public int Precio = 0;
	
	public void AumentarCantidadCelulares(String marca, String producto, int cantidad);
	
	public void AumentarCantidadAccesorios(String marca, String producto, int cantidad);
}
