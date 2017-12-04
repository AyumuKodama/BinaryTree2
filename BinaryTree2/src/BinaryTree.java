
public class BinaryTree {
	
	public Node root;
	static int num = 0;
	
	public BinaryTree() {
		root = null;
	}
	
	public void insert(String newRecord) {
		root = subtreeInsert(root, newRecord);
	}
	
	private Node subtreeInsert(Node topNode, String newRecord) {
		if (topNode == null) {
			topNode = new Node(newRecord);
		} else if (newRecord.compareTo(topNode.record) < 0) {
			topNode.left = subtreeInsert(topNode.left, newRecord);
		} else {
			topNode.right = subtreeInsert(topNode.right, newRecord);
		}
		return topNode;
	}
	
	public void inOrder() {
		inOrderSubtree(root);
	}
	
	private void inOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			inOrderSubtree(topNode.left);
			System.out.print(topNode.record + " ");
			inOrderSubtree(topNode.right);
		}
	}
	
	public void preOrder() {
		preOrderSubtree(root);
	}
	
	private void preOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			System.out.print(topNode.record + " ");
			preOrderSubtree(topNode.left);
			preOrderSubtree(topNode.right);
		}
	}
	
	public void postOrder() {
		postOrderSubtree(root);
	}
	
	private void postOrderSubtree(Node topNode) {
		if (topNode == null) {
			return;
		} else {
			postOrderSubtree(topNode.left);
			postOrderSubtree(topNode.right);
			System.out.print(topNode.record + " ");
		}
	}
	
	public int size() {
		return subtreeSize(root);
	}
	
	private int subtreeSize(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			subtreeSize(topNode.left);
			subtreeSize(topNode.right);
			num++;
			return num;
		}

	}
	
	public int maxDepth() {
		return subtreeMaxDepth(root);
	}
	
	private int subtreeMaxDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMaxDepth(topNode.left);
			int right = subtreeMaxDepth(topNode.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
	
	public int minDepth() {
		return subtreeMinDepth(root);
	}
	
	private int subtreeMinDepth(Node topNode) {
		if (topNode == null) {
			return 0;
		} else {
			int left = subtreeMaxDepth(topNode.left);
			int right = subtreeMaxDepth(topNode.right);
			if (left > right) {
				return right + 1;
			} else {
				return left + 1;
			}
		}
	}
	
	public int countMatches(String key) {
		return subtreeCountMatches(root, key);
	}
	
	private int subtreeCountMatches(Node topNode, String key) {
		if (topNode == null) {
			return 0;
		} else {
			int num = 0;
			if (topNode.record.equals(key)) {
				num++;
			}
			int left = subtreeCountMatches(topNode.left, key);
			int right = subtreeCountMatches(topNode.right, key);
			return num + left + right;
			
		}
	}
	
	public String maxRecord() {
		return subtreeMaxRecord(root);
	}
	
	private String subtreeMaxRecord(Node topNode) {
		String max;
		if (topNode == null) {
			return "";
		} else {
			max = topNode.record;
			String left = subtreeMaxRecord(topNode.left);
			String right = subtreeMaxRecord(topNode.right);
			String maximum;
			if (left.compareTo(right) < 0) {
				maximum = right;
			} else {
				maximum = left;
			}
			if (max.compareTo(maximum) < 0) {
				return maximum;
			} else {
				return max;
			}
		}
	}
	
	public String minRecord() {
		return subtreeMinRecord(root);
	}
	
	private String subtreeMinRecord(Node topNode) {
		String min;
		if (topNode == null) {
			return "";
		} else {
			min = topNode.record;
			String left = subtreeMinRecord(topNode.left);
			String right = subtreeMinRecord(topNode.right);
			String minimum;
			if (left.compareTo(right) < 0) {
				minimum = left;
			} else {
				minimum = right;
			}
			if (min.compareTo(minimum) < 0) {
				return min;
			} else {
				return minimum;
			}
		}
	}
}