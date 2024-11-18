/*
 * Copyright (C) [2024] [J.L. Triviño]
 *
 * Este programa es software libre: puedes redistribuirlo y/o modificarlo 
 * bajo los términos de la Licencia Pública General de GNU según lo publicado 
 * por la Free Software Foundation, ya sea la versión 3 de la Licencia, o 
 * (a tu elección) cualquier versión posterior.
 *
 * Este programa se distribuye con la esperanza de que sea útil, pero 
 * SIN NINGUNA GARANTÍA; ni siquiera la garantía implícita de 
 * COMERCIABILIDAD o IDONEIDAD PARA UN PROPÓSITO PARTICULAR. 
 * Consulta la Licencia Pública General de GNU para obtener más detalles.
 *
 * Deberías haber recibido una copia de la Licencia Pública General de GNU
 * junto con este programa. Si no es así, consulta <http://www.gnu.org/licenses/>.
 */



package diccionario;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Random;
import java.util.List;  

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.UUID; 

class BSTMapTest {
	private BSTMap<String, Integer> map;

	@BeforeEach
	public void setUp() {
		map = new BSTMap<>();
	}

	@Test
	public void testHasEntry() {
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		assertTrue( map.hasEntry("One"));
		assertTrue( map.hasEntry("Two"));
		assertTrue( map.hasEntry("Three"));
		assertFalse( map.hasEntry("Four"));
	}

	@Test
	public void testPutAndGet() {
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		assertEquals(1, map.get("One"));
		assertEquals(2, map.get("Two"));
		assertEquals(3, map.get("Three"));
		assertNull(map.get("Four"));
	}

	@Test
	public void testPutOverride() {
		map.put("One", 1);
		assertEquals(1, map.put("One", 10));
		assertEquals(10, map.get("One"));
	}

	@Test
	public void testRemove() {
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		assertEquals(2, map.remove("Two"));
		assertNull(map.get("Two"));
		assertEquals(2, map.size());

		assertNull(map.remove("Four"));
	}

	@Test
	public void testSize() {
		assertEquals(0, map.size());
		map.put("One", 1);
		assertEquals(1, map.size());
		map.put("Two", 2);
		assertEquals(2, map.size());
		map.remove("One");
		assertEquals(1, map.size());
		map.clear();
		assertEquals(0, map.size());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(map.isEmpty());
		map.put("One", 1);
		assertFalse(map.isEmpty());
		map.clear();
		assertTrue(map.isEmpty());
	}

	@Test
	public void testClear() {
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		map.clear();
		assertEquals(0, map.size());
		assertTrue(map.isEmpty());
		assertNull(map.get("One"));
		assertNull(map.get("Two"));
		assertNull(map.get("Three"));
	}

	@Test
	public void testEntrySet() {
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);

		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		assertEquals(3, entries.size());
		for (Map.Entry<String, Integer> entry : entries) {
			assertNotNull(entry.key());
			assertNotNull(entry.value());
		}
	}

	@Test
	public void testDuplicateKeys() {
		BSTMap<Integer, String> map = new BSTMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(10, "value" + i);
		}
		assertEquals(1, map.size());
		assertEquals("value99", map.get(10));
	}

	@Test
	public void testClear2() {
		BSTMap<Integer, String> map = new BSTMap<>();
		// ... llenar el árbol
		map.clear();
		assertEquals(0, map.size());
		assertNull(map.get(10));
	}

	@Test
	public void testEquals() {
		BSTMap<Integer, String> map1 = new BSTMap<>();
		BSTMap<Integer, String> map2 = new BSTMap<>();

		// Add elements to both maps
		map1.put(1, "one");
		map1.put(2, "two");
		map2.put(1, "one");
		map2.put(2, "two");

		// Assert equality
		assertTrue(map1.equals(map2));

		// Add a different element to one map
		map1.put(3, "three");
		assertFalse(map1.equals(map2));

		// Test with different order
		map1 = new BSTMap<>();
		map2 = new BSTMap<>();

		map1.put(1, "one");
		map1.put(2, "two");
		map2.put(2, "two");
		map2.put(1, "one");

		assertTrue(map1.equals(map2));
	}

	@Test
	public void testToArray() {
		BSTMap<Integer, String> map = new BSTMap<>();
		map.put(3, "three");
		map.put(1, "one");
		map.put(2, "two");

		Map.Entry<Integer, String>[] array = map.toArray();

		// Check array length and order
		assertEquals(3, array.length);
		assertArrayEquals(new Map.Entry[]{
				new Map.Entry<>(1, "one"),
				new Map.Entry<>(2, "two"),
				new Map.Entry<>(3, "three")
		}, array);
	}

	@Test
	public void testPutLargeRandomData() {
	    BSTMap<Integer, String> map = new BSTMap<>();
	    Random random = new Random();
	    int numElements = 1000;

	    // Generate a set of unique keys
	    Set<Integer> keys = new HashSet<>();
	    while (keys.size() < numElements) {
	        keys.add(random.nextInt(numElements * 2));
	    }

	    // Insert elements into the map
	    for (int key : keys) {
	        map.put(key, UUID.randomUUID().toString());
	    }

	    assertEquals(numElements, map.size());

	    // Verify that all inserted keys are present in the map
	    for (int key : keys) {
	        assertNotNull(map.get(key));
	    }
	}
	
	@Test
	public void testHasKeyLargeRandomData() {
	    BSTMap<Integer, String> map = new BSTMap<>();
	    Random random = new Random();
	    int numElements = 1000;

	    // Insert a set of unique keys
	    Set<Integer> keys = new HashSet<>();
	    while (keys.size() < numElements) {
	        keys.add(random.nextInt(numElements * 2));
	    }

	    // Insert elements into the map
	    for (int key : keys) {
	        map.put(key, String.valueOf(key));
	    }

	    // Test for both existing and non-existing keys
	    for (int key : keys) {
	        assertTrue(map.hasEntry(key));
	    }

	    for (int i = 0; i < 1000; i++) {
	        int key = random.nextInt(numElements * 2);
	        if (!keys.contains(key)) {
	            assertFalse(map.hasEntry(key));
	        }
	    }
	}



	@Test
	public void testEqualsLargeMaps() {
		Random random = new Random();

		// Crear dos mapas grandes con los mismos elementos en diferente orden
		int numElements = 100000;
		BSTMap<Integer, String> map1 = new BSTMap<>();
		BSTMap<Integer, String> map2 = new BSTMap<>();

		for (int i = 0; i < numElements; i++) {
			int key = random.nextInt(numElements);
			String value = UUID.randomUUID().toString();
			map1.put(key, value);
			map2.put(key, value);
		}

		// Mezclar el orden de los elementos en map2
		List<Map.Entry<Integer, String>> entries = new ArrayList<>(map2.entrySet());
		Collections.shuffle(entries);
		map2.clear();
		for (Map.Entry<Integer, String> entry : entries) {
			map2.put(entry.key(), entry.value());
		}

		// Verificar que los mapas sean iguales a pesar del diferente orden
		assertTrue(map1.equals(map2));

		// Modificar un elemento en uno de los mapas y verificar que ya no sean iguales
		map1.put(0, "nuevoValor");
		assertFalse(map1.equals(map2));
	}


	@Test
	public void testToArrayLargeMap() {
		// Crear un mapa grande con elementos aleatorios
		int numElements = 1000;
		BSTMap<Integer, String> map = new BSTMap<>();
		for (int i = 0; i < numElements; i++) {
			map.put(i, UUID.randomUUID().toString());
		}

		// Convertir el mapa a un arreglo
		Map.Entry<Integer, String>[] array = map.toArray();

		// Verificar el tamaño del arreglo
		assertEquals(numElements, array.length);

		// Verificar que todos los elementos estén presentes en el arreglo
		Set<Integer> keysInArray = new HashSet<>();
		for (Map.Entry<Integer, String> entry : array) {
			keysInArray.add(entry.key());
		}
		assertEquals(numElements, keysInArray.size());

		// Verificar que el orden de los elementos sea correcto (por ejemplo, ascendente según la clave)
		for (int i = 1; i < array.length; i++) {
			assertTrue(array[i - 1].key().compareTo( array[i].key() ) < 0);
		}
	}
	
	 @Test
    public void testPutNullKey() {
        BSTMap<String, Integer> map = new BSTMap<>();
        assertThrows(NullPointerException.class, () -> map.put(null, 10));
    }

    @Test
    public void testHasEntryNullKey() {
        BSTMap<String, Integer> map = new BSTMap<>();
        assertThrows(NullPointerException.class, () -> map.hasEntry(null));
    }

    @Test
    public void testGetNullKey() {
        BSTMap<String, Integer> map = new BSTMap<>();
        assertThrows(NullPointerException.class, () -> map.get(null));
    }

    @Test
    public void testRemoveNullKey() {
        BSTMap<String, Integer> map = new BSTMap<>();
        assertThrows(NullPointerException.class, () -> map.remove(null));
    }

}

