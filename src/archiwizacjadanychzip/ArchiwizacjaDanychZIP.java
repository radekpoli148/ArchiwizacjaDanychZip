package archiwizacjadanychzip;

import java.io.*;
import java.util.zip.*;

public class ArchiwizacjaDanychZIP 
{
    public static final int buffor = 1024;
    public static void main(String[] args) 
    {
        String[] tab = new String[] {"build.xml", "manifest.mf", "baza.txt", "Obrazek.jpg"};
        byte tmpData[] = new byte[buffor];
        try
        {
            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("MojZip.zip")));
            
            for(int i = 0; i < tab.length; i++)
            {
                BufferedInputStream inS = new BufferedInputStream(new FileInputStream(tab[i]), buffor);

                zOutS.putNextEntry(new ZipEntry(tab[i]));

                int counter;
                while((counter = inS.read(tmpData, 0, buffor))!= -1)
                    zOutS.write(tmpData, 0, counter);

                zOutS.closeEntry();
                inS.close();
            }
            zOutS.close();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
        
    
}
