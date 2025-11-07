package Categoria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizarCategoria {

    static void main(String[] args) {

        //Se inicia la sesion con las librerias correspondientes, Factory, Session y Configuration
        //Se crea un nuevo objeto de configuracion, se traen los valores del xml configurado al principio y se crea (Builda) la sesion
        SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Categoria.class)
                .buildSessionFactory();

        // Se crea un objeto de tipo configuracion factory y se abre la sesion
        Session miSesion = miFactory.openSession();

        try {

            // Se crea una variable que almacene el ID, PRIMARY KEY de la tabla Usuario para poder hacer la actualizacion de informacion
            int categoriaId = 1; // Cualquiera que exista

            // Se inicia la transaccion
            miSesion.beginTransaction();

            //Se crea un objeto para obtener el campo nombre almacenado en la base con el id_Usuario anterior
            Categoria miCategoria = miSesion.getReference(Categoria.class, categoriaId);

            // Se genera el set para el cambio del nombre, pero se puede hacer con cualquiera de los demas campos, menos
            //el ID por que es un valor generado automaticamente y no se puede cambiar manual
            miCategoria.setNombre_Categoria("Cafeterias");


            //Se genera una query con UPDATE y set para cambiar informacion existente
            //El LIKE es totalmente prescindible solo cuando se sabe por completo el dato almacenado
            //el . EXECUTE UPDATE manda la actualizacion al SQL

            // miSesion.createQuery("update Categoria set nombre_Categoria='Tiendas' where nombre_Categoria LIKE 'P%'").executeUpdate();


            //ES el mismo proceso para el DELETE solo tener mucho cuidado con el WHERE por que sin el se eliminan todos los registros

            // miSesion.createQuery("delete Categoria where nombre_Categoria = 'Cafeterias'").executeUpdate();


            //Se genera la actualizacion o el commit de los cammbios realizados
            miSesion.beginTransaction().commit();

            System.out.println("Registro actualizado con exito! ");


        }catch (Exception e){ //Se crea el catch por si ocurre algun problema saber que esta pasando

            System.out.println("Ha ocurrido un error en la actualizacion "+ e);

        }finally { //Se cierran las sesiones y configuraciones abiertas por si en algun punto algo fallo

            miSesion.close();
            miFactory.close();

            System.out.println("Se ha cerrado la sesion correctamente ");

        }



    }


}
