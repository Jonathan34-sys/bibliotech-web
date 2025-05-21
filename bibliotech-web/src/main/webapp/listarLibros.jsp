<%@ page import="java.sql.*" %>
<%@ page import="com.bibliotech.util.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>
    <h2>Lista de Libros</h2>
    <a href="agregarLibro.jsp">Agregar Nuevo Libro</a><br><br>

    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor</th>
            <th>Editorial</th>
            <th>Año</th>
        </tr>

        <%
            try (Connection conn = DBConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM libros")) {

                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("titulo") %></td>
            <td><%= rs.getString("autor") %></td>
            <td><%= rs.getString("editorial") %></td>
            <td><%= rs.getInt("año_publicacion") %></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        %>
    </table>
</body>
</html>

