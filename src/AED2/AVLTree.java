package AED2;

import java.util.Iterator;

public class AVLTree <T extends Comparable <T>> implements Iterable <T> {
	public class Node {
		// "bf" es factor de balance
		int bf;
			
		// El valor/dato que contiene el nodo
		T value;
			
		// La altura del nodo en el arbol
		int height;
			
		//El hijo izquiero y derecho
		Node left, right;
			
		public Node(T value) {
			this.value = value;
		}
	}

	
	//EL nodo raiz del arbol AVL
	public Node root;
	
	//Lleva la cuenta de los nodos adentro del arbol
	private int nodeCount = 0;
	
	//EL token es un valor especial que usamos como alternativa para retornar null
	//El token se usa para devolver returns de valores especiales
	//Podemos devolver un token cuando insertemos un nuevo item 
	//y descubramos que el valor que insertamos ya existia
	
	private Node TOKEN = new Node(null);
	public int height() {
		if(root == null) return 0;
		return root.height;
	}
	
	//Devuelve verdadero o falso dependiendo de si un valor existe en el arbol
	public boolean contains(T value) {
		return contains(root, value);
	}
	
	// Metodo recursivo para saber si existe metodo adentro del arbol o no
	private boolean contains(Node node, T value) {
		if(node == null) return false;
		
		//Compara los valores actuales con los valores en el nodo
		int cpm = value.compareTo(node.value);
		
		//Indaga en el subarbol izquierdo
		if(cpm < 0) return contains(node.left, value);
		
		//Indaga en el subarbol derecho
		if(cpm>0) return contains(node.right, value);
		
		//Encontro el valor en el arbol
		return true;
	}
	
	// Inserta/agrega un valor al arbol AVL. El valor no debe ser nulo
	public boolean insert(T value) {
		if(value == null) return false;
		if(!contains(root,value)) {
			root = insert(root, value);
			nodeCount++;
			return true;
		}
		return false;
	}
	
	//Inserta un valor adentro del arbol AVL
	private Node insert(Node node, T value) {
		
		//Caso base
		if(node == null) return new Node(value);
		
		//Compara el valor actual con el valor del nodo
		int cpm = value.compareTo(node.value);
		
		//Inserta nodo en el subarbol izquierdo
		if(cpm < 0) {
			node.left = insert(node.left, value);;
		
		//Inbserta nodo en el subarbol derecho
		}else {
			node.right = insert(node.left, value);
		}
		
		//Actualiza el factor de balance y los valores de altura
		update(node);
		
		//Re-balancea el arbol
		return balance(node);
	}
	
	//Actualiza los distintos valores del nodo y balancea 
	private void update(Node node) {
		int leftNodeHeight = (node.left == null) ? -1: node.left.height;
		int rightNodeHeight = (node.right == null) ? -1 : node.right.height;
}
	
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
