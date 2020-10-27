package service;

import entity.*;
import enums.SentenceType;
import file.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SentenceService {
    private static final Logger logger = LogManager.getLogger(SentenceService.class);

    public SentenceType determineSentenceType(Sentence sentence) {
        logger.info("determining sentence type");
        Word wordEntity = sentence.getParts().get(sentence.getParts().size() - 1);
        String word = wordEntity.toString();
        char punctuation = word.charAt(word.length() - 1);
        switch (punctuation) {
            case '!':
                return SentenceType.EXCLAMATORY;
            case '?':
                return SentenceType.INTERROGATIVE;
        }
        return SentenceType.NARRATIVE;
    }

    public void determineAllSentencesType(Text text) {
        logger.info("determining all sentences type");
        for (Paragraph paragraph : text.getParts()) {
            for (Sentence sentence : paragraph.getParts()) {
                sentence.setType(determineSentenceType(sentence));
            }
        }
    }
}
