package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoAjustadoTest {
	private ProductoAjustado producto1_ajustado;
	private ProductoAjustado producto2_ajustado;
	private ProductoMenu producto1;
	private Ingrediente ingrediente1;
	private Ingrediente ingrediente2;
	@BeforeEach
	void setUp() throws Exception{
		
		producto1 = new ProductoMenu("especial", 24000);
		producto1_ajustado = new ProductoAjustado(producto1);
		producto2_ajustado = new ProductoAjustado(producto1);
		// ingredientes de prueba
		ingrediente1 = new Ingrediente("lechuga", 1000);
		ingrediente2 = new Ingrediente("pepinillos",2500);
		// para producto1_ajustado se va a agregar los ingredientes
		producto1_ajustado.agregarIngrediente(ingrediente1);
		producto1_ajustado.agregarIngrediente(ingrediente2);
		// para producto2_ajustado se va a eliminar los ingredientes
		producto2_ajustado.eliminarIngrediente(ingrediente1);
		producto2_ajustado.eliminarIngrediente(ingrediente2);
		
		
		
		
	}
	
	@AfterEach
	void tearDown() throws Exception{
	}
	@Test
	void testGetNombre() {
		assertEquals("especial",producto1_ajustado.getNombre(),"El nombre es equivocado");
		assertEquals("especial",producto2_ajustado.getNombre(),"El nombre es equivocado");
	}
	@Test
	void testGetPrecio() {
		assertEquals(producto1.getPrecio()+ingrediente1.getCostoAdicional()+ingrediente2.getCostoAdicional(),producto1_ajustado.getPrecio(),"el precio esta equivocado");
		assertEquals(producto1.getPrecio()-ingrediente1.getCostoAdicional()-ingrediente2.getCostoAdicional(),producto2_ajustado.getPrecio(),"el precio esta equivocado");
	}
	
	@Test
	void testGenerarTextoFactura() {
		
		String factura = producto1_ajustado.generarTextoFactura();
		//assertTrue(factura.contains(producto1_ajustado.getNombre()));
		ArrayList<Ingrediente> agregados = producto1_ajustado.getAgregados();
		ArrayList<Ingrediente> eliminados = producto1_ajustado.getEliminados();
		for (Ingrediente ingrediente: agregados) {
			assertTrue(factura.contains(ingrediente.getNombre()));
			String precio = String.valueOf(ingrediente.getCostoAdicional());
			assertTrue(factura.contains(precio));
		}
		for (Ingrediente ingrediente: eliminados) {
			assertTrue(factura.contains(ingrediente.getNombre()));
			String precio = String.valueOf(ingrediente.getCostoAdicional());
			assertTrue(factura.contains(precio));
		}
		
		
	}
	
}
