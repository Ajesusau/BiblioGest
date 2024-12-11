package TestDAO;

import bibliogest.Usuario;
import bibliogest.dao.UsuarioDAO;
import org.junit.*;
import java.util.List;

/**
 *
 * @author ajesusau
 */
public class UsuariosDAOTest {

    private UsuarioDAO usuarioDAO;

    @Before
    public void configurarPrueba() {
        usuarioDAO = new UsuarioDAO();
    }

    @After
    public void limpiarPrueba() throws Exception {
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                usuarioDAO.deleteUsuario(usuario.getIdUsuario());
            }
        }
    }

    @Test
    public void testCrearUsuario() throws Exception {
        Usuario usuario = new Usuario(0, "juan", "1234", "juan@ejemplo.com", "usuario", null);
        usuarioDAO.addUsuario(usuario);
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        Assert.assertNotNull(usuarios);
        Assert.assertEquals(1, usuarios.size());
        Assert.assertEquals("juan", usuarios.get(0).getUsuario());
        Assert.assertEquals("juan@ejemplo.com", usuarios.get(0).getEmail());
        Assert.assertEquals("usuario", usuarios.get(0).getTipoUsuario());
    }

    @Test
    public void testActualizarUsuario() throws Exception {
        Usuario usuario = new Usuario(0, "juan", "1234", "juan@ejemplo.com", "usuario", null);
        usuarioDAO.addUsuario(usuario);
        usuario = usuarioDAO.getUsuarios().get(0);
        usuario.setEmail("juan.actualizado@ejemplo.com");
        usuarioDAO.updateUsuario(usuario);
        Usuario updatedUsuario = usuarioDAO.getUsuarioById(usuario.getIdUsuario());
        Assert.assertNotNull(updatedUsuario);
        Assert.assertEquals("juan.actualizado@ejemplo.com", updatedUsuario.getEmail());
    }

    @Test
    public void testEliminarUsuario() throws Exception {
        Usuario usuario = new Usuario(0, "juan", "1234", "juan@ejemplo.com", "usuario", null);
        usuarioDAO.addUsuario(usuario);
        usuario = usuarioDAO.getUsuarios().get(0);
        usuarioDAO.deleteUsuario(usuario.getIdUsuario());
        List<Usuario> usuarios = usuarioDAO.getUsuarios();
        Assert.assertNotNull(usuarios);
        Assert.assertTrue(usuarios.isEmpty());
    }

    @Test
    public void testValidarLogin() throws Exception {
        Usuario usuario = new Usuario(0, "juan", "1234", "juan@ejemplo.com", "usuario", null);
        usuarioDAO.addUsuario(usuario);
        boolean loginValido = usuarioDAO.validarLogin("juan", "1234");
        boolean loginInvalido = usuarioDAO.validarLogin("juan", "incorrecta");
        Assert.assertTrue(loginValido);
        Assert.assertFalse(loginInvalido);
    }
}
