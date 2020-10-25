import entity.Text;
import entity.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.WordService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestWordService {
    private WordService wordService;
    private Text text;
    private final String initialText = "Hello. My name is Kirill. \n";

    @Before
    public void initTest() {
        wordService = new WordService();
        text = new Text().parse(initialText);
    }

    @Test
    public void testFindUniqWord() {
        Word actual = wordService.findUniqWord(text);
        Word expected = new Word().parse("Hello.");

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllWords() {
        List<Word> actual = wordService.getAllWords(text);
        List<Word> expected = new ArrayList<>();
        expected.add(new Word().parse("Hello."));
        expected.add(new Word().parse("My"));
        expected.add(new Word().parse("name"));
        expected.add(new Word().parse("is"));
        expected.add(new Word().parse("Kirill."));

        assertEquals(expected,actual);
    }

    @After
    public void afterTest() {
        wordService = null;
        text = null;
    }
}
