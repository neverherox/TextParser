package comparators;

import entity.Sentence;

import java.util.Comparator;

public class SentenceComparator implements Comparator<Sentence> {
    @Override
    public int compare(Sentence o1, Sentence o2) {
        if (o1.getParts().size() < o2.getParts().size()) {
            return -1;
        } else if (o1.getParts().size() > o2.getParts().size()) {
            return 1;
        }
        return 0;
    }
}
