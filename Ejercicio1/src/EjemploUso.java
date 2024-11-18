/*******************************
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


import diccionario.BSTMap;
import diccionario.Map;

public final class EjemploUso {
	private static void probar( Map<String, Integer> map ) {
	    // Insertar pares clave-valor en el mapa
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Obtener y mostrar el valor asociado a una clave
        System.out.println("Value for 'One': " + map.get("One")); // Output: Value for 'One': 1

        // Mostrar el tamaño del mapa
        System.out.println("Size of map: " + map.size()); // Output: Size of map: 3

        // Eliminar una entrada del mapa
        System.out.println("Removing 'Two': " + map.remove("Two")); // Output: Removing 'Two': 2

        // Mostrar el tamaño del mapa después de la eliminación
        System.out.println("Size of map after removal: " + map.size()); // Output: Size of map after removal: 2

        // Mostrar todas las entradas del mapa
        System.out.println("Entries in the map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.key() + " = " + entry.value());
        }
        // Output:
        // Entries in the map:
        // One = 1
        // Three = 3

        // Verificar si el mapa está vacío
        System.out.println("Is the map empty? " + map.isEmpty()); // Output: Is the map empty? false

        // Limpiar el mapa
        map.clear();
        System.out.println("Size of map after clearing: " + map.size()); // Output: Size of map after clearing: 0
        System.out.println("Is the map empty after clearing? " + map.isEmpty()); // Output: Is the map empty after clearing? true
    }
	
	
    public static void main(String[] args) {
        System.out.println( "Mapa con listas enlazadas" );
        
        BSTMap<String, Integer> map2 = new BSTMap<>();
        
        probar( map2 );
    }
}