package automaticLanguageIdentificationSystem;

import java.util.ArrayList;

public class Assignment1 {

  public static void main(String[] args) {
    String[] language = {"English", "French", "German", "Italian", "Spanish"};
    String inputFolder =
        "C:\\Users\\tuana\\git\\FinalAssgt\\ST2_T12020_Final\\src\\automaticLanguageIdentificationSystem\\Learning\\";
    String outputFolder =
        "C:\\Users\\tuana\\git\\FinalAssgt\\ST2_T12020_Final\\src\\automaticLanguageIdentificationSystem\\Models\\";

    ArrayList<String> unknownInput = new ArrayList<String>(Bigram.getBigrams(
        "C:\\Users\\tuana\\git\\FinalAssgt\\ST2_T12020_Final\\src\\automaticLanguageIdentificationSystem\\Testing\\Unknown4.txt"));

    ArrayList<Double> probabilityList = new ArrayList<Double>();

    // Learning and Calculate probability
    for (int i = 0; i < language.length; i++) {
      ArrayList<String> list =
          new ArrayList<String>(Bigram.sortAndGetBigramList(inputFolder + language[i] + ".txt"));
      FileProcessing.outputWordsToUTF8File(outputFolder + language[i] + "Model.txt", list);
      probabilityList.add(LanguageIdentification.calculateProbability(unknownInput, list));
    }

    // Identify Language
    String identifiedLanguage = LanguageIdentification.identifyLanguage(probabilityList, language);
    System.out.println(probabilityList);
    System.out.println(identifiedLanguage);

  }
}
