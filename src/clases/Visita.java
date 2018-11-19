package clases;

public class Visita {
    private int nroAcceso, edad;
    private String nombreVisita;
    private boolean recibeVisita;
    private Interno interno;
    private int minVisita;

    public Visita() {
    }

    public Visita(int nroAcceso, int edad, String nombreVisita, boolean recibeVisita, Interno interno, int minVisita) {
        this.nroAcceso = nroAcceso;
        setEdad(edad);
        setNombreVisita(nombreVisita);
        this.recibeVisita = recibeVisita;
        this.interno = interno;
        this.minVisita = minVisita;
    }

    public int getMinVisita() {
        return minVisita;
    }

    public void setMinVisita(int minVisita) {
        this.minVisita = minVisita;
    }


    public int getNroAcceso() {
        return nroAcceso;
    }

    public void setNroAcceso(int nroAcceso) {
        this.nroAcceso = nroAcceso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad<18 && edad>60) {
            this.edad= edad;
        } else {
            throw new IllegalArgumentException("Edad debe ser entre 18 y 60");
        } 
    }

    public String getNombreVisita() {
        return nombreVisita;
    }

    public void setNombreVisita(String nombreVisita) {
        if (nombreVisita.trim().length()>3) {
            this.nombreVisita = nombreVisita;
        } else {
            throw new IllegalArgumentException("Nombre debe ser mas de 3 caracteres");
        }
    }

    public boolean isRecibeVisita() {
        return recibeVisita;
    }

    public void setRecibeVisita(boolean recibeVisita) {
        this.recibeVisita = recibeVisita;
    }

    public Interno getInterno() {
        return interno;
    }

    public void setInterno(Interno interno) {
        this.interno = interno;
    }
    
    
}
