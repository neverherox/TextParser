package entity;

import java.util.List;

public class Word extends CompositeTextPart<Symbol> {
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Symbol symbol : parts) {
            result.append(symbol.toString());
        }
        return result.toString();
    }

    @Override
    public List<Symbol> parse(String content) {
        char[] symbols = content.toCharArray();
        for (char symbol : symbols) {
            Symbol symbolEntity = new Symbol();
            symbolEntity.setSymbol(symbol);
            this.getParts().add(symbolEntity);
        }
        return parts;
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
