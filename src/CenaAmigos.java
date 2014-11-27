import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class CenaAmigos {
	public static void main (String args[]) throws IOException 	{
		Scanner sc = new Scanner(System.in);

		int cantidadGramos, cantidadUnidad;
		ArrayList <Receta> recetas = new ArrayList <Receta> ();
		String preparacion, nombreIngrediente;
		boolean enGramos;

		System.out.println("¿Que numero de recetas quiere introducir?");
		int num_recetas=sc.nextInt();	

		for(int y=0; y<num_recetas; y++) {
			Receta rece = new Receta();			
			System.out.println("¿Cual es el nombre de la receta?");
			rece.setNombreReceta(sc.next());		

			System.out.println("¿Que numero de ingredientes quiere introducir?");
			int num_ingredientes=sc.nextInt();

			ArrayList <Ingrediente> ingredientes = new ArrayList <Ingrediente> ();
			for(int i=0; i<num_ingredientes; i++) {
				Ingrediente ingre = new Ingrediente();
				cantidadGramos=-1;
				ingre.setCantidadGramos(cantidadGramos);
				cantidadUnidad=-1;
				ingre.setCantidadUnidad(cantidadUnidad);

				System.out.println("¿Cual es el nombre del Ingrediente "+(i+1)+"?");
				nombreIngrediente=sc.next();
				ingre.setNombreIngrediente(nombreIngrediente);	

				System.out.println("¿La cantidad del ingrediente es en gramos? s/n");
				char si_no = sc.next().charAt(0);
                while ((si_no!='s')&&(si_no!='n')) {
					System.out.println("Lo siento, intentalo otra vez");
					System.out.println("¿La cantidad del ingrediente es en gramos? si/no");
					si_no = sc.next().charAt(0);	
				}
				if (si_no == 's') {
					ingre.setEnGramos(true);
				}
				else if (si_no == 'n'){
					ingre.setEnGramos(false);
				}
				if (ingre.getEnGramos()) {
					System.out.println("¿Cuantos gramos de "+nombreIngrediente+" necesita la  receta?");
					cantidadGramos=sc.nextInt();
					ingre.setCantidadGramos(cantidadGramos);
				}
				else {
					System.out.println("¿Cuantas unidades de "+nombreIngrediente+" necesita la  receta?");
					cantidadUnidad=sc.nextInt();
					ingre.setCantidadUnidad(cantidadUnidad);
				}

				ingredientes.add(ingre);
			}

			System.out.println("Describe la preparacion separando cada paso por coma: batir huevos, mezclar todo y volcar en la sartén.");
			preparacion=sc.next();
			rece.setPreparacion(preparacion);
			recetas.add(rece);
			
			// Vaciar el ArrayList
			ingredientes.clear();
		}	

		File  archivo = new File ("recetario.txt");
		FileWriter escritor = new FileWriter(archivo);

		for(int k=0; k<recetas.size();k++){
			Receta recetaObtenida = recetas.get(k);
			System.out.println("Receta: "+recetaObtenida.getNombreReceta());
			String linea = recetaObtenida.getNombreReceta()+";";

			for(int l=0; l<recetaObtenida.getIngredientes.size();l++){
				linea = linea+recetaObtenida.getIngredientes.get(l).getNombreIngrediente()+"*"+recetaObtenida.getIngredientes.get(l).getCantidadGramos()+"*"+recetaObtenida.getIngredientes.get(l).getCantidadUnidad()+"*"+recetaObtenida.getIngredientes.get(l).getEnGramos();
				if (l != recetaObtenida.getIngredientes.size()-1)
				{	
					linea = linea + "#";
				}
			}
			linea = linea + ";";
			
			linea = linea + recetaObtenida.getPreparacion() + ";\n";
			escritor.append(linea);
			System.out.println("receta guardada");
		}
		escritor.close();


		FileReader fr = new FileReader("recetario.txt");
		BufferedReader br = new BufferedReader(fr); 
		String [] campos = null;
		System.out.println("\nTus recetas...");
		String s;
		while((s = br.readLine()) != null) 
		{ 
			campos = s.split(";");
			System.out.println("--------------------------------");
			System.out.println("Nombre: "+campos[0]);
			System.out.println("Descripcion: "+campos[2]);
			String ingre = campos[1];
			campos = ingre.split("#");
			for(int x=0; x<campos.length; x++){
				String ingreAtribSeparados = campos[x];
				String [] campos2 = ingreAtribSeparados.split("\\*");
				System.out.println("Ingredientes: ");
				System.out.println("Nombre: "+campos2[0]);
				System.out.println("Gramos: "+campos2[1]);
				System.out.println("Unidades: "+campos2[2]);
				System.out.println("--------------------------------");
				//System.out.println("¿En gramos?: "+campos2[3]);
			}
		}
		// Vaciar el ArrayList
		recetas.clear();
	}
}