package entity;


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
    public Text parse(String content) {
        String[] paragraphs = content.split("\n");
        for (String paragraph : paragraphs) {
            Paragraph paragraphEntity = new Paragraph();
            this.parts.add(paragraphEntity);
            paragraphEntity.parse(paragraph);
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Text){
            Text t = (Text)obj;
            if(this.parts.equals(t.parts))
            {
                return true;
            }
        }
        return false;
    }
}
