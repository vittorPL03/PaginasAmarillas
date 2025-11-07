package Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_usuario")
public class Detalle_Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Usuario")
    private int id_Usuario;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "correo_E")
    private String correo_E;
    @Column(name = "id_Suscripcion")
    private int id_Suscripcion;

    public Detalle_Usuario(String telefono, String correo_E, int id_Suscripcion) {
        this.telefono = telefono;
        this.correo_E = correo_E;
        this.id_Suscripcion = id_Suscripcion;
    }

    public Detalle_Usuario(){

    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo_E() {
        return correo_E;
    }

    public void setCorreo_E(String correo_E) {
        this.correo_E = correo_E;
    }

    public int getId_Suscripcion() {
        return id_Suscripcion;
    }

    public void setId_Suscripcion(int id_Suscripcion) {
        this.id_Suscripcion = id_Suscripcion;
    }



}
