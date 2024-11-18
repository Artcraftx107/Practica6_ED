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

package diccionario;

import java.util.Set;

import java.util.HashSet;

public class BSTMap<K extends Comparable<K>, V> extends AbstractMap<K, V> {
	public static final class BST<K extends Comparable<K>, V>{
		public K key;
		public V value;
		public BST<K,V> left, right;
		public int height;

		BST( K k, V v, BST<K, V> l, BST<K, V> r ){
			key = k;
			value = v;
			left = l;
			right = r;
		}

		BST( K k, V v ){
			key = k;
			value = v;
			left = null;
			right = null;
		}
	}
	
	private BST<K,V> bst; // Cabeza de la lista enlazada


	public BSTMap() {
		bst = null;
		size = 0;
	}


	
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		
		// Completar
		
		
		return oldValue;
	}
	

	
    @Override
	public boolean hasEntry(K key) {
			// Completar
	
    	return false;
	}
	

    
	@Override
	public V get(K key) {
		// Completar
	
		return null;
	}


	
	@Override
	public V remove(K key) {
		V oldValue = null;

		// Completar
		
				
		return oldValue;
	}

	@Override
	public void clear() {
		bst = null;
		size = 0;
	}


	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> entrySet = new HashSet<>();
		
		// Completar

		return entrySet;
	}
	
	
	@SuppressWarnings("unchecked")
	protected Map.Entry<K,V>[] toArray(){
		var array = new Map.Entry[size];

		// Completar
		

		return array;
	}
	
}
