
import java.io.*;
import java.util.*;

//slang word
class SlangWord {
    static HashMap<String, Pair> slangMap = new HashMap<String, Pair>();
    static List<Pair> history = new ArrayList<Pair>();

    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        SlangWord slangManager = new SlangWord();
        getSlangWords();
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
        if (option != 11) {
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
            } else if (option == 6) {
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
                getSlangWords();
                System.out.println("Reset successfully");
            } else if (option == 8) {
                System.out.println("Word of the day is:");
                Set<String> keys = slangManager.slangMap.keySet();
                int index = (int) (Math.random() * keys.size());
                String key = (String) keys.toArray()[index];
                Pair pair = slangManager.slangMap.get(key);
                System.out.println(pair.word + ": " + pair.meaning);
                history.add(pair);
            } else if (option == 9) {
                scanner = new Scanner(System.in);
                Set<String> keys = slangManager.slangMap.keySet();
                int index = (int) (Math.random() * keys.size());
                String key = (String) keys.toArray()[index];
                Pair pair = slangManager.slangMap.get(key);
                System.out.println("Slang: " + pair.word);
                System.out.println("Meaning: ");
                // a b c d quiz
                int rightAnswer = index%4;
                for (int i = 0; i < 4; i++) {
                    if (i == rightAnswer) {
                        System.out.println(i + ". " + pair.meaning);
                    } else {
                        System.out.println(i + ". " + getRandomWord().meaning);
                    }
                }
                
                System.out.println("Your answer:");
                int answer = scanner.nextInt();
                if (answer == rightAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong!");
                }

            } else if (option == 10) {
                Set<String> keys = slangManager.slangMap.keySet();
                int index = (int) (Math.random() * keys.size());
                String key = (String) keys.toArray()[index];
                Pair pair = slangManager.slangMap.get(key);
                System.out.println("Meaning: " + pair.meaning);
                System.out.println("The word slang is: ");
                // a b c d quiz
                int rightAnswer = index%4;
                for (int i = 0; i < 4; i++) {
                    if (i == rightAnswer) {
                        System.out.println(i + ". " + pair.word);
                    } else {
                        System.out.println(i + ". " + getRandomWord().word);
                    }
                }
                System.out.println("Your answer:");
                int answer = scanner.nextInt();
                if (answer == rightAnswer) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Wrong!");
                }
            }
        }

    }

    public static void getSlangWords() throws IOException {
        // Open the file
        FileInputStream fstream = new FileInputStream("slang.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            String[] parts = strLine.split("`");
            Pair pair = new Pair();
            try {
                pair.word = parts[0];
                pair.meaning = parts[1];
                System.out.println(pair.word + "has meaning " + pair.meaning);
                slangMap.put(pair.word, pair);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // Close the input stream
        fstream.close();
    }
    public static Pair getRandomWord() {
        Set<String> keys = slangMap.keySet();
        int index = (int) (Math.random() * keys.size());
        String key = (String) keys.toArray()[index];
        Pair pair = slangMap.get(key);
        return pair;
    }
}