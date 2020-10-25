package entity;

import enums.SentenceType;
import file.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


//composite
public class Sentence extends CompositeTextPart<Word> {
    private static final Logger logger = LogManager.getLogger(FileReader.class);
    private SentenceType type;

    public SentenceType getType() {
        return type;
    }

    public void setType(SentenceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Word word : parts) {
            result.append(word.toString() + " ");
        }
        return result.toString();
    }

    @Override
    public Sentence parse(String content) {
        logger.info("sentence parsing");
        String[] words = content.split("\\s+");
        for (String word : words) {
            Word wordEntity = new Word();
            this.getParts().add(wordEntity);
            wordEntity.parse(word);
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Sentence){
            Sentence s = (Sentence) obj;
            if(this.parts.equals(s.parts))
            {
                return true;
            }
        }
        return false;
    }
}
