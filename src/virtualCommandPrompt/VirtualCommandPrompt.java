package virtualCommandPrompt;

import java.util.*;

/**
 * This class represents virtual command prompt.
 *
 */

public class VirtualCommandPrompt {
	private Directory root;
	private Directory currentDirectory;

	public VirtualCommandPrompt() {
		root = new Directory("Root:");
		currentDirectory = root;
	}

	public Directory getRoot() {
		return root;
	}

	public Directory getCurrentDirectory() {
		return currentDirectory;
	}

	/**
	 * Make a new directory in current directory if it doesn't exist already.
	 * 
	 * @param directoryName contains name of new directory
	 * @return message if directory already exist else return blank string
	 */
	public String makeDirectory(String directoryName) {
		String message = null;
		List<Directory> listOfChilren = currentDirectory.getListOfChildren();
		for (Directory child : listOfChilren) {
			String childName = child.getName();
			if (directoryName.equals(childName)) {
				message = "directory " + directoryName + " already exists.";
				return message;
			}
		}
		Directory newDirectory = new Directory(directoryName);
		newDirectory.setParent(currentDirectory);
		currentDirectory.addChild(newDirectory);
		return message;
	}

	/**
	 * change current directory to the subdirectory if directory exist
	 * 
	 * @param directoryName
	 * @return returns message if directory doesn't exist in current directory else
	 *         returns blank string
	 */
	public String changeDirectory(String directoryName) {
		String message = null;
		List<Directory> listOfChilren = currentDirectory.getListOfChildren();
		for (Directory child : listOfChilren) {
			String childName = child.getName();
			if (directoryName.equals(childName)) {
				currentDirectory = child;
				return message;
			}
		}
		message = "directory " + directoryName + " doesn't exists.";
		return message;
	}

	/**
	 * changes the current working directory to the parent of current.
	 * 
	 * @return old current directory
	 */
	public String moveToParentDirectory() {
		String currentDirectoryName = "";
		if (currentDirectory == root) {
			return currentDirectoryName;
		}
		currentDirectoryName = currentDirectory.getName();
		currentDirectory = currentDirectory.getParent();
		return currentDirectoryName;
	}

	/**
	 * gives list of subfolder of current working directory(1st level only)
	 * 
	 * @return list of subFolder
	 */
	public List<Directory> getListOfSubFolder() {
		List<Directory> listOfSubFolder = currentDirectory.getListOfChildren();
		return listOfSubFolder;
	}

	/**
	 * diplays whole directory structure
	 * 
	 * @param root contains root of virtual command prompt
	 */
	public void displayDirectoryStructure(Directory root) {
		List<Directory> listOfSubFolder = root.getListOfChildren();
		if (listOfSubFolder.size() == 0) {
			return;
		}
		for (Directory child : listOfSubFolder) {
			System.out.println("|-" + child.getName());
			displayDirectoryStructure(child);
		}
	}

	/**
	 * Find a folder in current folder or subfolders(recursively)
	 * 
	 * @param folder  contains folder to be search
	 * @param current contains current working directory
	 * @param path    contains path of folder
	 * @return returns path of folder.
	 */
	public String findFolder(String folder, Directory current, String path) {
		List<Directory> listOfSubFolder = current.getListOfChildren();
		if (listOfSubFolder.size() == 0) {
			return path;
		}
		for (Directory child : listOfSubFolder) {
			String childName = child.getName();
			if (folder.equals(childName)) {
				// multiple path of folder in various subdirectories are separated by space.
				path = childName + " " + path;
				// search for full path of folder
				Directory parent = child.getParent();
				while (parent != currentDirectory) {
					path = parent.getName() + "\\" + path;
					parent = parent.getParent();
				}
			}
			path = findFolder(folder, child, path);
		}
		return path;
	}

}