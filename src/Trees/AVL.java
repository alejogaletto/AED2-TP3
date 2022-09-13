package Trees;

public class AVL extends ABB {
	
}




































/*
public class AVL <T extends Comparable <T>> implements Iterable <T> {
	
	
	
}
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
		
		//Actualiza el factor de equilibrio y los valores de altura
		update(node);
		
		//Re-balancea el arbol
		return balance(node);
	}
	
	//Actualiza los distintos valores del nodo y balancea 
	private void update(Node node) {
		int leftNodeHeight = (node.left == null) ? -1: node.left.height;
		int rightNodeHeight = (node.right == null) ? -1 : node.right.height;
		
		//Actualiza la altura de este nodo
		node.height = 1 + Math.max(leftNodeHeight, rightNodeHeight);
		
		//Actualiza el factor de equilibrio
		node.bf = rightNodeHeight - leftNodeHeight;
	}
	
	//Re-balancea un nodo si su factor de equilibrio es +2 o -2
	private Node balance(Node node) {
		
		//Subarbol izquierdo pesado
		if(node.bf == -2) {
			//Caso de izquierda-izquierda
			if(node.left.bf <= 0) {
				return leftLeftCase(node);
				
				//Caso de izquierda-derecha
			} else {
				return leftRightCase(node);
			}
		
		// El subarbol derecho necesita balancear
		}else if(node.bf == +2) {
			
			//Caso derecha-derecha
			if(node.right.bf >= 0) {
				return rightRightCase(node);
				
			//Caso de dercba-izquierda
			} else {
				return rightLeftCase(node);
			}
		}
		//El nodo tiene un factor de equilibrio de 0, +1 o -1, cosa que esta bien
		return node;
	}
	
	private Node leftLeftCase(Node node) {
		return rightRotation(node);
	}
	
	private Node leftRightCase(Node node) {
		node.left = leftRotation(node.left);
		return leftLeftCase(node);
	}
	
	private Node rightRightCase(Node node) {
		return leftRotation(node);
	}
	
	private Node rightLeftCase(Node node) {
		node.right = rightRotation(node.right);
		return rightRightCase(node);
	}
	
	private Node leftRotation(Node node) {
		Node newParent = node.right;
		node.right = newParent.left;
		newParent.left = node;
		update(node);
		update(newParent);
		return newParent;
	}
	
	private Node rightRotation(Node node) {
		Node newParent = node.left;
		node.left = newParent.right;
		newParent.right = node;
		update(node);
		update(newParent);
		return newParent;
	}
	
	//Remueve un valor del arbol si existe
	public boolean remove(T elem) {
		 if(elem==null) return false;
		 
		 if(contains(root,elem)) {
			 root = remove(root, elem);
			 nodeCount--;
			 return true;
		 }
		 return false;
	}
	
	//Remueve valor del arbol AVL
	private Node remove(Node node, T elem) {
		if(node == null) return null;
		
		int cpm = elem.compareTo(node.value);
		
		//Indaga en el subarbol izquierdo, para saber si el valor que buscamos es menor que el actual
		if(cpm < 0) {
			node.left = remove(node.left.left, elem);
			
		//Indaga en el subarbol derecho, para sbaer si el valor que buscamos es mayor que el actual
		}else if(cpm > 0) {
			node.right = remove(node.right, elem);
			
		//Encontramos el nodo que queremos eliminar
		} else {
			if(node.left == null) {
				return node.right;
				
			}else if(node.right == null) {
				return node.left;
				
			} else {
				//Elige remover del subarbol izquierdo
				if(node.left.height > node.right.height) {
					
					//Intercambia el valor del sucesor
					T successorValue = findMax(node.left);
					node.value = successorValue;
					
					//Encuentra el nodo mas grande en el subarbol izquierdo
					node.left = remove(node.left, successorValue);;
					
				} else {
					
					//Intercambia el valor del sucesor
					T successorValue = findMin(node.right);
					node.value = successorValue;
					
					//Va al subarbol derecho y remueve el nodo mas a la izquierda encontrado
					//y intercambia sus datos. Esto previene que tengamos dos nodos con los
					//mismos valores
					node.right = remove(node.right, successorValue);
				}
			}
		}
		
		//Actualiza factor de equilibrio y altura.
		update(node);
		
		//Re-balancea el arbol
		return balance(node);
	}
	
	//Metodo para hallar el nodo mas a la izquierda(es decir, tiene el valor mas chico)
	private T findMin(Node node) {
		while(node.left != null)
			node = node.left;
		return node.value;
	}
	
	//Metodo para hallar el nodo mas a la dereche(es decir, tiene el valor mas grande)
	private T findMax(Node node) {
		while(node.right != null)
			node = node.right;
		return node.value;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		AVL<Integer> tree = new AVL<>();
		int userValue = input.nextInt();
		tree.insert(userValue);
		while(true) {
			System.out.println("Oprima [1] insertar un dato");
			System.out.println("Oprima [2] borrar un dato");
			System.out.println("Oprima [3] para mostrar todos los datos ordenados con su FE");
		}
		
		
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
*/