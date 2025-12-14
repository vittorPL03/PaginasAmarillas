const API_URL = "http://localhost/paginasamarillas/api/";
//Material utilizado de los elementos dados por eñ instructor

/*En esta api se estan realizando dos operaciones necesarias para el correcto funcionamiento de la pagina las cuales 
son el login y registro de usuario, estos funcionan de la siguiente manera */


export default {

  /*Login solicita los parametros email y password para realizar el envio de los datos al login.php con el metodo POST de SQL y envia un JSON
  con los datos obtenidos en el login que esta enlazado con la page Ingreso */
  login: async (email, password) => {
    const res = await fetch(API_URL + "login.php", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ email, password })
    });
    return await res.json();
  },

  /*Registro solocita varios parametros y realiza la misma operacion de POST a base de datos enlazada con REGISTER.php y genera el JSON que
  sera enviado */
  register: async (data) => {
    const res = await fetch(API_URL + "register.php", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
    });
    return await res.json();
  }
};
