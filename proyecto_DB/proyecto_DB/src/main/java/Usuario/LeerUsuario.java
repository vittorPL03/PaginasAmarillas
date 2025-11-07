package Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class LeerUsuario {

    static void main(String[] args) {

        //Se inicia la sesion con las librerias correspondientes, Factory, Session y Configuration
        //Se crea un nuevo objeto de configuracion, se traen los valores del xml configurado al principio y se crea (Builda) la sesion
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Usuario.class)
                .buildSessionFactory();

        // Se crea un objeto de tipo configuracion factory y se abre la sesion
        Session miSesion = miFactory.openSession();

        try {

            //Iniciar la sesion con el Begin Transaction

            miSesion.beginTransaction();

            // Cunsulta de clientes
            // Se crea objeto tipo lista llamado listaUsuarios para almacenar los datos arrojados por el query
            //Se crea la query con los metodos del Session y se le da el parametro get para que retorne los datos
            List<Usuario> listaUsuarios = miSesion.createQuery("from Usuario").getResultList();


            //Mostrar los clientes lista con TODOS los registros ACTUALES con un metodo bucle hasta el tamaño de la lista

            mostrarLista(listaUsuarios);


            //Consulta especifica con el query where de la tabla usuario
            //TENER PRECAUCION CON LA SENTENCIA POR QUE SE ESTA HACIENDO REFERENCIA A LA CLASE USUARIO
            //us: hace referencia a una variable interna del lenguaje HQL

            listaUsuarios = miSesion.createQuery("from Usuario us where us.apellido='Ramirez'").getResultList();


            //Mostrar la consulta especifica con un metodo bucle hasta el tamaño de la lista

            mostrarLista(listaUsuarios);


            //OPERADORES LOGICOS: muestra los que tienen nombre Victor o apellido Pabon (se va a repetir un registro)
            //us: hace referencia a una variable interna del lenguaje HQL

            /*listaUsuarios=miSesion.createQuery("from Usuario us where us.nombre='Victor'"+
                    "or us.apellido='Pabon'").getResultList();*/


            //Mostrar la consulta realizada con los operadores logicos  con un metodo bucle hasta el tamaño de la lista
            mostrarLista(listaUsuarios);

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
    private static void mostrarLista(List<Usuario> listaUsuarios) {
        for (Usuario unUsuario: listaUsuarios){
            System.out.println(unUsuario);
        }
    }

}
