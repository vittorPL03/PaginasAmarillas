package Suscripcion;

import Usuario.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InsertarSuscripcion {


    static void main(String[] args) {
        //Se inicia la sesion con las librerias correspondientes, Factory, Session y Configuration
        //Se crea un nuevo objeto de configuracion, se traen los valores del xml configurado al principio y se crea (Build) la sesion
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Suscripcion.class)
                .buildSessionFactory();

        // Se crea un objeto de tipo configuracion factory y se abre la sesion
        Session miSesion = miFactory.openSession();

        try {

            //Se genera un objeto de tipo suscripcion que solicita los datos para la creacion de una nueva columna
            Suscripcion suscripcion1 = new Suscripcion(1,"Gratuita",null,null);

            //Se inicia la transaccion o se abre la sesion
            miSesion.beginTransaction();

            //Se ingresa el save del objeto generado
            miSesion.persist(suscripcion1);

            //Se genera el lanzamiento o commit del objeto a la base
            miSesion.getTransaction().commit();

            System.out.println("Datos ingresados de manera correcta");

        }catch (Exception e){ //Se crea el catch por si ocurre algun problema saber que esta pasando
            System.out.println("Ha ocurrido un problema con la operacion " + e);

        }finally { //Se cierran las sesiones y configuraciones abiertas por si en algun punto algo fallo
            miSesion.close();
            miFactory.close();

            System.out.println("Se ha cerrado la sesion correctamente!");

        }
    }

}
