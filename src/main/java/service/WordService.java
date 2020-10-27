package service;

import entity.Paragraph;
import entity.Sentence;
import entity.Text;
import entity.Word;
import file.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class WordService {
    private static final Logger logger = LogManager.getLogger(WordService.class);

    public Word findUniqWord(Text text) {
        logger.info("finding uniq word");
        Sentence firstSentence = text.getParts().get(0).getParts().get(0);
        List<Word> words = getAllWords(text);
        for(Word word : firstSentence.getParts())
        {
            words.remove(word);
        }
        for (Word word : firstSentence.getParts()) {
            if (!words.contains(word)) {
                return word;
            }
        }
        return null;
    }

    public List<Word> getAllWords(Text text) {
        logger.info("getting all words");

        List<Word> words = new ArrayList<>();
        for (Paragraph paragraph : text.getParts()) {
            for (Sentence sentence : paragraph.getParts()) {
                words.addAll(sentence.getParts());
            }
        }
        return words;
    }
}
