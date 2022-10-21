import java.util.Date;

class prescripcion{                // Clase con visibilidad pública
    final String codigo;
    final java.util.Date fecha;
    final String codigo_med;
    final int dosis;
    final int frecuencia;         //numero de horas entre el consumo de una pastilla y la siguiente 
    
    
    prescripcion(String codigo, java.util.Date fecha, String codigo_med, int dosis, int frecuencia){  
        this.codigo = codigo;
        this.fecha = fecha;
        this.codigo_med = codigo_med;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
    }
    
    String getcodigo(){return codigo;}
    java.util.Date getfecha(){return fecha;}
    String getcodigo_med(){return codigo_med;}
    int getdosis(){return dosis;}
    int frecuencia(){return frecuencia;}
    
    
    public String toString(){
        return "Prescripción con :\ncodigo:"+codigo+"\nfecha:"+fecha.toString()+"\ncodigo de medicamento asociado:"+codigo_med+"\ndosis:"+dosis+"\nfrecuencia:"+frecuencia;
    }
}