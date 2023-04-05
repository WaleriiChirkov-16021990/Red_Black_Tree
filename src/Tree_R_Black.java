import java.util.List;

public class Tree_R_Black {
	private Node root;
	
	private boolean addNode(Node node, int value) {
		if (node.value == value) {
			return false;
		} else {
			if (node.value > value) {
				if (node.leftChild != null) {
					boolean result = addNode(node.leftChild, value);
					return result;
				} else {
					node.leftChild = new Node();
					node.leftChild.color = Color.RED;
					node.leftChild.value = value;
					return true;
				}
			} else {
				if (node.rightChild != null) {
					boolean result = addNode(node.rightChild, value);
					return result;
				} else {
					node.rightChild = new Node();
					node.rightChild.color = Color.RED;
					node.rightChild.value = value;
					return true;
				}
			}
		}
	}
	
	private Node rebalance(Node node) {
		boolean needRebalance;
		Node result = node;
		do {
			needRebalance = false;
			if (result.rightChild != null && result.rightChild.color == Color.RED &&
					(result.leftChild == null || result.leftChild.color == Color.BLACK)) {
				needRebalance = true;
				result = rightSwap(result);
			}
			if (result.leftChild != null && result.leftChild.color == Color.RED &&
					(result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.BLACK)) {
				needRebalance = true;
				result = leftSwap(result);
			}
			if (result.rightChild != null && result.rightChild.color == Color.RED &&
				 result.leftChild != null && result.leftChild.color == Color.RED) {
				needRebalance = true;
				colorSwap(result);
			}
		} while (needRebalance);
		return result;
	}
	
	private Node rightSwap(Node node) {
		Node rightChild = node.rightChild;
		Node betweenChild = rightChild.leftChild;
		rightChild.leftChild = node;
		node.rightChild = betweenChild;
		rightChild.color = node.color;
		node.color = Color.RED;
		return rightChild;
	}
	private Node leftSwap(Node node) {
		Node leftChild = node.leftChild;
		Node betweenChild = leftChild.rightChild;
		leftChild.rightChild = node;
		node.leftChild = betweenChild;
		leftChild.color = node.color;
		node.color = Color.RED;
		return leftChild;
	}
	
	
	private void colorSwap(Node node) {
		node.rightChild.color = Color.BLACK;
		node.leftChild.color = Color.BLACK;
		node.color = Color.RED;
	}
	private class Node{
		private int value;
		private Color color;
		private Node leftChild;
		private Node rightChild;
	}
	
	public enum Color {
		RED,BLACK;
	}
}
