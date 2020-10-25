package entity;


import file.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Word extends CompositeTextPart<Symbol> {
    private static final Logger logger = LogManager.getLogger(FileReader.class);

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : parts) {
            result.append(symbol.toString());
        }
        return result.toString();
    }

    @Override
    public Word parse(String content) {
        logger.info("word parsing");
        char[] symbols = content.toCharArray();
        for (char symbol : symbols) {
            Symbol symbolEntity = new Symbol();
            symbolEntity.setSymbol(symbol);
            this.getParts().add(symbolEntity);
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Word){
            Word w = (Word)obj;
            if(this.parts.equals(w.parts))
            {
                return true;
            }
        }
        return false;
    }
}
