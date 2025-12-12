<?php
require_once "rutas.php";
$rutas = new rutas();
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo registro</title>
</head>
<body>
    <?php echo $rutas->dameMenuInicio()."&nbsp;&nbsp;&nbsp;&nbsp;".$rutas->dameMenuNuevo(); ?>
    <br>

    <?php
    if (!isset($_POST['documento_Usuario'])) {
        echo '<form action="" method="post" id="form1">
            <label for="documento_Usuario">Documento Usuario::</label><br>
            <input type="number" id="documento_Usuario" name="documento_Usuario"><br>

            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre"><br>

            <label for="apellido">Apellido:</label><br>
            <input type="text" id="apellido" name="apellido"><br>

            <button type="submit" form="form1">Guardar</button>
        </form>';
    } else {
        // Solo se ejecuta una vez al enviar el formulario
        $url = $rutas->dameUrlBase().'/servidor/index.php?action=usuario';
        $data = array(
            'documento_Usuario' => $_POST['documento_Usuario'],
            'nombre' => $_POST['nombre'],
            'apellido' => $_POST['apellido']
        );
        $postdata = json_encode($data);

        $ch = curl_init($url);
        curl_setopt($ch, CURLOPT_POST, 1);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $postdata);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
        $result = curl_exec($ch);
        curl_close($ch);

        echo "<p>Registro guardado</p>";
        echo "<pre>Respuesta del servidor:\n" . $result . "</pre>";
    }
    ?>
</body>
</html>