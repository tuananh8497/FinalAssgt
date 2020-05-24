package automaticLanguageIdentificationSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class LanguageIdentification {

  // sort and count probability of Bigrams method
  public static double calculateProbability(ArrayList<String> unknownInput,
      Hashtable<String, String> language) {
    double score = 1; // declare score
    for (int i = 0; i < unknownInput.size(); i++) {
      // String element = Trigram.searchTrigrams(language, 0, language.size(), unknownInput.get(i));
      String element = Trigram.searchTrigrams(language, unknownInput.get(i));
      if (element.compareTo("Item not found") != 0) {
        // score = score * Double.parseDouble(element.substring(4));
        score = score * Double.parseDouble(element);
      } else {
        score = score * 0;
      }
    }
    return score;
  }

  public static String identifyLanguage(ArrayList<Double> score, String[] languages) {
    int index = 0;
    for (int i = 0; i < score.size() - 1; i++) {
      if (score.get(i).equals(Collections.max(score))) {
        index = score.indexOf(score.get(i));
      }
    }
    return languages[index];
  }
}
