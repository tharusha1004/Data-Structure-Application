package Controller;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BookTree {
    
    public Node root;
    public String path = "src\\main\\java\\main\\books\\book1.json";
    List nodelist = new ArrayList<Node>();
    int nodecounter=0;
    
    FileWriter file;
    FileReader reader;
    JSONParser jsonparser;
    JSONObject jsonobj;  
    JSONObject obj;

    public BookTree() throws IOException, ParseException
    {
        int counter=1;
        while(new File(path).exists()){
            
            reader = new FileReader("src\\main\\java\\main\\books\\book"+counter+".json");
            jsonparser = new JSONParser();
            jsonobj = (JSONObject) jsonparser.parse(reader);

            int key = (int)(long) jsonobj.get("key");
            String title = (String)  jsonobj.get("title");
            String author = (String) jsonobj.get("author");
            String publisher = (String) jsonobj.get("publisher");
            String filename = (String) jsonobj.get("filename");
            boolean avb = (Boolean) jsonobj.get("avb");

            // System.out.println(key);
            // System.out.println(title);
            // System.out.println(author);
            // System.out.println(publisher);
            // System.out.println();
            
            addNode(key, title, author, publisher, filename, avb, false);
            ++counter;
            path = "src\\main\\java\\main\\books\\book"+counter+".json";
        }
    }

    public void addNode(int key, String title, String author, String publisher, String filename, boolean avb, boolean createfile) throws IOException
    {
        Node newNode = new Node(key, title, author, publisher, filename, avb, createfile);

        if(root == null)
        {   root = newNode;
        }
        else
        {   Node focusNode = root;
            Node parent;
            
            while(true)
            {   
                parent = focusNode;
                if(key < focusNode.key)
                {   
                    focusNode = focusNode.leftChild;
                    if(focusNode == null)
                    {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else
                {
                    focusNode = focusNode.rightChild;
                    if(focusNode == null)
                    {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean addBook(int key, String title, String author, String publisher, String filename) throws IOException
    {
        addNode(key, title, author, publisher, filename, true, true);
        return true;
    }
    
    public void preOrderTraverseTree(Node focusNode)
    {
        if(focusNode != null)
        {
            System.out.print(focusNode.key);
            System.out.print("\t");
            System.out.print(focusNode.title);
            System.out.print("\t");
            System.out.print(focusNode.author);
            System.out.print("\t");
            System.out.print(focusNode.publisher);
            System.out.println("\t");
            
            inOrderTraverseTree(focusNode.leftChild);

            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public List inOrderTraverseTree(Node focusNode)
    {
        if(focusNode != null)
        {
            inOrderTraverseTree(focusNode.leftChild);

            nodelist.add(focusNode);
            
            inOrderTraverseTree(focusNode.rightChild);
        }
        return nodelist;
    }
    public List searchBook(Node focusNode,String name)
    {
        if(focusNode != null)
        {
            searchBook(focusNode.leftChild, name);

            if(name.equals(focusNode.title))
            {
                nodelist.add(focusNode);
            }
            else if(name.length()==1)
            {
                if(name.charAt(0)==focusNode.title.charAt(0))
                    nodelist.add(focusNode);              
            }
            else if(name.charAt(0)==focusNode.title.charAt(0))
            {   String search_name=focusNode.title;
                int i=1;
                // System.out.println(focusNode.title);
                while(search_name.charAt(i)==name.charAt(i))
                {
                    search_name=focusNode.title;
                    ++i;
                    if(name.length()==i)
                    {   
                        nodelist.add(focusNode);
                        break;
                    }
                }
            } 
            
            searchBook(focusNode.rightChild, name);
        }
        return nodelist;
    }

    public void deleteBook() throws InterruptedException
    {     
        new File("src\\main\\java\\main\\books\\book7.json").setExecutable(false); 
        if (new File("src\\main\\java\\main\\books\\book7.json").delete())
            System.out.println("File is deleted");
        else 
            System.out.println("File is not deleted");
    }

    public boolean updateBook(Node focusNode, String update_name, String update_item, int ikey) throws FileNotFoundException, IOException, ParseException
    {
        if(focusNode != null)
        {   
            updateBook(focusNode.leftChild, update_name, update_item, ikey);
            
//           
            reader = new FileReader("src\\main\\java\\main\\books\\"+focusNode.filename+".json");
            System.out.println(focusNode.filename);
            jsonparser = new JSONParser();
            jsonobj = (JSONObject) jsonparser.parse(reader);

            if(ikey == focusNode.key)
            {
                // Path fpath = focusNode

                if(update_item.equals("title"))
                {
                    int key = (int)(long) jsonobj.get("key");
                    String title = update_name;
                    String author = (String) jsonobj.get("author");
                    String publisher = (String) jsonobj.get("publisher");
                    String filename = (String) jsonobj.get("filename");
                    Boolean avb = (Boolean) jsonobj.get("avb");

                    obj = new JSONObject();

                    obj.put("key", key);
                    obj.put("title", title);
                    obj.put("author", author);
                    obj.put("publisher", publisher);
                    obj.put("filename", filename);   
                    obj.put("avb", avb);   
                    
                    file = new FileWriter("src\\main\\java\\main\\books\\"+focusNode.filename+".json", false);
                    file.write(obj.toJSONString());
                    file.close();
                    status = true;
                }
                else if(update_item.equals("author"))
                {

                    int key = (int)(long) jsonobj.get("key");
                    String title = (String) jsonobj.get("title");
                    String author = update_name;
                    String publisher = (String) jsonobj.get("publisher");
                    String filename = (String) jsonobj.get("filename");
                    Boolean avb = (Boolean) jsonobj.get("avb");

                    obj = new JSONObject();

                    obj.put("key", key);
                    obj.put("title", title);
                    obj.put("author", author);
                    obj.put("publisher", publisher);
                    obj.put("filename", filename); 
                    obj.put("avb", avb);   
                    
                    file = new FileWriter("src\\main\\java\\main\\books\\"+focusNode.filename+".json", false);
                    file.write(obj.toJSONString());
                    file.close();
                    status = true;
                }
                else if(update_item.equals("publisher"))
                {
                    int key = (int)(long) jsonobj.get("key");
                    String title = (String) jsonobj.get("title");
                    String author = (String) jsonobj.get("author");
                    String publisher = update_name;
                    String filename = (String) jsonobj.get("filename");
                    Boolean avb = (Boolean) jsonobj.get("avb");

                    obj = new JSONObject();

                    obj.put("key", key);
                    obj.put("title", title);
                    obj.put("author", author);
                    obj.put("publisher", publisher);
                    obj.put("filename", filename);   
                    obj.put("avb", avb);   
                    
                    file = new FileWriter("src\\main\\java\\main\\books\\"+focusNode.filename+".json", false);
                    file.write(obj.toJSONString());
                    file.close();
                    status = true;
                }
            } 
                
            updateBook(focusNode.rightChild, update_name, update_item, ikey);
        }
        return status;
    }

    boolean status=false;
    public boolean borrowBook(Node focusnode, int ikey) throws IOException, ParseException
    {   
        if(focusnode != null)
        {
            borrowBook(focusnode.leftChild, ikey);

            if(ikey == focusnode.key)
            {
                reader = new FileReader("src\\main\\java\\main\\books\\"+focusnode.filename+".json");
                System.out.println(focusnode.filename);
                jsonparser = new JSONParser();
                jsonobj = (JSONObject) jsonparser.parse(reader);

                obj = new JSONObject();

                obj.put("key", (int)(long) jsonobj.get("key"));
                obj.put("title", (String) jsonobj.get("title"));
                obj.put("author", (String) jsonobj.get("author"));
                obj.put("publisher", (String) jsonobj.get("publisher"));
                obj.put("filename", (String) jsonobj.get("filename")); 
                obj.put("avb", false);    
                    
                file = new FileWriter("src\\main\\java\\main\\books\\"+focusnode.filename+".json", false);
                file.write(obj.toJSONString());
                file.close();
                status = true;
            }
            borrowBook(focusnode.rightChild, ikey);
            
        }
        return status;
    }

    public boolean returnBook(Node focusnode, int ikey) throws IOException, ParseException
    {
        if(focusnode != null)
        {
            returnBook(focusnode.leftChild, ikey);

            if(ikey == focusnode.key)
            {
                reader = new FileReader("src\\main\\java\\main\\books\\"+focusnode.filename+".json");
                System.out.println(focusnode.filename);
                jsonparser = new JSONParser();
                jsonobj = (JSONObject) jsonparser.parse(reader);

                obj = new JSONObject();

                obj.put("key", (int)(long) jsonobj.get("key"));
                obj.put("title", (String) jsonobj.get("title"));
                obj.put("author", (String) jsonobj.get("author"));
                obj.put("publisher", (String) jsonobj.get("publisher"));
                obj.put("filename", (String) jsonobj.get("filename")); 
                obj.put("avb", true);    
                    
                file = new FileWriter("src\\main\\java\\main\\books\\"+focusnode.filename+".json", false);
                file.write(obj.toJSONString());
                file.close();
                status = true;
            }

            returnBook(focusnode.rightChild, ikey);
        }
        return status;
    }

    public void BorrowBooks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

