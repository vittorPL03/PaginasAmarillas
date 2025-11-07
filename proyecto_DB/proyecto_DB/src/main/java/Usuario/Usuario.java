package Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Usuario")
    private int id_Usuario;
    @Column(name = "documento_Usuario")
    private int documento_Usuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;


    public Usuario(int documento_Usuario, String nombre, String apellido) {
        this.documento_Usuario = documento_Usuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Usuario(){

    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getDocumento_Usuario() {
        return documento_Usuario;
    }

    public void setDocumento_Usuario(int documento_Usuario) {
        this.documento_Usuario = documento_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Usuario")
    private Detalle_Usuario detalleUsuario;


    public Detalle_Usuario getDetalleUsuario() {
        return detalleUsuario;
    }

    public void setDetalleUsuario(Detalle_Usuario detalleUsuario) {
        this.detalleUsuario = detalleUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_Usuario=" + id_Usuario +
                ", documento_Usuario=" + documento_Usuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", detalleUsuario=" + detalleUsuario +
                '}';
    }
}
