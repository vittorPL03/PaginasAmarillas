package Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    private int id_Categoria;
    @Column(name = "nombre_Categoria")
    private String nombre_Categoria;

    public Categoria(int id_Categoria, String nombre_Categoria) {
        this.id_Categoria = id_Categoria;
        this.nombre_Categoria = nombre_Categoria;
    }

    public Categoria(){

    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNombre_Categoria() {
        return nombre_Categoria;
    }

    public void setNombre_Categoria(String nombre_Categoria) {
        this.nombre_Categoria = nombre_Categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_Categoria=" + id_Categoria +
                ", nombre_Categoria='" + nombre_Categoria + '\'' +
                '}';
    }
}
