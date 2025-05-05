package uniandes.dpoo.hamburguesas.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uniandes.dpoo.hamburguesas.mundo.Combo;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ComboTest {

	private ArrayList<Combo> combos;
	private Map<String ,ProductoMenu> productos = new HashMap<>();
	

	@BeforeEach
	void setUp() throws Exception {
	    // 1. Inicializar el mapa de productos
	    productos = new HashMap<>();

	    // 2. Verificar y leer menu.txt
	    File archivoMenu = new File("./data/menu.txt");
	    if (!archivoMenu.exists()) {
	        throw new FileNotFoundException("menu.txt no encontrado en ./data/");
	    }

	    try (BufferedReader lector = new BufferedReader(new FileReader(archivoMenu))) {
	        String linea;
	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split(";");
	            if (datos.length < 2) {
	                System.err.println("Formato inválido en menu.txt: " + linea);
	                continue;
	            }
	            String nombre = datos[0].trim();
	            int precio = Integer.parseInt(datos[1].trim());
	            productos.put(nombre, new ProductoMenu(nombre, precio));
	        }
	    }

	    // 3. Verificar y leer combos.txt
	    File archivoCombos = new File("./data/combos.txt");
	    if (!archivoCombos.exists()) {
	        throw new FileNotFoundException("combos.txt no encontrado en ./data/");
	    }

	    combos = new ArrayList<>();
	    try (BufferedReader lector = new BufferedReader(new FileReader(archivoCombos))) {
	        String linea;
	        while ((linea = lector.readLine()) != null) {
	            String[] datos = linea.split(";");
	            if (datos.length < 3) {
	                System.err.println("Formato inválido en combos.txt: " + linea);
	                continue;
	            }
	            String nombreCombo = datos[0].trim();
	            double descuento = Double.parseDouble(datos[1].replace("%", "").trim()) / 100.0;
	            
	            ArrayList<ProductoMenu> productosCombo = new ArrayList<>();
	            for (int i = 2; i < datos.length; i++) {
	                String nombreProducto = datos[i].trim();
	                ProductoMenu producto = productos.get(nombreProducto);
	                if (producto == null) {
	                    System.err.println("Producto no encontrado en combo: " + nombreProducto);
	                } else {
	                    productosCombo.add(producto);
	                }
	            }
	            
	            combos.add(new Combo(nombreCombo, descuento, productosCombo));
	        }
	    }
	}
	@AfterEach
    void tearDown( ) throws Exception
    {
    }
	@Test
	void testGetNombre() {
		Combo combo = combos.get(0);
		assertEquals("combo corral",combo.getNombre(),"El nombre del combo es incorrecto");
	}

}
