package Suscripcion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LeerSuscripcion {

    static void main(String[] args) {

        //Se inicia la sesion con las librerias correspondientes, Factory, Session y Configuration
        //Se crea un nuevo objeto de configuracion, se traen los valores del xml configurado al principio y se crea (Builda) la sesion
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Suscripcion.class)
                .buildSessionFactory();
        // Se crea un objeto de tipo configuracion factory y se abre la sesion
        Session miSesion = miFactory.openSession();


        try {

            //Iniciar la sesion con el Begin Transaction

            miSesion.beginTransaction();

            // Cunsulta de clientes
            // Se crea objeto tipo lista llamado listaSuscripcion para almacenar los datos arrojados por el query
            //Se crea la query con los metodos del Session y se le da el parametro get para que retorne los datos

            List<Suscripcion> listaSuscripcion = miSesion.createQuery("from Suscripcion").getResultList();


            //Mostrar los clientes lista con TODOS los registros ACTUALES con un metodo bucle hasta el tamaño de la lista

            mostrarLista(listaSuscripcion);


            //Consulta especifica con el query where de la tabla suscripcion
            //TENER PRECAUCION CON LA SENTENCIA POR QUE SE ESTA HACIENDO REFERENCIA A LA CLASE suscripcion
            //us: hace referencia a una variable interna del lenguaje HQL

            listaSuscripcion = miSesion.createQuery("from Suscripcion sus where sus.categoria='Gratuita'").getResultList();


            //Mostrar la consulta especifica con un metodo bucle hasta el tamaño de la lista

            //mostrarLista(listaSuscripcion);


            //OPERADORES LOGICOS: muestra los que tienen nombre Victor o apellido Pabon (se va a repetir un registro)
            //us: hace referencia a una variable interna del lenguaje HQL

            /*listaSuscripcion =miSesion.createQuery("from Suscripcion sus where sus.date='2025-11-23'"+
                    "or sus.apellido='Pabon'").getResultList();*/


            //Mostrar la consulta realizada con los operadores logicos  con un metodo bucle hasta el tamaño de la lista

            // mostrarLista(listaSuscripcion);

            //Se genera el commit o lanzamiento de los cambios generados

            miSesion.getTransaction().commit();


        }catch (Exception e){ //Se crea el catch por si ocurre algun problema saber que esta pasando

            System.out.println("Ha ocurrido un error al momento de realizar la consulta " + e);

        }finally { //Se cierran las sesiones y configuraciones abiertas por si en algun punto algo fallo

            miSesion.close();
            miFactory.close();

            System.out.println("Se ha cerrado la Sesion correctamente");
        }



    }

    //metodo que recorre una lista mediante un bucle for que va hasta la duracion de la lista
    private static void mostrarLista(List<Suscripcion> listaSuscripcion) {
        for (Suscripcion unaSuscrripcion: listaSuscripcion){
            System.out.println(unaSuscrripcion);
        }
    }
}
