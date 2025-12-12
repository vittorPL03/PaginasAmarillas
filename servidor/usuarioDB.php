<?php

class usuarioDB
{
    protected $mysqli;
    const LOCALHOST = 'localhost'; // 127.0.0.1
    const USER = 'root';
    const PASSWORD = '';
    const DATABASE = 'pa_db';

    /**
     * Constructor de clase Inicializa la variable mysqli
     */
    public function __construct()
    {
        try {
            // Aquí se establece la conexión con el puerto 3308
            $this->mysqli = new mysqli(self::LOCALHOST, self::USER, self::PASSWORD, self::DATABASE, 3306);
        } catch (mysqli_sql_exception $e) {
            http_response_code(500);
            echo json_encode(["error" => "Error de conexión a la base de datos"]);
            exit;
        }
    }
    public function dameUnoPorId($id = 0)
    { //función que retorna un registro por medio de una id
        $stmt = $this->mysqli->prepare("SELECT * FROM usuario
    WHERE id=? ; "); // se prepara la consulta con prepare por medio de la conexión que tenemos
        $stmt->bind_param('i', $id); // en lugar de la interrogación, coloque el valor de la variable id
        $stmt->execute();
        $result = $stmt->get_result();
        $usuario = $result->fetch_all(MYSQLI_ASSOC);
        $stmt->close();
        return $usuario;
    }
    public function dameLista()
    {
        // Ejecuta la consulta SQL para obtener todos los registros
        $result = $this->mysqli->query('SELECT * FROM usuario');

        // Verifica si la consulta fue exitosa
        if ($result) {
            // Convierte el resultado en un array asociativo
            $usuario = $result->fetch_all(MYSQLI_ASSOC);
            $result->close();
            return $usuario;
        } else {
            // Si hay error, devuelve un array vacío
            return [];
        }
    }

    public function guarda($documento_Usuario, $nombre, $apellido)
    {
        $stmt = $this->mysqli->prepare("INSERT INTO usuario(documento_Usuario, nombre, apellido) VALUES(?, ?, ?)");
        $stmt->bind_param('iss', $documento_Usuario, $nombre, $apellido);
        $r = $stmt->execute();
        $stmt->close();
        return $r;
    }
    public function elimina($id = 0)
    { //esta función elimina un registro
        $stmt = $this->mysqli->prepare("DELETE FROM usuario
    WHERE id = ?");
        $stmt->bind_param('i', $id);
        $r = $stmt->execute();
        $stmt->close();
        return $r;
    }

    public function actualiza($id, $documento_Usuario, $nombre, $apellido)
    {
        //esta función actualiza un registro
        if ($this->verificaExistenciaPorId($id)) {
            $stmt = $this->mysqli->prepare("UPDATE usuario SET
    documento_Usuario=?, nombre=?, apellido=? WHERE id = ?");
            $stmt->bind_param(
                'issi',
                $documento_Usuario,
                $nombre,
                $apellido,
                $id
            );
            $r = $stmt->execute();
            $stmt->close();
            return $r;
        }
        return false;
    }
    public function verificaExistenciaPorId($id)
    {//esta función verifica que exista un registro por id
        $stmt = $this->mysqli->prepare("SELECT * FROM usuario
    WHERE ID=?");
        $stmt->bind_param("i", $id);
        if ($stmt->execute()) {
            $stmt->store_result();
            if ($stmt->num_rows == 1) {
                return true;
            }
        }
        return false;
    }
}