
import java.io.*;
import java.util.*;

//slang word
class SlangWord {
    HashMap<String, Pair> slangMap = new HashMap<String, Pair>();
    static List<Pair> history = new ArrayList<Pair>();

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        SlangWord slangManager = new SlangWord();
        slangManager.getSlangWords();
        System.out.println("Choose an option:");
        System.out.println("1. Look up a word by slang");
        System.out.println("2. Look up a word by meaning");
        System.out.println("3. History");
        System.out.println("4. Add a word");
        System.out.println("5. Edit a word");
        System.out.println("6. Delete a word");
        System.out.println("7. Reset");
        System.out.println("8. Random a word");
        System.out.println("9. Quiz a word by slang");
        System.out.println("10. Quiz a word by meaning");
        System.out.println("11. Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option != 11) {
            if (option == 1) {
                System.out.println("Enter a slang word:");
                String slang = scanner.next();
                Pair pair = slangManager.slangMap.get(slang);
                if (pair == null) {
                    System.out.println("No such word");
                } else {
                    System.out.println(pair.word + ": " + pair.meaning);
                    history.add(pair);
                }
            } else if (option == 2) {
                System.out.println("Enter a meaning word:");
                String meaning = scanner.next();
                Set<String> keys = slangManager.slangMap.keySet();
                for (String key : keys) {
                    Pair pair = slangManager.slangMap.get(key);
                    if (pair.meaning.equals(meaning)) {
                        System.out.println(key + ": " + pair.meaning);
                        history.add(pair);
                    }
                }
            } else if (option == 3) {
                System.out.println("History:");
                for (Pair pair : history) {
                    System.out.println(pair.word + ": " + pair.meaning);
                }
            } else if (option == 4) {
                System.out.println("Enter a slang word:");
                String slang = scanner.next();
                System.out.println("Enter a meaning word:");
                String meaning = scanner.next();
                Pair pair = new Pair();
                pair.word = slang;
                pair.meaning = meaning;
                slangManager.slangMap.put(slang, pair);
                System.out.println("Added successfully");
            } else if (option == 5) {
                System.out.println("Enter a slang word:");
                String slang = scanner.next();
                Pair pair = slangManager.slangMap.get(slang);
                if (pair == null) {
                    System.out.println("No such word");
                } else {
                    System.out.println("Enter a meaning word:");
                    String meaning = scanner.next();
                    pair.meaning = meaning;
                    System.out.println("Edited successfully");
                }
            } else if(option ==6){
                System.out.println("Enter a slang word:");
                String slang = scanner.next();
                Pair pair = slangManager.slangMap.get(slang);
                if (pair == null) {
                    System.out.println("No such word");
                } else {
                    slangManager.slangMap.remove(slang);
                    System.out.println("Deleted successfully");
                }
            } else if (option == 7) {
                slangManager.slangMap.clear();
                history.clear();
                System.out.println("Reset successfully");
            } else if (option == 8) {
                Set<String> keys = slangManager.slangMap.keySet();
                int index = (int) (Math.random() * keys.size());
                String key = (String) keys.toArray()[index];
                Pair pair = slangManager.slangMap.get(key);
                System.out.println(pair.word + ": " + pair.meaning);
                history.add(pair);
            } else if (option == 9) {
                System.out.println("Enter a slang word:");
                String slang = scanner.next();
                Pair pair = slangManager.slangMap.get(slang);
                if (pair == null) {
                    System.out.println("No such word");
                } else {
                    System.out.println("Enter a meaning word:");
                    String meaning = scanner.next();
                    if (pair.meaning.equals(meaning)) {
                        System.out.println("Correct");
                    } else {
                        System.out.println("Wrong");
                    }
                }
            } else if (option == 10) {
                System.out.println("Enter a meaning word:");
                String meaning = scanner.next();
                Set<String> keys = slangManager.slangMap.keySet();
                for (String key : keys) {
                    Pair pair = slangManager.slangMap.get(key);
                    if (pair.meaning.equals(meaning)) {
                        System.out.println(key + ": " + pair.meaning);
            }
        }

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
            try{pair.word = parts[0];
            pair.meaning = parts[1];
            System.out.println(pair.word + "has meaning " + pair.meaning);
            slangMap.put(pair.word, pair);
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Close the input stream
        fstream.close();
    }

    public String getMeaning(String word) {
        Pair pair = slangMap.get(word);
        if (pair == null) {
            return "";
        }
        return pair.meaning;
    }

    public String getWord(String meaning) {
        for (String key : slangMap.keySet()) {
            Pair pair = slangMap.get(key);
            if (pair.meaning.equals(meaning)) {
                return pair.word;
            }
        }
        return "";
    }

    public void addSlangWord(String word, String meaning) {
        Pair pair = new Pair();
        pair.word = word;
        pair.meaning = meaning;
        slangMap.put(word, pair);
    }

    public void removeSlangWord(String word) {
        slangMap.remove(word);
    }

    public void printSlangWords() {
        for (String key : slangMap.keySet()) {
            Pair pair = slangMap.get(key);
            System.out.println(pair.word + " has meaning " + pair.meaning);
        }
    }

    public void editSlangWord(String word, String meaning) {
        Pair pair = slangMap.get(word);
        pair.meaning = meaning;
    }

    public void randomSlangWord() {
        Random rand = new Random();
        int randomNum = rand.nextInt(slangMap.size());
        int i = 0;
        for (String key : slangMap.keySet()) {
            Pair pair = slangMap.get(key);
            if (i == randomNum) {
                System.out.println(pair.word + " has meaning " + pair.meaning);
                return;
            }
            i++;
        }
    }

}