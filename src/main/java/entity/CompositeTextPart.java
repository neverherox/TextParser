package entity;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeTextPart<T extends TextPart> implements TextPart {
    protected List<T> parts = new ArrayList<T>();

    public List<T> getParts() {
        return parts;
    }

    public void setParts(List<T> parts) {
        this.parts = parts;
    }

    public abstract List<T> parse(String content);

}
