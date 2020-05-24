package automaticLanguageIdentificationSystem;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Locale;

public class Trigram {

  private static DecimalFormat df = new DecimalFormat("#.########################");

  public static Hashtable<String, String> sortCountBigrams(ArrayList<String> trigrams) {
    Hashtable<String, String> trigramProb = new Hashtable<>();
    String outputResult = "";
    String oo = "";
    Collections.sort(trigrams); // sort all bigram
    String curr = trigrams.get(0); // get the first bigram
    double counter = 1;
    for (String next : trigrams) {
      if (next.equals(curr)) {
        counter++;
      } else {
        // outputResult += curr + " " + df.format(counter / trigrams.size()) + ":";
        outputResult = df.format(counter / trigrams.size());
        trigramProb.put(curr, outputResult);
        counter = 1;
        curr = next;
      }
    }
    // outputResult += curr + " " + df.format(counter / trigrams.size()) + ":";
    trigramProb.put(curr, outputResult);
    return trigramProb;
  }

  // public static String sortBigrams(ArrayList<String> bigrams) {
  // String outputResult = "";
  // Collections.sort(bigrams); // sort all bigram
  // String curr = bigrams.get(0); // get the first bigram
  // double counter = 1;
  // for (String next : bigrams) {
  // if (next.equals(curr)) {
  // counter++;
  // } else {
  // outputResult += curr + " ";
  // counter = 1;
  // curr = next;
  // }
  // }
  // outputResult += curr + " ";
  // return outputResult;
  // }

  public static ArrayList<String> getTrigrams(String filePath) {
    String unknown = FileProcessing.readUTF8File(filePath);
    ArrayList<String> extract = FileProcessing.extractWords(unknown, Locale.getDefault());
    System.out.println(extract); // Correct
    ArrayList<String> trigrams = new ArrayList<String>();
    for (int i = 0; i < extract.size(); i++) {
      for (int x = 0; x < extract.get(i).length() - 2; x++) {
        trigrams.add(extract.get(i).substring(x, x + 3));
      }
    }
    return trigrams;
  }


  public static Hashtable<String, String> sortAndGetTrigramList(String filepath) {
    String sTemp = FileProcessing.readUTF8File(filepath);
    ArrayList<String> bigramExtract = FileProcessing.extractWords(sTemp, Locale.getDefault());
    ArrayList<String> list = new ArrayList<String>();
    for (int i = 0; i < bigramExtract.size() - 1; i++) {
      for (int x = 0; x < bigramExtract.get(i).length() - 2; x++) {
        list.add(bigramExtract.get(i).substring(x, x + 3));
      }
    }
    // String result = sortCountBigrams(list);
    // List<String> item = (Arrays.asList(result.split("\\s*:\\s*")));
    // ArrayList<String> bigramList = new ArrayList<String>(item);
    Hashtable<String, String> bigramList = new Hashtable<>();
    bigramList = sortCountBigrams(list);
    return bigramList;
  }

  public static String binarySearchTrigrams(ArrayList<String> arr, int first, int last,
      String target) {
    int mid; // index of the midpoint
    String midvalue; // object that is assigned arr[mid]
    int origLast = last; // save original value of last
    while (first < last) { // test for nonempty sublist
      mid = (first + last) / 2;
      midvalue = arr.get(mid);
      if (midvalue.substring(0, 3).contains(target)) {
        return midvalue; // have a match
      } else if (target.compareTo(midvalue.substring(0, 3)) < 0) {
        last = mid; // search lower sublist. Reset last
      } else {
        first = mid + 1; // search upper sublist. Reset first
      }
    }
    return "Item not found"; // target not found
  }

  public static String searchTrigrams(Hashtable<String, String> hsh, String target) {
    String value = "";
    for (int i = 0; i < hsh.size(); i++) {
      if (hsh.containsKey(target)) {
        ;
        value = hsh.get(target);
      } else {
        return "Item not found";
      } ;
    }
    return value;
  }
}
