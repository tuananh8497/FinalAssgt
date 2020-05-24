package automaticLanguageIdentificationSystem;

import java.util.ArrayList;
import java.util.Hashtable;

public class AutomaticLanguageIdentified {

  public static void main(String[] args) {
    String[] language = {"English", "French", "German", "Italian", "Spanish"};
    String inputFolder =
        "C:\\Users\\tuana\\git\\FinalAssgt\\ST2_T12020_Final\\src\\automaticLanguageIdentificationSystem\\Learning\\";
    String outputFolder =
        "C:\\Users\\tuana\\git\\FinalAssgt\\ST2_T12020_Final\\src\\automaticLanguageIdentificationSystem\\Models\\";

    ArrayList<String> unknownInput = new ArrayList<String>(Trigram.getTrigrams(
        "C:\\Users\\tuana\\git\\FinalAssgt\\ST2_T12020_Final\\src\\automaticLanguageIdentificationSystem\\Testing\\Unknown7.txt"));

    ArrayList<Double> probabilityList = new ArrayList<Double>();

    // Learning and Calculate probability
    for (int i = 0; i < language.length; i++) {
      // ArrayList<String> list =
      // new ArrayList<String>(Trigram.sortAndGetBigramList(inputFolder + language[i] + ".txt"));
      Hashtable<String, String> list = new Hashtable<String, String>(
          Trigram.sortAndGetTrigramList(inputFolder + language[i] + ".txt"));
      FileProcessing.outputWordsToUTF8File(outputFolder + language[i] + "Model.txt", list);
      probabilityList.add(LanguageIdentification.calculateProbability(unknownInput, list));
    }

    // Identify Language
    String identifiedLanguage = LanguageIdentification.identifyLanguage(probabilityList, language);
    System.out.println(probabilityList);
    System.out.println(identifiedLanguage);
  }
}
