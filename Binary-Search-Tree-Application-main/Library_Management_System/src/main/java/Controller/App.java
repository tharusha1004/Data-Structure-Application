package Controller;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public class App 
{
    public static void main( String[] args ) throws IOException, ParseException, InterruptedException
    {
        GenerateKey newkey = new GenerateKey();
        BookTree books = new BookTree();

    //    books.addNode(newkey.getKey(), "Madolduwa", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "Madolduwa (English)", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "Ape Game", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "Gamperaliya", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "Kalu yugaya", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "yuganthaya", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "Manikkawatha", "M.Wikramasinghe", "M.D.Gunasena", null, true);
    //    books.addNode(newkey.getKey(), "Kaluwara Gedara", "M.Wikramasinghe", "M.D.Gunasena", null, true);
        
        // books.inOrderTraverseTree(books.root);

        // books.searchBook(books.root,"Mad");

        // books.deleteBook();
    }
}
