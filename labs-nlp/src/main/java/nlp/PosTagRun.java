package nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PosTagRun {
    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(PosTagRun.class);
        logger.info("PosTagRun logger started");

        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String txt = "The house has a garden. John and Sarah play in the garden. They have a dog. John and Sarah like to play with the dog.";
        CoreDocument doc = new CoreDocument(txt);

        stanfordCoreNLP.annotate(doc);

        List<CoreLabel> lblList = doc.tokens();
        for (CoreLabel lbl: lblList){
            String pos= lbl.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            System.out.println(lbl.originalText()+": "+pos);
        }

    }
}
