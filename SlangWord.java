
import java.io.*;
import java.util.*;

//slang word
class SlangWord {
    HashMap <String, Pair> slangMap = new HashMap<String, Pair>();

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        SlangWord slangManager = new SlangWord();
        slangManager.getSlangWords();
    }

    public void getSlangWords() throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("slang.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            String[] parts = strLine.split("`");
            Pair pair = new Pair();
            pair.word = parts[0];
            pair.meaning = parts[1];
            //System.out.println(pair.word + "has meaning " + pair.meaning);
            slangMap.put(pair.word, pair);
        }

        // Close the input stream
        fstream.close();
    }
}