package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Producto;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class PedidoTest {
	Combo combo;
	ProductoAjustado productoAjustado;
	ProductoMenu productoMenu;
	Pedido pedido;
	
	@BeforeEach
	void setUp() throws Exception {
	    // Creación de combo
	    ArrayList<ProductoMenu> productos = new ArrayList<ProductoMenu>();
	    productos.add(new ProductoMenu("papas medianas", 5500));
	    productos.add(new ProductoMenu("gaseosa", 5000));
	    productos.add(new ProductoMenu("corral", 14000));
	    this.combo = new Combo("combo corral", 0.1, productos);  
	    // Creación de producto ajustado
	    ProductoMenu producto1 = new ProductoMenu("especial", 24000);
	    this.productoAjustado = new ProductoAjustado(producto1);
	    Ingrediente ingrediente1 = new Ingrediente("lechuga", 1000);
	    Ingrediente ingrediente2 = new Ingrediente("pepinillos", 2500);
	    productoAjustado.agregarIngrediente(ingrediente1);
	    productoAjustado.agregarIngrediente(ingrediente2);

	    // Creación de ProductoMenu (corregir asignación)
	    this.productoMenu = new ProductoMenu("corral", 14000); 

	    // Creación del pedido (corregir asignación)
	    this.pedido = new Pedido("Raul", "Calle 1 #7A");  
	    this.pedido.agregarProducto(this.combo);
	    this.pedido.agregarProducto(this.productoAjustado);
	    this.pedido.agregarProducto(this.productoMenu);
	    
	  
	}
	@AfterEach
    void tearDown( ) throws Exception
    {
		
    }
	@Test
	void testGetIdPedido() {
		pedido.setNumeroPedido(4);
		int numero = pedido.getNumeroPedido();
		assertEquals(numero+1,pedido.getIdPedido(),"Id equivocado");
		
	}
	@Test
	void testAgregarProducto() {
		
		
		ProductoMenu producto_prueba = new ProductoMenu("gaseosa",5000);
		ArrayList<Producto> lista = pedido.getProductos();
		int longitud = lista.size();
		
		pedido.agregarProducto(producto_prueba);
		
		assertEquals(longitud+1,lista.size(), "no se agrego");
		
	}
	
	@Test
	void testGetNombreCliente() {
		assertEquals("Raul",pedido.getNombreCliente(),"Nombre incorrecto");
	}
	@Test
	void testguardarFactura() throws IOException {
	    // 1. Configuración del archivo
	    File archivo = new File("./data/factura_test.txt");
	    if (archivo.exists()) {
	        archivo.delete(); 
	    }
	    
	
	    int precioNeto = combo.getPrecio() + productoMenu.getPrecio() + productoAjustado.getPrecio();
	    int precioIVA = (int)(precioNeto * pedido.getIVA());
	    int precioTotal = precioIVA + precioNeto;
	    
	   
	    pedido.guardarFactura(archivo);
	    String contenido = Files.readString(Paths.get("./data/factura_test.txt"));
	    
	    String lineaNetoBuscada = "Precio Neto:  " + precioNeto;
	    String lineaIVABuscada = "IVA:          " + precioIVA;
	    String lineaTotalBuscada = "Precio Total: " + precioTotal;
	    
	    assertTrue(contenido.contains(lineaNetoBuscada),
	        "ERROR: El precio neto no coincide.\n" +
	        "Se esperaba: '" + lineaNetoBuscada + "'\n" +
	        "En factura: \n" + contenido);
	    
	    assertTrue(contenido.contains(lineaIVABuscada),
	        "ERROR: El IVA no coincide.\n" +
	        "Se esperaba: '" + lineaIVABuscada + "'\n" +
	        "En factura: \n" + contenido);
	    
	    assertTrue(contenido.contains(lineaTotalBuscada),
	        "ERROR: El precio total no coincide.\n" +
	        "Se esperaba: '" + lineaTotalBuscada + "'\n" +
	        "En factura: \n" + contenido);
	}

}

