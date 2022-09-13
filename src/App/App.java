package App;

import Trees.ABB;

public class App {
	public static void main(String[] args) {
		ABB tree = new ABB();

		tree.insert(2);
		tree.insert(1);
		tree.traversal();
		
	}
}
