package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;

import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;

class RestauranteTest {
	private Restaurante restaurante;
	
	@BeforeEach
	void setUp() throws Exception{
		this.restaurante = new Restaurante();
	}
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	@Test
	void testIniciarPedido_CuandoNoHayPedidoEnCurso() throws Exception {
		Pedido pedidoEnCurso = new Pedido("Ale","Caracas");
		this.restaurante.setPedidoEnCurso(pedidoEnCurso);
		YaHayUnPedidoEnCursoException exception = assertThrows(
		        YaHayUnPedidoEnCursoException.class,
		        () -> restaurante.iniciarPedido("NuevoCliente", "NuevaDirección"),
		        "Debería lanzar YaHayUnPedidoEnCursoException cuando ya hay un pedido en curso"
		    );
		
		
	}
	@Test
	void get
}
