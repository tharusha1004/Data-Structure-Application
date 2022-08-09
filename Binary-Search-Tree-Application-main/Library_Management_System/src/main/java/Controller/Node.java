package Controller;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class Node {
    
    public int key;
    Node leftChild;
    Node rightChild;

    public String name;
    public String title;
    public String author;
    public String publisher;
    public String filename;
    public boolean avb;

    JSONObject obj;

    Node(int key, String title, String author, String publisher,String filename, boolean avb, boolean createfile) throws IOException, NullPointerException
    {
        this.key = key;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.filename = filename;
        this.avb = avb;
        if(createfile)
            createJSON();
    }

    public String toString()
    {
        return name + " has a key " + key;
    }

    public void createJSON() throws IOException
    {
        obj = new JSONObject();

        obj.put("key", key);
        obj.put("title", title);
        obj.put("author", author);
        obj.put("publisher", publisher);
        obj.put("avb", avb);
        

        boolean fileavb=false;
        int counter=1;
        String path = "src\\main\\java\\main\\books\\book1.json";
//  src\main\java\main\books
        while(!fileavb)
        {
            if(new File(path).exists())
            {
                ++counter;
                path = "src\\main\\java\\main\\books\\book"+counter+".json";
                filename = "book"+counter;
                obj.put("filename",filename);                
                fileavb=false;
            }
            else{
                // write to file
                FileWriter file = new FileWriter(path, false);
                file.write(obj.toJSONString());
                file.write("\n");
                file.close();
                System.out.println("file has been creted");
                fileavb=true;
            }
            
        }
    }
}