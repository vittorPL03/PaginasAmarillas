<?php
require_once "rutas.php";
$rutas = new rutas();
$id = $_GET['id'];

// Obtener el registro actual
$url = $rutas->dameUrlBase().'/servidor/index.php?action=usuario&id='.$id;
$json = file_get_contents($url);
$registro = json_decode($json, true);

// Validar que se obtuvo el registro
if (!is_array($registro) || count($registro) === 0) {
    echo "<p>Error: No se pudo obtener el registro con ID $id.</p>";
    $registro = [[]]; // Para evitar errores en el formulario
}

// Si se envió el formulario, actualizar el registro
if (isset($_POST['documento_Usuario'])) {
    $url = $rutas->dameUrlBase().'/servidor/index.php?action=usuario&id='.$id;
    $data = array(
        'documento_Usuario' => $_POST['documento_Usuario'],
        'nombre' => $_POST['nombre'],
        'apellido' => $_POST['apellido']
    );
    $postdata = json_encode($data);

    $ch = curl_init($url);
    curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "PUT");
    curl_setopt($ch, CURLOPT_POSTFIELDS, $postdata);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json'));
    $result = curl_exec($ch);
    curl_close($ch);

    echo "<p>Registro modificado correctamente.</p>";
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modificar tarea</title>
</head>
<body>
    <?php echo $rutas->dameMenuInicio()."&nbsp;&nbsp;&nbsp;&nbsp;".$rutas->dameMenuNuevo(); ?>
    <br>

    <?php if (!isset($_POST['documento_Usuario'])): ?>
        <form method="post" id="form1">
            <label for="documento_Usuario">Documento Usuario:</label><br>
            <input type="text" id="documento_Usuario" name="documento_Usuario" value="<?php echo $registro[0]['documento_Usuario']; ?>"><br>

            <label for="nombre">Nombre:</label><br>
            <input type="text" id="nombre" name="nombre" value="<?php echo $registro[0]['nombre']; ?>"><br>

            <label for="apellido">apellido:</label><br>
            <input type="text" id="apellido" name="apellido" value="<?php echo $registro[0]['apellido']; ?>"><br>

            <button type="submit" form="form1">Guardar</button>
        </form>
    <?php endif; ?>
</body>
</html>