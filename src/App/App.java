package App;

import Trees.ABB;
import Trees.AVL;

public class App {
	public static void main(String[] args) {
		AVL<Integer> tree = new AVL<>();
		

	

		tree.insertAVL(1);
		tree.insertAVL(2);
		tree.insertAVL(-1);
		tree.insertAVL(3);
		tree.insertAVL(1);
	

		

		tree.traversal();
		
	}
}
