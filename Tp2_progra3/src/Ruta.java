
public class Ruta {
    int Longitud; 
    Ciudad PrimerCiudad;
    Ciudad SegundaCiudad;
    int peaje;
    
    Ruta (boolean peaje, Ciudad firstNode,Ciudad secondNode){
    	if(peaje){
            this.Longitud = 1;
    	}else{
    		this.Longitud = 0;
    	}
            this.PrimerCiudad = firstNode;
            this.SegundaCiudad = secondNode;
            firstNode.Rutas.add(this);
            secondNode.Rutas.add(this);
            
    }
    
    @Override
    public String toString(){  	
        return PrimerCiudad + " to " + SegundaCiudad;
    }
}
