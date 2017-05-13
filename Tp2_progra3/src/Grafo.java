import java.util.ArrayList;

public class Grafo {
	ArrayList<Ciudad> mapa;
	Camino CaminOptimo = null;

	Grafo() {
		mapa = new ArrayList<Ciudad>();
	}

	private boolean indexout(int i) {
		return i < mapa.size() && i >= 0;
	}

	public Ciudad getciudad(int i) {
		if (!indexout(i)) {
			exception("El Numero ingresado es erroneo");
		}
		return mapa.get(i);
	}

	public void addcuidad(String nombre) {
		mapa.add(new Ciudad(nombre));
	}

	private void exception(String exc) {
		throw new IndexOutOfBoundsException(exc);
	}

	// public void addarista(boolean peaje, String firstNode, String secondNode)
	// {
	// //Corrobora que los enteros esten entre 0 y el size de mapa
	// if ((firstNode < mapa.size() && firstNode > 0) && (secondNode <
	// mapa.size() && secondNode > 0)) {
	// new Edge(peaje, mapa.get(firstNode), mapa.get(secondNode));
	// }else{
	// exception("El Numero ingresado es erroneo");
	// }
	// }

	public void addarista(boolean peaje, int firstNode, int secondNode) {
		//* Corrobora que los enteros esten entre 0 y el size de mapa
		if (indexout(firstNode) && indexout(secondNode)) {
			new Ruta(peaje, mapa.get(firstNode), mapa.get(secondNode));
		} else {
			exception("El Numero ingresado es erroneo");
		}
	}

	private int cantpeajes() {
		int x = 0;
		for (Ruta e : CaminOptimo.Rutas) {
			x += e.Longitud;
		}
		return x;
	}

	public void CaminoMinimo(int Desde, int Hasta, int peajes) {
		if (indexout(Desde) && indexout(Hasta)) {
			CaminoMinimo(mapa.get(Desde), mapa.get(Hasta), null);
			if (peajes < cantpeajes())
				CaminOptimo = new Camino();
		}
	}

	private void CaminoMinimo(Ciudad Desde, Ciudad Hasta, Camino camino) {
		for (Ruta ruta : Desde.Rutas) {
			Camino nuevoCamino = new Camino();
			if (camino != null) {
				if (camino.Rutas.contains(ruta)) {
					continue;
				}
				nuevoCamino.Rutas.addAll(camino.Rutas);
				nuevoCamino.Longitud += camino.Longitud;
			}
			nuevoCamino.Rutas.add(ruta);
			nuevoCamino.Longitud += ruta.Longitud;
			if (ruta.PrimerCiudad.name.equals(Hasta.name) || ruta.SegundaCiudad.name.equals(Hasta.name)) {
				if (CaminOptimo == null || CaminOptimo.Longitud > nuevoCamino.Longitud) {
					CaminOptimo = nuevoCamino;
				}
				return;
			}
			Ciudad NuevoDesde = ruta.PrimerCiudad.name.equals(Desde.name) ? ruta.SegundaCiudad : ruta.PrimerCiudad;
			CaminoMinimo(NuevoDesde, Hasta, nuevoCamino);
		}
	}

	public static void main(String[] args) {

	}

}
