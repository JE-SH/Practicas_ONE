package med.voll.api.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // el objeto que va a manejar y la llave primaria
}
