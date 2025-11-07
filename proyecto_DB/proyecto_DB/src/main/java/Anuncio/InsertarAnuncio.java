package Anuncio;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class InsertarAnuncio {

    static void main(String[] args) {

        //Se inicia la sesion con las librerias correspondientes, Factory, Session y Configuration
        //Se crea un nuevo objeto de configuracion, se traen los valores del xml configurado al principio y se crea (Build) la sesion
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Anuncio.class)
                .buildSessionFactory();

        // Se crea un objeto de tipo configuracion factory y se abre la sesion
        Session miSesion = miFactory.openSession();


        try {

            //Se crea un nuevo objeto de clase Anuncio que pide los siguientes datos que son los mismos de la tabla SQL
            Anuncio anuncio1 = new Anuncio("Lo Mejor de Mañana",1,1,"2025-12-11");

            //Se inicia la transaccion o se abre la conexion
            miSesion.beginTransaction();

            //El metodo PERSIST sustituyo al metodo SAVE que se usaba anteriormmente pero hacen lo mismo actualmente
            //Y solo con guardar , la asosiacion anterior ya se encarga de sumar esa informacion en un solo save
            miSesion.persist(anuncio1);

            //Se genera el commit o lanzamiento de los datos insertados
            miSesion.getTransaction().commit();

            //Muestra un mensaje de confirmacion
            System.out.println("Registro insertado con exito en la base de datos");

        }catch (Exception e){ //Se crea el catch por si ocurre algun problema saber que esta pasando

            System.out.println("Ha ocurrido un problema con la operacion " + e);

        }finally { //Se cierran las sesiones y configuraciones abiertas por si en algun punto algo fallo

            miSesion.close();
            miFactory.close();

            System.out.println("Se ha cerrado la sesion correctamente!");

        }




    }

}
