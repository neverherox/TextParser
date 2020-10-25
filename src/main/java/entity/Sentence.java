package entity;

import enums.SentenceType;


//composite
public class Sentence extends CompositeTextPart<Word> {
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
