import console.Console;
import file.FileReader;
import file.FileWriter;

import java.io.File;
import java.util.*;

/**
 * Created by jeanlee on 2017/10/2.
 */
public class BKTreeTest {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        /*
            get the MaxDistance
         */

        FileReader fileReader1 = new FileReader(new File("testcase6/MaxDistance.txt"));

        String line1 = fileReader1.nextLine();
        int requiredDistance = Integer.parseInt(line1);

        BKTree vocabTree = new BKTree();
        LevenDistance levenDistance = new LevenDistance();
        FileReader fileReader = FileReader.on("testcase6/vocab.txt");
        fileReader.setIgnoreEmptyLines(true);
        /*
            initial tree
         */
        for (String line : fileReader) {
            vocabTree.add(line);
        }
        /*
            get word
         */
        FileReader fileReader2 = FileReader.on("testcase6/sentence.txt");
        fileReader2.setIgnoreEmptyLines(true);
        String sentences = fileReader2.nextLine();
        for (String sen : fileReader2){

            sentences = " " + sen;
        }

        String group[] = sentences.split(" ");
        String finalString = "";
        for (int i = 0; i < group.length; i++) {
            boolean isCorrect = false;
            FileReader fileReader3 = FileReader.on("testcase6/vocab.txt");
            fileReader.setIgnoreEmptyLines(true);
            for (String s1 : fileReader3) {
                if (vocabTree.match(group[i],0).size() != 0) {
                    isCorrect = true;
                }
            }
            if (!isCorrect) {
                finalString += group[i] + " ";
            }
        }
        FileWriter fileWriter = FileWriter.on("files/MisspelledWords.txt");
        if (finalString.length() == 0){
            fileWriter.println("0");
            fileWriter.close();
            return;
        }
        String finalGroup[] = finalString.split(" ");

        int count = 0;

        for (int i = 0; i <finalGroup.length; i++){
            Set<String> temp = vocabTree.match(finalGroup[i],requiredDistance);
            String result = "" + finalGroup[i] + ":";
            for (String word : temp){
                result += " " + word;
            }

            fileWriter.println(result);
        }
        fileWriter.close();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
