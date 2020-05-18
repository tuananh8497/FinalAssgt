package automaticLanguageIdentificationSystem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class FileProcessing {

  // readUTF8File method
  public static String readUTF8File(String filePath) {
    StringBuilder fileContent = new StringBuilder();
    try {
      Reader reader = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
      BufferedReader bufferedReader = new BufferedReader(reader);
      String s;
      while ((s = bufferedReader.readLine()) != null) {
        fileContent.append(s + "\n");
      }
      bufferedReader.close();
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fileContent.toString();
  }

  // extractWords method
  public static ArrayList extractWords(String inputText, Locale currentLocale) {
    ArrayList wordList = new ArrayList();
    BreakIterator wordIterator = BreakIterator.getWordInstance(currentLocale);
    wordIterator.setText(inputText);
    int start = wordIterator.first();
    int end = wordIterator.next();
    while (end != BreakIterator.DONE) {
      String word = inputText.substring(start, end);
      word = word.toLowerCase();
      if (Character.isLetter(word.charAt(0)) && word.length() > 1) {
        wordList.add(word);
      }
      start = end;
      end = wordIterator.next();
    }
    return wordList;
  }

  // outputWordsToUTF8File method
  public static void outputWordsToUTF8File(String filePath, ArrayList wordList) {
    try {
      Writer writer =
          new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_16);
      PrintWriter printWriter = new PrintWriter(writer);
      Collections.sort(wordList);
      for (Object word : wordList) {
        printWriter.println(word);
      }
      writer.close();
      printWriter.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
