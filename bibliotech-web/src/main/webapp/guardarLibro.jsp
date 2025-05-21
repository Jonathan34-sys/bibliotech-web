package com.bibliotech.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bibliotech.util.DBConnection;

@WebServlet("/guardarLibro")
public class GuardarLibroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String editorial = request.getParameter("editorial");
        int anio = Integer.parseInt(request.getParameter("anio"));

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO libros (titulo, autor, editorial, año_publicacion) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setString(3, editorial);
            stmt.setInt(4, anio);

            stmt.executeUpdate();

            response.sendRedirect("listarLibros.jsp"); // redirige a la lista luego de guardar

        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Error al guardar el libro: " + e.getMessage());
        }
    }
}
