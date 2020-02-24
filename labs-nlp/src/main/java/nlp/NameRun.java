package nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NameRun {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(LemmaRun.class);
        logger.info("Name logger started");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String txt = "The house has a garden. John and Sarah play in the garden. They have a dog. John and Sarah like to play with the dog.";
        CoreDocument doc = new CoreDocument(txt);

        stanfordCoreNLP.annotate(doc);

        List<CoreLabel> lst = doc.tokens();
        for (CoreLabel lbl: lst){
            String ner = lbl.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            System.out.println(lbl.originalText()+": "+ner);
        }

    }
}
