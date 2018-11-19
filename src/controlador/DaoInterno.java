package controlador;

import clases.Interno;
import clases.TipoHorarioVisita;
import clases.TipoPenal;
import clases.TipoSexo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoInterno {
    private Connection cone;

    public DaoInterno() {
       cone = new Conexion().ObtenerConexion();
    }
    
    public boolean AgregarInterno (Interno intern){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("insert into producto values(?,?,?,?,?,?)");
            st.setInt(1, intern.getCodInterno());
            st.setString(2, intern.getNombreInterno());
            st.setString(3, ""+intern.getTipoPenal());
            st.setString(4, ""+intern.gettSexo());
            st.setString(5, ""+intern.gettHorarioVisita());
            st.setString(6, intern.getObservaciones());
            int cant = st.executeUpdate();
            return cant >0;
        } catch (Exception e) { 
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean ModificarInterno (Interno intern){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("UPDATE INTERNO"
                    +"SET NOMBREINTERNO=?, SET TIPOPENAL=?, SET TSEXO=?,"
                    + "SET THORARIOVISITA=?,SET OBSERVACIONES=? WHERE CODINTERNO=?");
            st.setInt(6, intern.getCodInterno());
            st.setString(1, intern.getNombreInterno());
            st.setString(2, ""+intern.getTipoPenal());
            st.setString(3, ""+intern.gettSexo());
            st.setString(4, ""+intern.gettHorarioVisita());
            st.setString(5, intern.getObservaciones());
            int cant= st.executeUpdate();
            return cant>0;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean EliminarInterno(int codInterno){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("DELETE FROM INTERNO WHERE CODINTERNO=?");
            st.setInt(1, codInterno);
            int cant =st.executeUpdate();
            return cant>0;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public Interno BuscarInterno(int codInterno){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("SELECT * FROM INTERNO WHERE CODINTERNO=?");
            st.setInt(1, codInterno);
            ResultSet reg = st.executeQuery();
            Interno intern=null;
            while (reg.next()) {
                intern = new Interno();
                intern.setCodInterno(reg.getInt(1));
                intern.setNombreInterno(reg.getString(2));
                intern.setTipoPenal(Enum.valueOf(TipoPenal.class, reg.getString(3)));
                intern.settSexo(Enum.valueOf(TipoSexo.class, reg.getString(4)));
                intern.settHorarioVisita(Enum.valueOf(TipoHorarioVisita.class, reg.getString(5)));
                intern.setObservaciones(reg.getString(6));
               // intern.settSexo.valueOf(reg.getString(4));
            }
            return intern;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Interno> ListarInterno(){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("SELECT * FROM INTERNO");
            ResultSet reg = st.executeQuery();
            ArrayList<Interno> listar_interno = new ArrayList<>();
            
            
            
            
            while (reg.next()) {
                Interno intern = new Interno();
                intern.setCodInterno(reg.getInt(1));
                intern.setNombreInterno(reg.getString(2));
                intern.setTipoPenal(Enum.valueOf(TipoPenal.class, reg.getString(3)));
                intern.settSexo(Enum.valueOf(TipoSexo.class, reg.getString(4)));
                intern.settHorarioVisita(Enum.valueOf(TipoHorarioVisita.class, reg.getString(5)));
                intern.setObservaciones(reg.getString(6));
                listar_interno.add(intern);
            }
            return listar_interno;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
}
