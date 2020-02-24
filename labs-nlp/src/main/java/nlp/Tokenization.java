package nlp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class Tokenization {
        public static void main(String[] arg){
            Logger logger = LoggerFactory.getLogger(Tokenization.class);
            logger.info("Beginning Java Logger slf4j");

            StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
            String txt = "testing, 1 2 3  ";
            CoreDocument doc = new CoreDocument(txt);
            stanfordCoreNLP.annotate(doc);

            List<CoreLabel> list = doc.tokens();

            for(CoreLabel lbl: list) {
                System.out.println(lbl.originalText());
            }
    }
}
