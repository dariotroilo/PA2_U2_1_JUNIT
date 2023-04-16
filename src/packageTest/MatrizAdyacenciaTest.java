package packageTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;


class MatrizAdyacenciaTest {

	private int cantElementos = 4;
	private MatrizAdyacencia matriz = new MatrizAdyacencia(cantElementos);
	
	@Test
	public void agregarElementoTest() {
		matriz.agregarElemento(2, 3);
		
		assertTrue(matriz.existeElemento(2, 3));
		
	}
	@Test
	public void agregarElementoSimetriaTest() {
		matriz.agregarElemento(2, 3);
		
		assertTrue(matriz.existeElemento(3, 2));
	}
	
	@Test
	public void eliminarElementoTest() {
		matriz.agregarElemento(2, 3);
		
		matriz.eliminarElemento(2, 3);
		
		assertFalse(matriz.existeElemento(2, 3));
	}
	
	@Test
	public void eliminarElementoTestSimetria() {
		matriz.agregarElemento(2, 3);
		
		matriz.eliminarElemento(2, 3);
		
		assertFalse(matriz.existeElemento(3, 2));
	}
	
	@Test
	public void contarRelacionesTest() {
		
		matriz.agregarElemento(1, 3);
		matriz.agregarElemento(2, 3);
		matriz.agregarElemento(2, 1);
		
		assertEquals(matriz.getCantidadElementos(),3);
	}
	
	@Test
	public void existenTodosLosElementoTest()
	{
		// Crear los datos para el caso de prueba
		matriz.agregarElemento(0, 0);
		matriz.agregarElemento(0, 1);
		matriz.agregarElemento(0, 2);
		matriz.agregarElemento(0, 3);
		
		matriz.agregarElemento(1, 1);
		matriz.agregarElemento(1, 2);
		matriz.agregarElemento(1, 3);

		matriz.agregarElemento(2, 2);
		matriz.agregarElemento(2, 3);

		matriz.agregarElemento(3, 3);
		//matriz.eliminarElemento(3, 3);
		
		// Caso de prueba
		int CantidadElementos = cantElementos * cantElementos;
		int CantidadElementosTrue = matriz.getCantidadElementos();
		boolean resultado = true;
		
		// Si todas las posiciones de la matriz (CantidadElementos) estan guardadas (CantidadElementosTrue) se evalua el caso
		if(CantidadElementos==CantidadElementosTrue) {
			// Verificar que todos los elementos se hayan guardado correctamente en su posición original y en su simetrico
			// Recorrer las filas de matriz
			for(int i=0; i<=cantElementos-1; i++)
			{
				// Recorrer las columnas de la matriz
				for(int j=0; j<=cantElementos-1; j++)
				{
					boolean elemento = matriz.existeElemento(i, j);
					boolean elementoSimetrico = matriz.existeElemento(j, i);
					
					// Si al menos un elemento no cumple, el caso de pruebas es erroneo.
					if(elemento != elementoSimetrico)
						resultado = false;
				}
			}

			assertTrue(resultado);
		}
	}
	
	@Test
	public void agregarElementoFilaNegativaTest() {
		Throwable throwable =  assertThrows(Throwable.class, () -> {
			matriz.agregarElemento(-1, 2);
		});
	}

}
