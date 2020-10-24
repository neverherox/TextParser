package file;

import java.io.File;
import java.io.IOException;

public class FileReader {
    private File file = new File ("text.txt");

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String read()
    {
        StringBuilder text = new StringBuilder();
        try(java.io.FileReader reader = new java.io.FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){

               text.append((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return text.toString();
    }
}
