package service;

import comparators.SentenceComparator;
import entity.Paragraph;
import entity.Text;
import file.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Collections;

public class TextService {
    private static final Logger logger = LogManager.getLogger(FileReader.class);
    public Text sortText(Text text) {
        logger.info("sorting text");
        for (Paragraph paragraph : text.getParts()) {
            Collections.sort(paragraph.getParts(), new SentenceComparator());
        }
        return text;
    }

}
