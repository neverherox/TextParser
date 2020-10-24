package entity;

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
    public void parse(String content) {
        char[] symbols = content.toCharArray();
        for (char symbol : symbols) {
            Symbol symbolEntity = new Symbol();
            symbolEntity.setSymbol(symbol);
            this.getParts().add(symbolEntity);
        }
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
