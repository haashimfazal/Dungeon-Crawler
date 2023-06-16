package gui.animation;

import java.util.LinkedList;
import org.jsfml.window.*;
import org.jsfml.window.event.*;
import org.jsfml.graphics.*;
import org.jsfml.system.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.Reader;

public class FileLoader {
    RenderWindow window;
    
    /**
     * Constructor for File loader
     * @param win RenderWindow instance FileLoader will be drawn on.
     */
    public FileLoader(RenderWindow win) {

        window = win;

        
    }

//   public Texture[] LoadTextureArray(String filePath,int a) throws IOException{
//     // String[] pathnames;
//     // File f = new File(filePath);
//     // int size=0;
//     // pathnames = f.list();
//     // for (String pathname : pathnames) {
//     //     size++;
//     //     //System.out.println(pathname);
//     // }
//     // Texture[] t=new Texture[size];
//     // int newN=0;
//     // String filePathExt=filePath.concat("/");
//     // String filePathExt2=filePathExt.concat(toString.valueOf(i));
//     // for (String pathname : pathnames) {
        
        
//     //         System.out.println(filePathExt.concat(pathname));
        
//     //     Texture temp=new Texture();
//     //     temp.loadFromFile(Paths.get(filePathExt.concat(pathname)));
//     //      t[newN]=temp;
         
        
//     //     newN++;
//     // }
//     // return t;
//     //System.out.println(t);
//     }

    /**
     * Loads an array of textures.
     * @param filePath Location of textures
     * @param a Number of tectures in directory.
     * @return Array of Textures
     * @throws IOException Event file isn't found in specifed directory.
     */
    public Texture[] LoadTextureArray(String filePath,int a) throws IOException{
        Texture[] t=new Texture[a];
        for(int i=0;i<a;i++){
            String filePathExt=filePath.concat("/");
            String filePathExt2=filePathExt.concat(String.valueOf(i));
            String filePathExt3=filePathExt2.concat(".png");
            Texture temp=new Texture();
            temp.loadFromFile(Paths.get(filePathExt3));
            t[i]=temp;
            //System.out.println(filePathExt3);
        }
        return t;

    }
}
