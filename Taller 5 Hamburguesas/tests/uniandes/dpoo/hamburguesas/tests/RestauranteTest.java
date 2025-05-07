package uniandes.dpoo.hamburguesas.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.excepciones.HamburguesaException;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
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
	void testCerrarYGuardarPedido() {
		
		NoHayPedidoEnCursoException exception = assertThrows(NoHayPedidoEnCursoException.class,()-> restaurante.cerrarYGuardarPedido(),"Deberia lanzar una exception");
	}
	@Test
	void testGetPedidoEnCurso() {
		Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
		assertEquals(null,pedidoEnCurso,"deberia ser null");
	}
	@Test
	void testCargarInformacionRestaurante() throws IOException, NumberFormatException, HamburguesaException {
		// 1. Configuración del archivo
	    File archivoMenu = new File(".\\Taller 5 Hamburguesas\\data\\menu.txt");
	    File archivoIngredientes = new File(".\\Taller 5 Hamburguesas\\data\\ingredientes.txt");
	    File archivoCombos = new File(".\\Taller 5 Hamburguesas\\data\\combos.txt");
	    
	    restaurante.cargarInformacionRestaurante(archivoIngredientes, archivoMenu, archivoCombos);
	    
	    String StringMenu = Files.readString(Paths.get(".\\Taller 5 Hamburguesas\\data\\menu.txt"));
	    String StringIngredientes = Files.readString(Paths.get(".\\Taller 5 Hamburguesas\\data\\ingredientes.txt"));
	    String StringCombos = Files.readString(Paths.get(".\\Taller 5 Hamburguesas\\data\\combos.txt"));
	    
	   ArrayList<Combo> combos = restaurante.getMenuCombos();
	   ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
	   ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
	   
	   // combo prueba
	   
	   ArrayList<ProductoMenu> productos = new ArrayList<ProductoMenu>();
	    productos.add(new ProductoMenu("papas medianas", 5500));
	    productos.add(new ProductoMenu("gaseosa", 5000));
	    productos.add(new ProductoMenu("corral", 14000));
	    Combo combo = new Combo("combo corral", 0.1, productos);
	   
	   // Menu prueba
	   
	    ProductoMenu productoMenu = new ProductoMenu("corral", 14000);
	    
	   // Ingrediente prueba
	   
	    Ingrediente ingrediente1 = new Ingrediente("lechuga", 1000);
	   
	   
	   //assertTrue(combos.contains(combo));
	   //assertTrue(menu.contains(productoMenu));
	   assertTrue(ingredientes.contains(ingrediente1));
	   
	   

	
	    
	    
		
	}
	@Test
	void testGests(){
		restaurante.getIngredientes();
		restaurante.getPedidos();
		restaurante.getMenuCombos();
		
	}
}
