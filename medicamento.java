
class medicamento {                // Clase con visibilidad pública
    final int unidades;  
    final String nombre;
    final String codigo;
    final prescripcion prescripcion_asociada;
    
    medicamento(int unidades, String nombre, String codigo, prescripcion prescripcion_asociada){  
        this.unidades = unidades;
        this.nombre = nombre;
        this.codigo = codigo;
        this.prescripcion_asociada = prescripcion_asociada;
    }
    
    int getunidades(){return unidades;}
    String getnombre(){return nombre;}
    String getNcodigo(){return codigo;}
    prescripcion getprescripcion(){return prescripcion_asociada;}
    
    public String toString(){
        return "Medicamento con :\ncodigo:"+codigo+"\nnombre:"+nombre+"\nunidades:"+unidades+"\nPrescripcion:"+prescripcion_asociada.toString();
    }
}