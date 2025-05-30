package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class ProductoMenuTest {
private ProductoMenu producto1;

@BeforeEach
void setUp() throws Exception
{
	
	producto1 = new ProductoMenu("corral", 14000);
	
	
	
}

	@AfterEach 
	void tearDown () throws Exception
	{
	}	
	@Test
		void testGetNombreCorral() {
		    assertEquals("corral", producto1.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetPrecio() {
		
		    assertEquals(14000, producto1.getPrecio(), "Precio de corral incorrecto");
}
	@Test
	void testGenerarTextoFactura() {
		String facturaEsperada1 = producto1.getNombre();
		String facturaEsperada2 = Integer.toString(producto1.getPrecio());
        assertTrue(producto1.generarTextoFactura().contains(facturaEsperada2));
        assertTrue(producto1.generarTextoFactura().contains(facturaEsperada1));
		
	}
}