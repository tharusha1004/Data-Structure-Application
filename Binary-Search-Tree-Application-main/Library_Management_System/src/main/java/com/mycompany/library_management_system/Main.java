/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.library_management_system;

import Controller.GenerateKey;
import Controller.BookTree;
import Controller.Node;
import View.Login;
import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Janith Disanayake
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException, InterruptedException{
        GenerateKey newkey = new GenerateKey();
        BookTree books = new BookTree();
//
//         books.addBook(newkey.getKey(), "Madolduwa", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "Madolduwa (English)", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "Ape Game", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "Gamperaliya", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "Kalu yugaya", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "yuganthaya", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "Manikkawatha", "M.Wikramasinghe", "M.D.Gunasena", null);
//         books.addBook(newkey.getKey(), "Kaluwara Gedara", "M.Wikramasinghe", "M.D.Gunasena", null);
//         
//        List mynode = books.searchBook(books.root,"Mad");
//        for(int i=0; i<mynode.size(); i++)
//        {   Node newnode = (Node) mynode.get(i);
//            if(newnode!=null)
//            {   
//                System.out.println(newnode.title);
//            }
//        }

//        books.searchBook(books.root,"K");

//        books.deleteBook();

//        books.updateBook(books.root, "Manikk", "title", 63);

//        new Login().show();

        
//        books.returnBook(books.root, 45);

        new View.Login().setVisible(true);
           
    }
       
}
