package Suscripcion;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "suscripcion")
public class Suscripcion {

    @Id
    @Column(name = "id_Suscripcion")
    private int id_Suscripcion;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "fecha_Inicio")
    private Date fecha_Inicio;
    @Column(name = "vigencia")
    private Date vigencia;


    public Suscripcion(int id_Suscripcion, String categoria, Date fecha_Inicio, Date vigencia) {
        this.id_Suscripcion = id_Suscripcion;
        this.categoria = categoria;
        this.fecha_Inicio = fecha_Inicio;
        this.vigencia = vigencia;
    }

    public Suscripcion(){

    }

    public int getId_Suscripcion() {
        return id_Suscripcion;
    }

    public void setId_Suscripcion(int id_Suscripcion) {
        this.id_Suscripcion = id_Suscripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    @Override
    public String toString() {
        return "Suscripcion{" +
                "id_Suscripcion=" + id_Suscripcion +
                ", categoria='" + categoria + '\'' +
                ", fecha_Inicio=" + fecha_Inicio +
                ", vigencia=" + vigencia +
                '}';
    }
}
