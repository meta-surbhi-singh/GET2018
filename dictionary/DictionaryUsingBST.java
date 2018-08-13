package dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

/**
 * This class implements IDictionary interface using Binary Search Tree.
 *
 */
public class DictionaryUsingBST implements IDictionary {
	private Node root;
	List<Node> sortedList;

	/**
	 * initializes dictionary with some initial key value
	 * pairs,which it parse from JSON object.
	 * 
	 * @throws ParseException
	 * @throws IOException
	 */
	public DictionaryUsingBST() {
		root = null;
		sortedList = new ArrayList<Node>();
		try {
			JSONObject jsonObject = ReadJson.readJson();
			for (Object jsonKey : jsonObject.keySet()) {
				int key = Integer.parseInt(jsonKey.toString());
				String value = jsonObject.get(jsonKey).toString();
				addToDictionary(key, value);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("file not found");
		} catch (IOException exception) {
			System.out.println("IOException");
		} catch (ParseException exception) {
			System.out.println("Exception in parsing of JSON object");
		}
	}

	@Override
	public void addToDictionary(int key, String value) {
		root = addHelper(root, key, value);
	}

	@Override
	public void deleteFromDictionary(int key) {
		root = deleteHelper(root, key);
	}

	@Override
	public String getValue(int key) {
		Node nodeContaingKey = searchNode(root, key);
		if (nodeContaingKey == null) {
			throw new AssertionError("Node doesn't exist");
		}
		String value = nodeContaingKey.getValue();
		return value;
	}

	@Override
	public List<Node> getSortedList() {
		sortHelper(root);
		return sortedList;
	}

	@Override
	public List<Node> getSortedListInRangeOfKey(int key1, int key2) {
		sortHelper(root);
		List<Node> sortedListForRangeOfKeys = new ArrayList<Node>();
		if (key2 < key1) {
			int temporaryKey = key1;
			key1 = key2;
			key2 = temporaryKey;
		}
		for (Node node : sortedList) {
			int keyOfCurrentnode = node.getKey();
			if (key1 <= keyOfCurrentnode && key2 >= keyOfCurrentnode) {
				sortedListForRangeOfKeys.add(node);
			}
		}
		return sortedListForRangeOfKeys;
	}

	/**
	 * method to add key value pair in dictionary.
	 * 
	 * @param node  contains root of subtree.
	 * @param key
	 * @param value
	 * @return returns the node that is added.
	 */
	private Node addHelper(Node node, int key, String value) {
		if (node == null) {
			Node newNode = new Node(key, value);
			return newNode;
		}
		int keyOfNode = node.getKey();
		if (keyOfNode > key) {
			Node leftChild = addHelper(node.getLeftChild(), key, value);
			node.setLeftChild(leftChild);
		} else if (keyOfNode < key) {
			Node rightChild = addHelper(node.getRightChild(), key, value);
			node.setRightChild(rightChild);
		}
		return node;
	}

	/**
	 * method to search a node of key exist in dictionary or not.
	 * 
	 * @param currentNode contains root of subtree.
	 * @param key
	 * @return returns node containing key if key exist in dictionary otherwise
	 *         null.
	 */
	private Node searchNode(Node currentNode, int key) {
		Node nodeContainingKey = null;
		if (currentNode == null) {
			return nodeContainingKey;
		}
		int keyOfNode = currentNode.getKey();
		if (key == keyOfNode) {
			nodeContainingKey = currentNode;
		} else if (key < keyOfNode) {
			nodeContainingKey = searchNode(currentNode.getLeftChild(), key);
		} else {
			nodeContainingKey = searchNode(currentNode.getRightChild(), key);
		}
		return nodeContainingKey;
	}

	/**
	 * private helper method for sorting of dictionary nodes based on key.
	 * 
	 * @param node contains root of subtree
	 * @return returns sorted list.
	 */
	private void sortHelper(Node node) {
		if (node != null) {
			sortHelper(node.getLeftChild());
			sortedList.add(node);
			sortHelper(node.getRightChild());
		}
	}

	/**
	 * private helper method to delete node from dictionary.
	 * 
	 * @param node contains root of subtree.
	 * @param key
	 * @return returns deleted node.
	 */
	private Node deleteHelper(Node node, int key) {
		if (node == null) {
			return node;
		}
		int keyOfNode = node.getKey();
		if (keyOfNode > key) {
			Node leftChild = deleteHelper(node.getLeftChild(), key);
			node.setLeftChild(leftChild);
		} else if (keyOfNode < key) {
			Node rightChild = deleteHelper(node.getRightChild(), key);
			node.setRightChild(rightChild);
		} else {
			Node leftChild = node.getLeftChild();
			Node rightChild = node.getRightChild();
			if (leftChild == null) {
				return rightChild;
			} else if (rightChild == null) {
				return leftChild;
			} else {
				Node nodeWithMinimumKey = getMinimumOfRightSubtree(rightChild);
				int minimumKey = nodeWithMinimumKey.getKey();
				String valueForMinimumKey = nodeWithMinimumKey.getValue();
				node.setKey(minimumKey);
				node.setValue(valueForMinimumKey);
			}
		}
		return node;
	}

	/**
	 * find minimum key in right subtree.
	 * 
	 * @param node contains root of subtree.
	 * @return returns node having minimum key.
	 */
	private Node getMinimumOfRightSubtree(Node node) {
		Node leftChild = node.getLeftChild();
		while (leftChild != null) {
			leftChild = leftChild.getLeftChild();
		}
		return leftChild;
	}

}
