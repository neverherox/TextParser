import entity.Text;
import org.junit.Test;
import service.TextService;

import static org.junit.Assert.assertEquals;

public class TestTextService {
    private final String initialText = "My name is Kirill. I`m from Belarus Grodno, welcome to my project! Hello. \n";
    private final String sortedText = "Hello. My name is Kirill. I`m from Belarus Grodno, welcome to my project! \n";

    @Test
    public void testSortText()
    {
        TextService textService = new TextService();
        Text actual = new Text().parse(initialText);
        Text expected = new Text().parse(sortedText);

        actual = textService.sortText(actual);

        assertEquals(expected, actual);
    }
}
