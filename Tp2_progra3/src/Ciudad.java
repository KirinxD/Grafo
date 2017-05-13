import java.util.ArrayList;
import java.util.List;

public class Ciudad {
    String name;
    List<Ruta> Rutas = new ArrayList<Ruta>();
    
    Ciudad (String name){
            this.name = name;
    }
    @Override
    public String toString() {
            return name;
    }
}
