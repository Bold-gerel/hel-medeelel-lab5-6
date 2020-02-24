package nlp;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SentimentRun {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(LemmaRun.class);
        logger.info("sentiment logger started");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String txt = "The house has a garden. John and Sarah play in the garden. They have a dog. John and Sarah like to play with the dog.";
        CoreDocument doc = new CoreDocument(txt);

        stanfordCoreNLP.annotate(doc);

        List<CoreSentence> sens= doc.sentences();
        for (CoreSentence sen: sens){
            String sentiment = sen.sentiment();
            System.out.println(sen +"\t "+sentiment);
        }
    }
}
