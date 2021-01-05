/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package novo.ano.google.drive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filip
 */
public class NovoAnoGoogleDrive {

    /**
     * @param args the command line arguments
     */
    
    void listar(File directory) {
        if(directory.isDirectory()) {

            String[] subDirectory = directory.list();
            if(subDirectory != null) {
                for(String dir : subDirectory){
                    
                    String novo = directory.getPath();
                    novo=novo.replace("2020", "2021");
                    File novodiretorio = new File(novo);
                    boolean criou = novodiretorio.mkdirs();
                    listar(new File(directory + File.separator  + dir));
                }
            }
        }
    }
    public static void main(String[] args)  {
        // TODO code application logic here

        String caminho;
        
        //G:\Meu Drive\CORPORATIVO

        caminho = "g:" + File.separator + "Meu Drive" + File.separator + "CORPORATIVO";
        int ano;
        ano = 2021;

        File pasta = new File(caminho);
        File array[] = pasta.listFiles();
        

        for (File array1 : array) {
            if (array1.isDirectory()) {

                File pastaArea = new File(array1, "PESSOAL");

                if (pastaArea.exists()) {
                    File novaPasta = new File(pastaArea.getPath()+File.separator+Integer.toString(ano));
                    novaPasta.mkdir();
                    
                    File pastaAnoAnterior = new File(pastaArea, Integer.toString(ano - 1));
                    
                    
                    NovoAnoGoogleDrive novo = new NovoAnoGoogleDrive();
                    novo.listar(pastaAnoAnterior);

                }
                
                pastaArea = new File(array1, "FINANCEIRO");
                
                if (pastaArea.exists()) {
                    File novaPasta = new File(pastaArea.getPath()+File.separator+Integer.toString(ano));
                    novaPasta.mkdir();
                    
                    File pastaAnoAnterior = new File(pastaArea, Integer.toString(ano - 1));
                    
                    
                    NovoAnoGoogleDrive novo = new NovoAnoGoogleDrive();
                    novo.listar(pastaAnoAnterior);

                }
                
                 pastaArea = new File(array1, "CONTABILIDADE");
                
                if (pastaArea.exists()) {
                    File novaPasta = new File(pastaArea.getPath()+File.separator+Integer.toString(ano));
                    novaPasta.mkdir();
                    
                    File pastaAnoAnterior = new File(pastaArea, Integer.toString(ano - 1));
                    
                    
                    NovoAnoGoogleDrive novo = new NovoAnoGoogleDrive();
                    novo.listar(pastaAnoAnterior);

                }

            }

        }

    }

}
