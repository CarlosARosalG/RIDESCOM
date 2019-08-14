
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
public class UsuarioDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    PreparedStatement psp;
    ResultSet rsp;
    
    public Usuario validar(String usuario, String pass){
        Usuario us=new Usuario();
        Persona p=new Persona();
        String sql="select Nombre_U, Password_U from usuario where Nombre_U=? and Password_U=?";
//        String sql1="select Nombre, Ap_Pat, Ap_Mat from Persona where Usuario_Usuario_ID=select Usuario_ID from usuario where Nombre_U=? and Password_U=?";
        try{
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
//            psp=con.prepareStatement(sql1);
            ps.setString(1, usuario);
            ps.setString(2, pass);
//            psp.setString(1, usuario);
//            psp.setString(2, pass);
            rs=ps.executeQuery();
//            rsp=psp.executeQuery();
            
//            p.getNombre();
            while(rs.next()){
//                us.setID(rs.getInt("Usuario_ID"));
                us.setUsuario(rs.getString("Nombre_U"));
                us.setPass(rs.getString("Password_U"));

//                p.getNombre();
                
            }
        }catch(Exception e){
        }
        
        return us;
    }
    //Operaciones CRUD
        public List listar(){
            String sqlc="select u.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, ts.Sexo, p.CURP, DATE_FORMAT(Fecha_Nac, %d/%m/%Y)AS p.Fecha_Nac, p.NSS, c.Persona_ID_Persona.Nombre, c.Tipo_Contacto_ID_Tipo_Contacto.Nombre, c.Valor from Persona p, Contacto c, Tipo_Sexo ts, Usuario u, Tipo_Contacto tc"
                    + " join (p,c,ts,u)on (p.Usuario_Usuario_ID=u.Usuario_ID AND p.Tipo_Sexo_ID_Tipo_Sexo=ts.ID_Tipo_Sexo AND c.Persona_ID_Persona=p.ID_Persona AND c.Tipo_Contacto_ID_Tipo_Contacto=tc.ID_Tipo_Contacto)";
//            String sql="select Usuario.Nombre_U, p.Nombre, p.Ap_Pat, p.Ap_Mat, Tipo_Sexo.Sexo, p.CURP, DATE_FORMAT(Fecha_Nac, %d/%m/%Y)AS p.Fecha_Nac, p.NSS, c.Persona_ID_Persona, c.Tipo_Contacto_ID_Tipo_Contacto, c.Valor from Persona p, Contacto c"
//                + "inner join (Usuario,Tipo_Sexo) on (Persona.Usuario_Usuario_ID=Usuario.Usuario_ID AND Persona.Tipo_Sexo_ID_Tipo_Sexo=Tipo_Sexo.ID_Tipo_Sexo)";
            List<Persona>lista=new ArrayList<>();
            try{
            con=cn.Conexion();
            ps=con.prepareStatement(sqlc);
            rs=ps.executeQuery();

            while(rs.next()){
                Persona p=new Persona();
                Contacto c=new Contacto();
                p.setID(rs.getInt(1));
                p.setIDU(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setAppat(rs.getString(4));
                p.setApmat(rs.getString(5));
                p.setSexo(rs.getString(6));
                p.setCURP(rs.getString(7));
                p.setNSS(rs.getString(8));
                c.setTipo(rs.getString(9));
            }
        }catch(Exception e){
        }
            
        return lista;
        }
//        public int agregar(Usuario u){
//            
//        }
//        public int actualizar(Usuario u){
//            
//        }
//        public void delete(int id){
//            
//        }
}
