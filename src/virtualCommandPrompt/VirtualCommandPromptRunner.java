package virtualCommandPrompt;

import java.util.*;

public class VirtualCommandPromptRunner {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		VirtualCommandPrompt vcp = new VirtualCommandPrompt();
		System.out.println("********Welcome to virtual command prompt*********");
		System.out.println();
		String currentDirectory = vcp.getRoot().getName() + "\\";
		while (true) {
			System.out.print(currentDirectory + ">");
			String command = scanner.next();
			String directoryName;
			String message;
			switch (command) {
			case "mkdir":
				directoryName = scanner.nextLine();
				directoryName.trim();
				message = vcp.makeDirectory(directoryName);
				if (message != null) {
					System.out.println(message);
				}
				break;
			case "cd":
				directoryName = scanner.nextLine();
				directoryName.trim();
				message = vcp.changeDirectory(directoryName);
				if (message != null) {
					System.out.println(message);
				} else {
					currentDirectory += "\\" + directoryName;
				}
				break;
			case "bk":
				String movedDirectoryName = vcp.moveToParentDirectory();
				currentDirectory = currentDirectory.replace(("\\" + movedDirectoryName), "");
				break;
			case "ls":
				List<Directory> subFolderList = vcp.getListOfSubFolder();
				for (Directory subFolder : subFolderList) {
					Date creationTime = subFolder.getCreationTime();
					String name = subFolder.getName();
					System.out.println(creationTime + " " + name);
				}
				int size = subFolderList.size();
				System.out.println(size + "Folder(s)");
				break;
			case "find":
				String folderToFind = scanner.nextLine();
				Directory current = vcp.getCurrentDirectory();
				String path = "";
				path = vcp.findFolder(folderToFind, current, path);
				displayPath(path);
				break;
			case "tree":
				Directory root = vcp.getRoot();
				vcp.displayDirectoryStructure(root);
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("command " + command + " doesn't exist");
			}
		}
	}

	/**
	 * Helper method to display path
	 * 
	 * @param path
	 */
	private static void displayPath(String path) {
		if (path.length() == 0) {
			System.out.println("folder doesn't exist");
		} else {
			String[] pathArray = path.split(" ");
			for (String folderPath : pathArray) {
				System.out.println("." + folderPath);
			}
		}
	}

}