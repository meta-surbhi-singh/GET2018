package virtualCommandPrompt;

import java.util.*;

/**
 * this class represents directory.
 *
 */
public class Directory {
    private String name;
    private List<Directory> listOfChildren;
    private Directory parent;
    private Date creationTime;
    
    public Directory(String name)
    {
        this.name=name;
        listOfChildren=new ArrayList<Directory>();
        parent=null;
        creationTime=new Date();
    }

    public Date getCreationTime() {
        Date time=creationTime;
        return time;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Directory> getListOfChildren() {
        return listOfChildren;
    }

    public void setListOfChildren(List<Directory> listOfChildren) {
        this.listOfChildren = listOfChildren;
    }
    
    /**
     * add child of directory to the list of children
     * @param child
     */
    public void addChild(Directory child)
    {
        listOfChildren.add(child);
    }

}