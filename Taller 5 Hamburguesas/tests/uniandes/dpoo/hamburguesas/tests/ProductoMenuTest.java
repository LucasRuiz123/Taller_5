package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;


public class ProductoMenuTest {
private ProductoMenu producto1;
private ProductoMenu producto2;
private ProductoMenu producto3;
private ProductoMenu producto4;
private ProductoMenu producto5; 
private ProductoMenu producto6 ;
private ProductoMenu producto7 ;
private ProductoMenu producto8 ;
private ProductoMenu producto9;
private ProductoMenu producto10; 
private ProductoMenu producto11 ;
private ProductoMenu producto12 ;
private ProductoMenu producto13;
private ProductoMenu producto14 ;
private ProductoMenu producto15 ;
private ProductoMenu producto16;
private ProductoMenu producto17;
private ProductoMenu producto18;
private ProductoMenu producto19;
private ProductoMenu producto20 ;
private ProductoMenu producto21 ;
private ProductoMenu producto22;
@BeforeEach
void setUp() throws Exception
{
	
	producto1 = new ProductoMenu("corral", 14000);
	producto2 = new ProductoMenu("corral queso", 16000);
	producto3 = new ProductoMenu("corral pollo", 15000);
	producto4 = new ProductoMenu("corralita", 13000);
	producto5 = new ProductoMenu("todoterreno", 25000);
	producto6 = new ProductoMenu("1/2 libra", 25000);
	producto7 = new ProductoMenu("especial", 24000);
	producto8 = new ProductoMenu("casera", 23000);
	producto9 = new ProductoMenu("mexicana", 22000);
	producto10 = new ProductoMenu("criolla", 22000);
	producto11 = new ProductoMenu("costeña", 20000);
	producto12 = new ProductoMenu("hawaiana", 20000);
	producto13 = new ProductoMenu("wrap de pollo", 15000);
	producto14 = new ProductoMenu("wrap de lomo", 22000);
	producto15 = new ProductoMenu("ensalada mexicana", 20900);
	producto16 = new ProductoMenu("papas medianas", 5500);
	producto17 = new ProductoMenu("papas grandes", 6900);
	producto18 = new ProductoMenu("papas en casco medianas", 5500);
	producto19 = new ProductoMenu("papas en casco grandes", 6900);
	producto20 = new ProductoMenu("agua cristal sin gas", 5000);
	producto21 = new ProductoMenu("agua cristal con gas", 5000);
	producto22 = new ProductoMenu("gaseosa", 5000);
	
	
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
		void testGetNombreCorralQueso() {
		    assertEquals("corral queso", producto2.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreCorralPollo() {
		    assertEquals("corral pollo", producto3.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test

		void testGetNombreCorralita() {
		    assertEquals("corralita", producto4.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreTodoterreno() {
		    assertEquals("todoterreno", producto5.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreMediaLibra() {
		    assertEquals("1/2 libra", producto6.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreEspecial() {
		    assertEquals("especial", producto7.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreCasera() {
		    assertEquals("casera", producto8.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
	
		void testGetNombreMexicana() {
		    assertEquals("mexicana", producto9.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreCriolla() {
		    assertEquals("criolla", producto10.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreCosteña() {
		    assertEquals("costeña", producto11.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreHawaiana() {
		    assertEquals("hawaiana", producto12.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreWrapPollo() {
		    assertEquals("wrap de pollo", producto13.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreWrapLomo() {
		    assertEquals("wrap de lomo", producto14.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreEnsaladaMexicana() {
		    assertEquals("ensalada mexicana", producto15.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombrePapasMedianas() {
		    assertEquals("papas medianas", producto16.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombrePapasGrandes() {
		    assertEquals("papas grandes", producto17.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombrePapasCascoMedianas() {
		    assertEquals("papas en casco medianas", producto18.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombrePapasCascoGrandes() {
		    assertEquals("papas en casco grandes", producto19.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreAguaSinGas() {
		    assertEquals("agua cristal sin gas", producto20.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreAguaConGas() {
		    assertEquals("agua cristal con gas", producto21.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetNombreGaseosa() {
		    assertEquals("gaseosa", producto22.getNombre(), "El nombre del producto no es el esperado.");
		}
	@Test
		void testGetPrecio() {
		
		    assertEquals(14000, producto1.getPrecio(), "Precio de corral incorrecto");
		    assertEquals(16000, producto2.getPrecio(), "Precio de corral queso incorrecto");
		    assertEquals(15000, producto3.getPrecio(), "Precio de corral pollo incorrecto");
		    assertEquals(13000, producto4.getPrecio(), "Precio de corralita incorrecto");
		    assertEquals(25000, producto5.getPrecio(), "Precio de todoterreno incorrecto");
		    assertEquals(25000, producto6.getPrecio(), "Precio de 1/2 libra incorrecto");
		    assertEquals(24000, producto7.getPrecio(), "Precio de especial incorrecto");
		    assertEquals(23000, producto8.getPrecio(), "Precio de casera incorrecto");
		    assertEquals(22000, producto9.getPrecio(), "Precio de mexicana incorrecto");
		    assertEquals(22000, producto10.getPrecio(), "Precio de criolla incorrecto");
		    assertEquals(20000, producto11.getPrecio(), "Precio de costeña incorrecto");
		    assertEquals(20000, producto12.getPrecio(), "Precio de hawaiana incorrecto");
		    assertEquals(15000, producto13.getPrecio(), "Precio de wrap de pollo incorrecto");
		    assertEquals(22000, producto14.getPrecio(), "Precio de wrap de lomo incorrecto");
		    assertEquals(20900, producto15.getPrecio(), "Precio de ensalada mexicana incorrecto");
		    assertEquals(5500, producto16.getPrecio(), "Precio de papas medianas incorrecto");
		    assertEquals(6900, producto17.getPrecio(), "Precio de papas grandes incorrecto");
		    assertEquals(5500, producto18.getPrecio(), "Precio de papas en casco medianas incorrecto");
		    assertEquals(6900, producto19.getPrecio(), "Precio de papas en casco grandes incorrecto");
		    assertEquals(5000, producto20.getPrecio(), "Precio de agua sin gas incorrecto");
		    assertEquals(5000, producto21.getPrecio(), "Precio de agua con gas incorrecto");
		    assertEquals(5000, producto22.getPrecio(), "Precio de gaseosa incorrecto");
}
}