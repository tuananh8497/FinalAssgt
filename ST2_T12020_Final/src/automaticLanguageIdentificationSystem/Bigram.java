package automaticLanguageIdentificationSystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Bigram {

  private static DecimalFormat df = new DecimalFormat("#.########################");

  public static String sortCountBigrams(ArrayList<String> bigrams) {
    String outputResult = "";
    Collections.sort(bigrams); // sort all bigram
    String curr = bigrams.get(0); // get the first bigram
    double counter = 1;
    for (String next : bigrams) {
      if (next.equals(curr)) {
        counter++;
      } else {
        outputResult += curr + " " + df.format(counter / bigrams.size()) + ":";
        counter = 1;
        curr = next;
      }
    }
    outputResult += curr + " " + df.format(counter / bigrams.size()) + ":";
    return outputResult;
  }

  public static String sortBigrams(ArrayList<String> bigrams) {
    String outputResult = "";
    Collections.sort(bigrams); // sort all bigram
    String curr = bigrams.get(0); // get the first bigram
    double counter = 1;
    for (String next : bigrams) {
      if (next.equals(curr)) {
        counter++;
      } else {
        outputResult += curr + " ";
        counter = 1;
        curr = next;
      }
    }
    outputResult += curr + " ";
    return outputResult;
  }

  public static ArrayList<String> getBigrams(String filePath) {
    String unknown = FileProcessing.readUTF8File(filePath);
    ArrayList<String> extract = FileProcessing.extractWords(unknown, Locale.getDefault());
    System.out.println(extract); // Correct
    ArrayList<String> bigrams = new ArrayList<String>();
    for (int i = 0; i < extract.size(); i++) {
      for (int x = 0; x < extract.get(i).length() - 1; x++) {
        bigrams.add(extract.get(i).substring(x, x + 2));
      }
    }
    return bigrams;
  }


  public static ArrayList<String> sortAndGetBigramList(String filepath) {
    String sTemp = FileProcessing.readUTF8File(filepath);
    ArrayList<String> bigramExtract = FileProcessing.extractWords(sTemp, Locale.getDefault());
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < bigramExtract.size() - 1; i++) {
      for (int x = 0; x < bigramExtract.get(i).length() - 1; x++) {
        list.add(bigramExtract.get(i).substring(x, x + 2));
      }
    }
    String result = sortCountBigrams(list);
    List<String> item = (Arrays.asList(result.split("\\s*:\\s*")));
    ArrayList<String> bigramList = new ArrayList<String>(item);
    return bigramList;
  }

  public static String binarySearchBigrams(ArrayList<String> arr, int first, int last,
      String target) {
    int mid; // index of the midpoint
    String midvalue; // object that is assigned arr[mid]
    int origLast = last; // save original value of last
    while (first < last) { // test for nonempty sublist
      mid = (first + last) / 2;
      midvalue = arr.get(mid);
      if (midvalue.substring(0, 2).contains(target)) {
        return midvalue; // have a match
      } else if (target.compareTo(midvalue.substring(0, 2)) < 0) {
        last = mid; // search lower sublist. Reset last
      } else {
        first = mid + 1; // search upper sublist. Reset first
      }
    }
    return "Item not found"; // target not found
  }
}
