package service;

import comparators.SentenceComparator;
import entity.Paragraph;
import entity.Text;

import java.util.Collections;

public class TextService {
    public void sortText(Text text) {
        for (Paragraph paragraph : text.getParts()) {
            Collections.sort(paragraph.getParts(), new SentenceComparator());
        }
    }

}
