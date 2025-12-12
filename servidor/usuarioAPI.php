<?php
require_once "usuarioDB.php";
class usuarioAPI
{
    public function API()
    {
        header('Content-Type: application/JSON');
        $method = $_SERVER['REQUEST_METHOD'];
        switch ($method) {
            case 'GET':
                $this->procesaListar();// son funciones creadas en la parte de abajo de este archivo
                break;
            case 'POST':
                $this->procesaGuardar();// son funciones creadas en la parte de abajo de este archivo
                break;
            case 'PUT':
                $this->procesaActualizar();// son funciones creadas en la parte de abajo de este archivo
                break;
            case 'DELETE':
                $this->procesaEliminar();// son funciones creadas en la parte de abajo de este archivo
                break;
            default:
                echo 'MÉTODO NO SOPORTADO';
                break;
        }
    }
    function response($code = 200, $status = "", $message = "")
    {
        http_response_code($code);
        if (!empty($status) && !empty($message)) {
            $response = array(
                "status" => $status
                ,
                "message" => $message
            );
            echo json_encode($response, JSON_PRETTY_PRINT);
        }
    }
    function procesaListar()
    {
        if ($_GET['action'] == 'usuario') {
            $usuarioDB = new usuarioDB();
            if (isset($_GET['id'])) {
                $response = $usuarioDB->dameUnoPorId($_GET['id']);
            } else {
                $response = $usuarioDB->dameLista();
            }
            echo json_encode($response, JSON_PRETTY_PRINT);
        } else {
            $this->response(400);
        }
    }
    function procesaGuardar()
    {
        if ($_GET['action'] == 'usuario') {
            $obj = json_decode(file_get_contents('php://input'));
            $objArr = (array) $obj;

            if (empty($objArr)) {
                $this->response(422, "error", "Nothing to add. Check json");
            } else if (isset($obj->documento_Usuario)) {
                $usuarioDB = new usuarioDB();
                $usuarioDB->guarda($obj->documento_Usuario, $obj->nombre, $obj->apellido);
                $this->response(200, "success", "new record added");
            } else {
                $this->response(422, "error", "The property is not defined");
            }
        } else {
            $this->response(400);
        }
    }
    function procesaActualizar()
    {
        if (isset($_GET['action']) && isset($_GET['id'])) {
            if ($_GET['action'] == 'usuario') {
                $obj = json_decode(file_get_contents('php://input'));
                $objArr = (array) $obj;
                if (empty($objArr)) {
                    $this->response(422, "error", "Nothing to add. Check json");
                } else if (isset($obj->documento_Usuario)) {
                    $usuarioDB = new usuarioDB();
                    $usuarioDB->actualiza(
                        $_GET['id'],
                        $obj->documento_Usuario,
                        $obj->nombre,
                        $obj->apellido
                    );
                    $this->response(200, "success", "Record updated");
                } else {
                    $this->response(422, "error", "The property is not defined");
                }
                exit;
            }
        }
        $this->response(400);
    }
    function procesaEliminar()
    {
        if (isset($_GET['action']) && isset($_GET['id'])) {
            if ($_GET['action'] == 'usuario') {
                $usuarioDB = new usuarioDB();
                $usuarioDB->elimina($_GET['id']);
                $this->response(204);
                exit;
            }
        }
        $this->response(400);
    }
}