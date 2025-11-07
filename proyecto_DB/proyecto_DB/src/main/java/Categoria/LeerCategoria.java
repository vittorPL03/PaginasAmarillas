package Categoria;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LeerCategoria {
    static void main(String[] args) {

        //Se inicia la sesion con las librerias correspondientes, Factory, Session y Configuration
        //Se crea un nuevo objeto de configuracion, se traen los valores del xml configurado al principio y se crea (Builda) la sesion
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Categoria.class)
                .buildSessionFactory();

        // Se crea un objeto de tipo configuracion factory y se abre la sesion
        Session miSesion = miFactory.openSession();

        try {

            //Iniciar la sesion con el Begin Transaction

            miSesion.beginTransaction();

            // Cunsulta de categorias
            // Se crea objeto tipo lista llamado listaCategoria para almacenar los datos arrojados por el query
            //Se crea la query con los metodos del Session y se le da el parametro get para que retorne los datos
            List<Categoria> listaCategoria = miSesion.createQuery("from Categoria").getResultList();

            //Mostrar los clientes lista con TODOS los registros ACTUALES con un metodo bucle hasta el tamaño de la lista

            mostrarLista(listaCategoria);


        }catch (Exception e){ //Se crea el catch por si ocurre algun problema saber que esta pasando

            System.out.println("Ha ocurrido un error al momento de realizar la consulta " + e);

        }finally { //Se cierran las sesiones y configuraciones abiertas por si en algun punto algo fallo

            miSesion.close();
            miFactory.close();

            System.out.println("Se ha cerrado la Sesion correctamente");

        }


    }

    //metodo que recorre una lista mediante un bucle for que va hasta la duracion de la lista
    private static void mostrarLista(List<Categoria> listaCategoria) {
        for (Categoria unaCategoria : listaCategoria){
            System.out.println(unaCategoria);
        }
    }

}
