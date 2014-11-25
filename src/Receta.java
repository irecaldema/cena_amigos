import java.util.ArrayList;

public class Receta {
	private String nombreReceta;
	private ArrayList<Ingrediente> ingredientes;
	private String preparacion;	

	/*public Receta(String nombreReceta,ArrayList<Ingrediente> ingredientes, String preparación) {
		this.nombreReceta = nombreReceta;
		this.ingredientes = ingredientes;
		this.preparacion = preparacion;
	}*/

	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	public String getNombreReceta() {
		return nombreReceta;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		
		this.ingredientes = ingredientes;
	}
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public String getPreparacion() {
		return preparacion;
	}
}