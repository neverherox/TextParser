package service;

import entity.Paragraph;
import entity.Sentence;
import entity.Text;
import entity.Word;

import java.util.ArrayList;
import java.util.List;

public class WordService {
    public Word findUniqWord(Text text) {
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
        List<Word> words = new ArrayList<>();
        for (Paragraph paragraph : text.getParts()) {
            for (Sentence sentence : paragraph.getParts()) {
                words.addAll(sentence.getParts());
            }
        }
        return words;
    }
}
