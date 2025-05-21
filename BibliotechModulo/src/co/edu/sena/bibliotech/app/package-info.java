package co.edu.sena.bibliotech.app;

import co.edu.sena.bibliotech.dao.LibroDAO;
import co.edu.sena.bibliotech.model.Libro;

import java.util.List;

public class App {
    public static void main(String[] args) {
        LibroDAO dao = new LibroDAO();

        // Insertar libro
        Libro libro = new Libro();
        libro.setTitulo("El Principito");
        libro.setAutor("Antoine de Saint-Exupéry");
        libro.setAnioPublicacion(1943);
        dao.insertarLibro(libro);

        // Listar libros
        List<Libro> libros = dao.listarLibros();
        for (Libro l : libros) {
            System.out.println(l.getId() + ": " + l.getTitulo() + " - " + l.getAutor());
        }

        // Actualizar libro (actualiza el primer libro si existe)
        if (!libros.isEmpty()) {
            Libro libroActualizar = libros.get(0);
            libroActualizar.setTitulo("El Principito (Edición Actualizada)");
            dao.actualizarLibro(libroActualizar);
        }

        // Eliminar libro (elimina el primer libro si existe)
        if (!libros.isEmpty()) {
            int idEliminar = libros.get(0).getId();
            dao.eliminarLibro(idEliminar);
        }
    }
}
