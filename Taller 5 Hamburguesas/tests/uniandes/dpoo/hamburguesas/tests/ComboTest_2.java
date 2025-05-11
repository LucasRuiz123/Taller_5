package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

class ComboTest_2 {
private Combo combo_1;

	@BeforeEach
	void setUp() throws Exception{
		ArrayList<ProductoMenu> productos =new ArrayList<ProductoMenu>();
		productos.add(new ProductoMenu("papas medianas", 5500));
		productos.add(new ProductoMenu("gaseosa", 5000));
		productos.add(new ProductoMenu("corral", 14000));
		combo_1 = new Combo("combo corral", 0.1,productos);
	}
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	@Test
	void testGetNombre() {
		assertEquals("combo corral", combo_1.getNombre(), "nombre incorrecto");
	}
	@Test
	void testGetPrecio() {
		int precio = (int) ((5500+5000+14000)*0.1);
		assertEquals(precio,combo_1.getPrecio(),"preci incorrecto");
	}
	
	@Test
	void testGetFactura() {
		String factura =combo_1.generarTextoFactura();
		assertTrue(factura.contains(combo_1.getNombre()));
		assertTrue(factura.contains(String.valueOf(combo_1.getPrecio())));
		
	}
	
	
	
	

}
