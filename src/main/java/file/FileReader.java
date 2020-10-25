package file;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class FileReader {
    private static final Logger logger = LogManager.getLogger(FileReader.class);
    private File file = new File ("text.txt");

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String read()
    {
        logger.info("reading text");
        StringBuilder text = new StringBuilder();
        try(java.io.FileReader reader = new java.io.FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){

               text.append((char)c);
            }
        }
        catch(IOException ex){
            logger.error(ex);
        }
        return text.toString();
    }
}
