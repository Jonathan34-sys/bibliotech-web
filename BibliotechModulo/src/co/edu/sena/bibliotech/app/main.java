package co.edu.sena.bibliotech.app;

import co.edu.sena.bibliotech.dao.UsuarioDAO;
import co.edu.sena.bibliotech.model.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuApp {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n--- Menú BibliotecaTech ---");
            System.out.println("1. Insertar usuario");
            System.out.println("2. Consultar usuario por ID");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Listar todos los usuarios");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    insertarUsuario();
                    break;
                case 2:
                    consultarUsuario();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    listarUsuarios();
                    break;
                case 6:
                    System.out.println("¡Gracias por usar BibliotecaTech!");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void insertarUsuario() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese correo: ");
        String correo = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);

        if (usuarioDAO.insertarUsuario(usuario)) {
            System.out.println("Usuario insertado correctamente.");
        } else {
            System.out.println("Error al insertar usuario.");
        }
    }

    private void consultarUsuario() {
        System.out.print("Ingrese ID del usuario a consultar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        if (usuario != null) {
            System.out.println("ID: " + usuario.getId());
            System.out.println("Nombre: " + usuario.getNombre());
            System.out.println("Correo: " + usuario.getCorreo());
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void actualizarUsuario() {
        System.out.print("Ingrese ID del usuario a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        if (usuario != null) {
            System.out.print("Nuevo nombre (" + usuario.getNombre() + "): ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo correo (" + usuario.getCorreo() + "): ");
            String correo = scanner.nextLine();

            if (!nombre.isEmpty()) usuario.setNombre(nombre);
            if (!correo.isEmpty()) usuario.setCorreo(correo);

            if (usuarioDAO.actualizarUsuario(usuario)) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("Error al actualizar usuario.");
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    private void eliminarUsuario() {
        System.out.print("Ingrese ID del usuario a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (usuarioDAO.eliminarUsuario(id)) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar usuario o usuario no existe.");
        }
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        System.out.println("\nLista de usuarios:");
        for (Usuario u : usuarios) {
            System.out.println("ID: " + u.getId() + ", Nombre: " + u.getNombre() + ", Correo: " + u.getCorreo());
        }
    }
}
