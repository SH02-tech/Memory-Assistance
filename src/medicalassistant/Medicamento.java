
class Medicamento {                // Clase con visibilidad pública
    private int id;
    private String nombre;
    private String descripcion;
    private int unidades;  
    
    Medicamento(int id, String nombre, String descripcion, int unidades){  
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidades = unidades; 
    }
    
    int getId() {return id;}
    String getNombre(){return nombre;}
    String getDescripcion(){return descripcion;}
    int getUnidades() {return unidades;}
    
    public String toString(){
        return "Medicamento con ID: " + Integer.toString(id) +" nombre: "
               + nombre + " unidades: "+Integer.toString(unidades) +
                " Descripcion: " + descripcion;
    }
}