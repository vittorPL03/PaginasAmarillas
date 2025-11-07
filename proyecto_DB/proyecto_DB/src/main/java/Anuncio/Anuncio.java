package Anuncio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "anuncio")
public class Anuncio {

    @Id
    @Column(name = "id_Anuncio")
    private int id_Anuncio;
    @Column(name = "titulo_Anuncio")
    private String titulo_Anuncio;
    @Column(name = "id_Categoria")
    private int categoria;
    @Column(name = "id_Comercio")
    private int comercio;
    @Column(name = "fecha_Publicacion")
    private String fecha_Publicacion;

    public Anuncio(String titulo_Anuncio, int categoria, int comercio, String fecha_Publicacion) {
        this.titulo_Anuncio = titulo_Anuncio;
        this.categoria = categoria;
        this.comercio = comercio;
        this.fecha_Publicacion = fecha_Publicacion;
    }

    public Anuncio(){

    }

    public int getId_Anuncio() {
        return id_Anuncio;
    }

    public void setId_Anuncio(int id_Anuncio) {
        this.id_Anuncio = id_Anuncio;
    }

    public String getTitulo_Anuncio() {
        return titulo_Anuncio;
    }

    public void setTitulo_Anuncio(String titulo_Anuncio) {
        this.titulo_Anuncio = titulo_Anuncio;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getComercio() {
        return comercio;
    }

    public void setComercio(int comercio) {
        this.comercio = comercio;
    }

    public String  getFecha_Publicacion() {
        return fecha_Publicacion;
    }

    public void setFecha_Publicacion(String fecha_Publicacion) {
        this.fecha_Publicacion = fecha_Publicacion;
    }

    @Override
    public String toString() {
        return "Anuncio{" +
                "id_Anuncio=" + id_Anuncio +
                ", titulo_Anuncio='" + titulo_Anuncio + '\'' +
                ", categoria=" + categoria +
                ", comercio=" + comercio +
                ", fecha_Publicacion='" + fecha_Publicacion + '\'' +
                '}';
    }
}
