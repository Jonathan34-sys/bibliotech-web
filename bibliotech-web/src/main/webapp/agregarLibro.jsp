<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Libro</title>
</head>
<body>
    <h2>Formulario para agregar libro</h2>
    <form action="guardarLibro" method="post">
        <label>Título:</label>
        <input type="text" name="titulo" required><br>
        <label>Autor:</label>
        <input type="text" name="autor" required><br>
        <label>Editorial:</label>
        <input type="text" name="editorial" required><br>
        <label>Año de publicación:</label>
        <input type="number" name="anio" required><br><br>
        <button type="submit">Guardar Libro</button>
    </form>
</body>
</html>
