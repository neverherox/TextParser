import entity.Sentence;
import enums.SentenceType;
import org.junit.Test;
import service.SentenceService;

import static org.junit.Assert.assertEquals;

public class TestSentenceService {
    private final String initialSentence = "Hello from Belarus Grodno! \n";

    @Test
    public void testDetermineSentenceType()
    {
        SentenceService sentenceService = new SentenceService();
        Sentence sentence = new Sentence().parse(initialSentence);;
        SentenceType expected = SentenceType.EXCLAMATORY;
        SentenceType actual = sentenceService.determineSentenceType(sentence);
        assertEquals(expected,actual);
    }
}
