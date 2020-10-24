package entity;

import java.util.ArrayList;
import java.util.List;

//composite
public class Text extends CompositeTextPart<Paragraph> {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Paragraph paragraph : parts) {
            result.append(paragraph.toString() + "\n");
        }
        return result.toString();
    }

    @Override
    public void parse(String content) {
        String[] paragraphs = content.split("\n");
        for (String paragraph : paragraphs) {
            Paragraph paragraphEntity = new Paragraph();
            this.parts.add(paragraphEntity);
            paragraphEntity.parse(paragraph);
        }
    }
}
