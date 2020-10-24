package entity;

//leaf
public class Symbol implements TextPart {
    private char symbol;

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol + "";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Symbol){
            Symbol s = (Symbol) obj;
            if (this.symbol == s.symbol)
            {
                return true;
            }
        }
        return false;
    }
}
