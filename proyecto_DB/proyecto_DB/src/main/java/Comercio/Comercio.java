package Comercio;

import jakarta.persistence.*;

@Entity
@Table(name = "comercio")
public class Comercio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Comercio")
    private int id_Comercio;
    @Column(name = "nombre_Comercio")
    private String nombre_Comercio;

    public Comercio(String nombre_Comercio) {
        this.nombre_Comercio = nombre_Comercio;
    }

    public Comercio(){

    }

    public int getId_Comercio() {
        return id_Comercio;
    }

    public void setId_Comercio(int id_Comercio) {
        this.id_Comercio = id_Comercio;
    }

    public String getNombre_Comercio() {
        return nombre_Comercio;
    }

    public void setNombre_Comercio(String nombre_Comercio) {
        this.nombre_Comercio = nombre_Comercio;
    }

    @Override
    public String toString() {
        return "Comercio{" +
                "id_Comercio=" + id_Comercio +
                ", nombre_Comercio='" + nombre_Comercio + '\'' +
                '}';
    }
}
