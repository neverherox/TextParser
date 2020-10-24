package service;

import entity.*;
import enums.SentenceType;

public class SentenceService {
    public SentenceType determineSentenceType(Sentence sentence) {
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
        for (Paragraph paragraph : text.getParts()) {
            for (Sentence sentence : paragraph.getParts()) {
                sentence.setType(determineSentenceType(sentence));
            }
        }
    }
}
