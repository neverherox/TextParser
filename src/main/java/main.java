import entity.Text;
import service.SentenceService;
import service.TextService;
import service.WordService;


public class main {
    public static void main(String[] args) {
        file.FileReader fileReader = new file.FileReader();
        SentenceService sentenceService = new SentenceService();
        TextService textService = new TextService();
        WordService wordService = new WordService();

        Text text = new Text();
        Text textFromFile = new Text();

        text.parse("Hello, my name is Kirill. I`m from Belarus, Grodno! \n");
        textFromFile.parse(fileReader.read());

        sentenceService.determineAllSentencesType(text);
        sentenceService.determineAllSentencesType(textFromFile);

        textService.sortText(text);
        textService.sortText(textFromFile);

        System.out.println(textFromFile);
        System.out.println(text);

        System.out.println(wordService.findUniqWord(textFromFile));
        System.out.println(wordService.findUniqWord(text));
    }
}
