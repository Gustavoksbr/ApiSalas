package me.dio.santanderapi;

import me.dio.santanderapi.domain.model.usuario.Usuario;
import me.dio.santanderapi.domain.repository.UsuarioRepository;
import me.dio.santanderapi.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class SantanderapiApplicationTests {

	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private UserServiceImpl usuarioService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testBuscarPorId() {
		Long id = 1L;
		Usuario usuario = new Usuario();
		usuario.setName("joao");

		when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

		Usuario resultado = usuarioService.findById(id);

		assertNotNull(resultado);
		assertEquals("joao", resultado.getName());
	}

	@Test
	public void testBuscarPorIdUsuarioNaoEncontrado() {
		Long id = 2L;

		when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

		Exception exception = assertThrows(RuntimeException.class, () -> {
			usuarioService.findById(id);
		});

		assertEquals("Usuário não encontrado", exception.getMessage());
	}
}
