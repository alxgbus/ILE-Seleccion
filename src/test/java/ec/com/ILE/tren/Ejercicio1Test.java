package ec.com.ILE.tren;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class Ejercicio1Test {

	Ejercicio1 ejercicio1 = new Ejercicio1();
	
	@Test
	/*Compara la cantidad de rutas esperada y la obtenida*/
	public void testRutasEjercicioCantidadRutas() {
		List<String> rutasObtenidas = ejercicio1.rutasEjercicio1();
		assertEquals(10, rutasObtenidas.size());
	}
	
	@Test
	/*Imprime todas las rutas*/
	public void testImprimirTodasLasRutas() {
		List<String> rutasObtenidas = ejercicio1.rutasEjercicio1();
		rutasObtenidas.forEach(System.out::println);
	}
	
	@Test
	/*Compara output 3*/
	public void testCompararOutput3() {
		List<String> rutasObtenidas = ejercicio1.rutasEjercicio1();
		assertEquals("Output #3: 13", rutasObtenidas.get(2));
	}
	
	@Test
	/*Compara output 5*/
	public void testCompararOutput5() {
		List<String> rutasObtenidas = ejercicio1.rutasEjercicio1();
		assertEquals("Output #5: NO SUCH ROUTE", rutasObtenidas.get(4));
	}
	
	@Test
	/*Compara output 10*/
	public void testCompararOutput10() {
		List<String> rutasObtenidas = ejercicio1.rutasEjercicio1();
		assertEquals("Output #10: 7", rutasObtenidas.get(9));
	}

}
