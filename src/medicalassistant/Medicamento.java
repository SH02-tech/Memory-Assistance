package medicalassistant;
class Medicamento {                // Clase con visibilidad pública
    private int id;
    private String nombre;
    private String descripcion;
    private int unidades;  
    
    Medicamento(){  
        this.id = -1;
        this.nombre = "default";
        this.descripcion = "default";
        this.unidades = -1; 
    }
    
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
    
    void setId(int id) {this.id = id;}
    void setNombre(String nombre){this.nombre = nombre;}
    void setDescripcion(String descripcion){this.descripcion = descripcion;}
    void setUnidades(int unidades) {this.unidades = unidades;}
    
    public String toString(){
        return "Medicamento con ID: " + Integer.toString(id) +" nombre: "
               + nombre + " unidades: "+Integer.toString(unidades) +
                " Descripcion: " + descripcion;
    }
}