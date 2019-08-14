
package mx.com.ridescom.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mx.com.ridescom.config.Conexion;

/**
 *
 * @author spy51
 */
public class EventoDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    PreparedStatement psp;
    ResultSet rsp;
    int r;
    
        public List listar(){
//            String sqle="SELECT ev.Evento_ID, ev.Nombre_Evento, d.Disciplina, ev.Fecha_inicio_Registro, ev.Fecha_fin_Registro, ev.Lugar_del_evento, ev.Dirección, ev.P_Referencia, ev.Descripcion, ev.Fecha_Evento, ci.Ciclo_escolar  FROM evento AS ev" +
//"	INNER JOIN (ciclo ci, act_deportiva d) ON ev.Ciclo_ID_Ciclo = ci.ID_Ciclo AND ev.Act_Deportiva_ID_Deporte = d.ID_Deporte";
String sqle="SELECT ev.Nombre_Evento, d.Disciplina, ev.Fecha_inicio_Registro, ev.Fecha_fin_Registro, ev.Lugar_del_evento, ev.Dirección, ev.P_Referencia, ev.Descripcion, ev.Fecha_Evento, ci.Ciclo_escolar  FROM evento AS ev" +
"	INNER JOIN (ciclo ci, act_deportiva d) ON (ev.Ciclo_ID_Ciclo = ci.ID_Ciclo AND ev.Act_Deportiva_ID_Deporte = d.ID_Deporte)";
            List<Evento>lista=new ArrayList<>();
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sqle);
            rs=ps.executeQuery();

            while(rs.next()){
                Evento ev=new Evento();
                
//                ev.setID(rs.getInt(1));
                ev.setNombre_e(rs.getString(1));
                ev.setDeporte(rs.getString(2));
                ev.setFecha_i_R(rs.getString(3));
                ev.setFecha_f_R(rs.getString(4));
                ev.setLugar(rs.getString(5));
                ev.setDir(rs.getString(6));
                ev.setDescripción(rs.getString(7));
                ev.setFecha_evento(rs.getString(8));
                ev.setCiclo(rs.getString(9));
                lista.add(ev);
            }
        }catch(Exception e){
        }
            
        return lista;
        }
        public int agregar(Evento e){
            String sqlev="insert into Evento(Nombre_Evento, Fecha_inicio_Registro, Fecha_fin_Registro, Lugar_del_evento, Dirección, P_Referencia, Descripcion, Fecha_Evento, Ciclo_ID_Ciclo, Act_Deportive_ID_Deporte)values(?,?,?,?,?,?,?,?,?,?)";
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sqlev);
            ps.setString(1, e.getNombre_e());
            ps.setString(2, e.getFecha_i_R());
            ps.setString(3, e.getFecha_f_R());
            ps.setString(4, e.getLugar());
            ps.setString(5, e.getDir());
            ps.setString(6, e.getP_ref());
            ps.setString(7, e.getDescripción());
            ps.setString(8, e.getFecha_evento());
            ps.setString(9, e.getCiclo());
            ps.setString(10, e.getDeporte());
            ps.executeUpdate();
            }catch (Exception ex){
            }
            return r;
        }
        
        public  Evento ListarId(int id){
            Evento ev=new Evento();
            String sql="select * from Evento where Evento_ID="+id;
            try{
                con=cn.Conexion();
                ps=con.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                ev.setNombre_e(rs.getString(2));
                ev.setFecha_i_R(rs.getString(3));
                ev.setFecha_f_R(rs.getString(4));
                ev.setLugar(rs.getString(5));
                ev.setDir(rs.getString(6));
                ev.setDescripción(rs.getString(7));
                ev.setFecha_evento(rs.getString(8));
                ev.setCiclo(rs.getString(9));
                ev.setDeporte(rs.getString(10));
                }
            }catch (Exception ex){
            }
            return ev;
        }
        
        public int actualizar(Evento e){
            String sqlev="update Evento set Nombre_Evento=?, Fecha_inicio_Registro=?, Fecha_fin_Registro=?, Lugar_del_evento=?, Dirección=?, P_Referencia=?, Descripcion=?, Fecha_Evento=?, Ciclo_ID_Ciclo=?, Act_Deportive_ID_Deporte=? where Evento_ID=?";
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sqlev);
            ps.setString(1, e.getNombre_e());
            ps.setString(2, e.getFecha_i_R());
            ps.setString(3, e.getFecha_f_R());
            ps.setString(4, e.getLugar());
            ps.setString(5, e.getDir());
            ps.setString(6, e.getP_ref());
            ps.setString(7, e.getDescripción());
            ps.setString(8, e.getFecha_evento());
            ps.setString(9, e.getCiclo());
            ps.setString(10, e.getDeporte());
            ps.setInt(11, e.getID());
            ps.executeUpdate();
            }catch (Exception ex){
            }
            return r;
        }
        public void delete(int id){
            String sql="delete from Evento where Evento_ID="+id;
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.executeQuery();
            
            }catch (Exception ex){
            }
        }
}
