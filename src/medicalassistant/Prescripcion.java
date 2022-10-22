package medicalassistant;

class Prescripcion{                // Clase con visibilidad pública
    private int id;
    private Medicamento medicamento;
    private String horaInicio;
    private int dosis;
    private int frecuencia;         //numero de horas entre el consumo de una pastilla y la siguiente 
    
    
    Prescripcion(){  
        this.id = -1;
        this.medicamento = new Medicamento();
        this.horaInicio = "default";
        this.dosis = -1;
        this.frecuencia = -1;
    }
    
    Prescripcion(int id, Medicamento medicamento, String horaInicio, int dosis, int frecuencia){  
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
    
    void setId(int id) {this.id = id;}
    void setMedicamento(Medicamento medicamento) {this.medicamento = medicamento;}
    void setHoraInicio(String horaInicio) {this.horaInicio = horaInicio;}
    void setDosis(int dosis) {this.dosis = dosis;}
    void setFrecuencia(int frecuencia) {this.frecuencia = frecuencia;}
    
    public String toString(){
        return "Prescripcion con ID: " + Integer.toString(id) +" hora inicio : "
               + horaInicio + " dosis: " + Integer.toString(dosis) +
                " frecuencia: " + Integer.toString(frecuencia) + medicamento.toString();    
    }
}