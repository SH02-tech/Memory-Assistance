import java.util.Date;

class prescripcion{                // Clase con visibilidad pública
    private int id;
    private Medicamento medicamento;
    private String horaInicio;
    private int dosis;
    private int frecuencia;         //numero de horas entre el consumo de una pastilla y la siguiente 
    
    
    prescripcion(int id, Medicamento medicamento, String horaInicio, int dosis, int frecuencia){  
        this.id = id;
        this.medicamento = medicamento;
        this.horaInicio = horaInicio;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
    }
    
    int getId() {return id;}
    Medicamento getMedicamento() {return medicamento;}
    String getHoraInicio() {return horaInicio;}
    int getDosis() {return dosis;}
    int getFrecuencia() {return frecuencia;}
    
    
    public String toString(){
        return "Prescripcion con ID: " + Integer.toString(id) +" hora inicio : "
               + horaInicio + " dosis: " + Integer.toString(dosis) +
                " frecuencia: " + Integer.toString(frecuencia) + medicamento.toString();    
    }
}