package controlador;

import clases.Visita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoVisita {
    private Connection cone;

    public DaoVisita() {
        cone = new Conexion().ObtenerConexion();
    }
    
    public boolean AgrregarVisita(Visita visit){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("insert into producto values(?,?,?,?)");
            st.setInt(1, visit.getNroAcceso());
            st.setString(2, visit.getNombreVisita());
            st.setBoolean(3, visit.isRecibeVisita());
            st.setInt(4, visit.getEdad());
            st.setInt(5, visit.getInterno().getCodInterno());
            int cant =st.executeUpdate();
            return cant>0;                        
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean ModificarVisita(Visita visit){
        try {
            PreparedStatement st;
            st=cone.prepareStatement("UPDATE VISITA"
                    +"SET NOMBREVISITA=?, SET RECIBEVISITA=?, SET EDAD=?,"
                    + "SET CODINTERNO=? WHERE NROACCESO=?");
            st.setInt(5, visit.getNroAcceso());
            st.setString(1, visit.getNombreVisita());
            st.setBoolean(2, visit.isRecibeVisita());
            st.setInt(3, visit.getEdad());
            st.setInt(4, visit.getInterno().getCodInterno());
            int cant=st.executeUpdate();
            return cant >0;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public boolean EliminarVisita(int nroAcceso){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("DELETE FROM VISITA WHERE NROACCESO=?");
            st.setInt(1, nroAcceso);
            int cant = st.executeUpdate();
            return cant>0;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return false;
        }
    }
    
    public Visita BuscarVisita(int nroAcceso){
        try {
            PreparedStatement st;
            st=cone.prepareStatement("SELECT * FROM VISITA WHERE NROACCESO=?");
            st.setInt(1, nroAcceso);
            ResultSet reg = st.executeQuery();
            Visita visit=null;
            while (reg.next()) {
                visit = new Visita();
                visit.setNroAcceso(reg.getInt(1));
                visit.setNombreVisita(reg.getString(2));
                visit.setRecibeVisita(reg.getBoolean(3));
                visit.setEdad(reg.getInt(4));
                visit.getInterno().setCodInterno(reg.getInt(5));
            }
            return visit;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Visita> ListaVisita(){
        try {
            PreparedStatement st;
            st = cone.prepareStatement("SELECT * FROM VISITA");
            ResultSet reg = st.executeQuery();
            ArrayList<Visita> listar_visita = new ArrayList<>();
            while (reg.next()){
                Visita visit =  new Visita();
                visit.setNroAcceso(reg.getInt(1));
                visit.setNombreVisita(reg.getString(2));
                visit.setRecibeVisita(reg.getBoolean(3));
                visit.setEdad(reg.getInt(4));
                visit.getInterno().setCodInterno(reg.getInt(5));
                listar_visita.add(visit);
            }
            return listar_visita;
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
            return null;
        }
    }
}
