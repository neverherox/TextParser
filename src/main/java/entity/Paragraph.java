package entity;

import java.util.List;

//composite
public class Paragraph extends CompositeTextPart<Sentence> {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : parts) {
            result.append(sentence.toString() + " ");
        }
        return result.toString();

    }

    @Override
    public Paragraph parse(String content) {
        String[] sentences = content.split("[\\.|\\!|\\?]\\s+");
        for (String sentence : sentences) {
            int punctuationIndex = content.indexOf(sentence) + sentence.length();
            sentence += content.charAt(punctuationIndex);
            Sentence sentenceEntity = new Sentence();
            this.getParts().add(sentenceEntity);
            sentenceEntity.parse(sentence);
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Paragraph){
            Paragraph p = (Paragraph) obj;
            if(this.parts.equals(p.parts))
            {
                return true;
            }
        }
        return false;
    }
}
