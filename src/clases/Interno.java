package clases;

public class Interno {
    private int codInterno;
    private String nombreInterno, observaciones;
    private TipoPenal tipoPenal;
    private TipoSexo tSexo;
    private TipoHorarioVisita tHorarioVisita;

    public Interno(int codInterno, String nombreInterno, String observaciones, TipoPenal tipoPenal, TipoSexo tSexo, TipoHorarioVisita tHorarioVisita) {
        this.codInterno = codInterno;
        this.nombreInterno = nombreInterno;
        this.observaciones = observaciones;
        this.tipoPenal = tipoPenal;
        this.tSexo = tSexo;
        this.tHorarioVisita = tHorarioVisita;
    }

    public Interno() {
    }

    public int getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(int codInterno) {
        this.codInterno = codInterno;
    }


    public String getNombreInterno() {
        return nombreInterno;
    }

    public void setNombreInterno(String nombreInterno) {
        this.nombreInterno = nombreInterno;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TipoPenal getTipoPenal() {
        return tipoPenal;
    }

    public void setTipoPenal(TipoPenal tipoPenal) {
        this.tipoPenal = tipoPenal;
    }

    public TipoSexo gettSexo() {
        return tSexo;
    }

    public void settSexo(TipoSexo tSexo) {
        this.tSexo = tSexo;
    }

    public TipoHorarioVisita gettHorarioVisita() {
        return tHorarioVisita;
    }

    public void settHorarioVisita(TipoHorarioVisita tHorarioVisita) {
        this.tHorarioVisita = tHorarioVisita;
    }
    
    
}
