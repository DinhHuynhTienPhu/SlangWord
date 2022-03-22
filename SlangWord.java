
import java.io.*;
import java.util.*;

//slang word
class SlangWord {
    static HashMap<String, Pair> slangMap = new HashMap<String, Pair>();
    static List<Pair> history = new ArrayList<Pair>();
    static List<Pair> listSorted = new ArrayList<Pair>();

    public static void main(String[] args) throws IOException {

        System.out.println("Load from: \n1. slang.txt (original file)\n2. slang_edited.txt");
        Scanner scanner2 = new Scanner(System.in);
        int optionz = scanner2.nextInt();
        String filename="";
        if (optionz == 1) {
            filename = "slang.txt";
        } else if (optionz == 2) {
            filename = "slang_edited.txt";
        }
        getSlangWords(filename);
        int option = -1;
        while (option != 11) {
            System.out.println("***********************************************************");
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
            System.out.println("11. Save and exit");
            System.out.println("***********************************************************");
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            if (option != 11) {
                if (option == 1) {
                    System.out.println("1. Normal search\n2. Advanced search");
                    int searchOption = scanner.nextInt();
                    if (searchOption == 1) {
                        System.out.println("Enter a slang word:");
                        String slang = scanner.next();
                        Pair pair = slangMap.get(slang);
                        if (pair == null) {
                            System.out.println("No such word");
                        } else {
                            System.out.println(pair.word + ": " + pair.meaning);
                            history.add(pair);
                        }
                    } else {
                        System.out.println("Enter a slang word:");
                        String slang = scanner.next();
                        AdvancedSearchByWord(slang);
                    }

                } else if (option == 2) {
                    System.out.println("1. Normal search\n2. Advanced search");
                    int searchOption = scanner.nextInt();
                    if (searchOption == 1) {
                        scanner = new Scanner(System.in);
                        System.out.println("Enter a meaning word:");
                        String meaning = scanner.nextLine();
                        Set<String> keys = slangMap.keySet();
                        for (String key : keys) {
                            Pair pair = slangMap.get(key);
                            if (pair.meaning.equals(meaning)) {
                                System.out.println(key + ": " + pair.meaning);
                                history.add(pair);
                            }
                        }
                    } else {
                        System.out.println("Enter a meaning:");
                        scanner = new Scanner(System.in);
                        String meaning = scanner.nextLine();
                        AdvancedSearchByMeaning(meaning);
                    }

                } else if (option == 3) {
                    System.out.println("History:");
                    for (Pair pair : history) {
                        System.out.println(pair.word + ": " + pair.meaning);
                    }
                } else if (option == 4) {
                    System.out.println("Enter a slang word:");
                    String slang = scanner.next();
                    scanner = new Scanner(System.in);
                    System.out.println("Enter a meaning word:");
                    String meaning = scanner.nextLine();
                    Pair pair = new Pair();
                    pair.word = slang;
                    pair.meaning = meaning;
                    slangMap.put(slang, pair);
                    listSorted.add(pair);
                    System.out.println("Added successfully");
                } else if (option == 5) {
                    System.out.println("Enter a slang word:");
                    String slang = scanner.next();
                    Pair pair = slangMap.get(slang);
                    if (pair == null) {
                        System.out.println("No such word");
                    } else {
                        System.out.println("Enter a meaning word:");
                        scanner = new Scanner(System.in);
                        String meaning = scanner.nextLine();
                        pair.meaning = meaning;
                        System.out.println("Edited successfully");
                    }
                } else if (option == 6) {
                    System.out.println("Enter a slang word:");
                    String slang = scanner.next();
                    Pair pair = slangMap.get(slang);
                    if (pair == null) {
                        System.out.println("No such word");
                    } else {
                        System.out.println("Are you sure to delete this word? (y/n)");
                        String confirm = scanner.next();
                        if (confirm.equals("y")) {
                            slangMap.remove(slang);
                            listSorted.remove(pair);
                            System.out.println("Deleted successfully");
                        }
                       
                    }
                } else if (option == 7) {
                    slangMap.clear();
                    history.clear();
                    listSorted.clear();
                    getSlangWords("slang.txt");
                    System.out.println("Reset successfully");
                } else if (option == 8) {
                    System.out.println("Word of the day is:");
                    Set<String> keys = slangMap.keySet();
                    int index = (int) (Math.random() * keys.size());
                    String key = (String) keys.toArray()[index];
                    Pair pair = slangMap.get(key);
                    System.out.println(pair.word + ": " + pair.meaning);
                    history.add(pair);
                } else if (option == 9) {
                    scanner = new Scanner(System.in);
                    Set<String> keys = slangMap.keySet();
                    int index = (int) (Math.random() * keys.size());
                    String key = (String) keys.toArray()[index];
                    Pair pair = slangMap.get(key);
                    System.out.println("Slang: " + pair.word);
                    System.out.println("Meaning: ");
                    // a b c d quiz
                    int rightAnswer = index % 4;
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
                    Set<String> keys = slangMap.keySet();
                    int index = (int) (Math.random() * keys.size());
                    String key = (String) keys.toArray()[index];
                    Pair pair = slangMap.get(key);
                    System.out.println("Meaning: " + pair.meaning);
                    System.out.println("The word slang is: ");
                    // a b c d quiz
                    int rightAnswer = index % 4;
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
                
                System.out.println("Press enter to continue");
                try {
                    System.in.read();
                } catch (Exception e) {
                }
            }
            save();
        }

    }

    private static void AdvancedSearchByMeaning(String meaning) {
        Set<String> keys = slangMap.keySet();
        List<Pair> list = new ArrayList<>();
        for (String key : keys) {
            Pair pair = slangMap.get(key);
            int levenshtein = getSumLevenshtein(pair.meaning, meaning);
            if (levenshtein <= 100) {
                pair.levenshtein = levenshtein;
                list.add(pair);
            }
        }
        list.sort((p1, p2) -> p1.levenshtein - p2.levenshtein);
        System.out.println("Did you mean:");
        for (int i = 0; i < 3; i++) {
            try {
                Pair pair = list.get(i);
                if(pair!=null){System.out.println(pair.word + ": " + pair.meaning);
                history.add(pair);}
            } catch (Exception e) {
                break;
            }
        }
    }

    public static int getSumLevenshtein(String word1, String word2) {
        int sum = 0;
        var word1Array = word1.split(" ");
        var word2Array = word2.split(" ");
        for (int i = 0; i < (word1Array.length > word2Array.length ? word1Array.length : word2Array.length); i++) {
            try {
                sum += (i) * Levenshtein.levenshtein(word1Array[i], word2Array[i], false);
            } catch (Exception e) {
                if (word1Array.length > word2Array.length) {
                    sum += (i) * word1Array[i].length();
                } else {
                    sum += (i) * word2Array[i].length();
                }
            }
        }

        return sum;
    }

    public static void getSlangWords(String filename) throws IOException {
        // Open the file
   

        FileInputStream fstream = new FileInputStream(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int i = 0;
        Pair prev = null;
        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            String[] parts = strLine.split("`");
            Pair pair = new Pair();
            try {
                pair.word = parts[0];
                pair.meaning = parts[1];
               // System.out.println(pair.word + " has meaning " + pair.meaning);
                slangMap.put(pair.word, pair);
                listSorted.add(pair);
                if (prev != null) {
                    prev.nextKey = pair.word;
                    pair.previousKey = prev.word;
                }
                prev = pair;
            } catch (Exception e) {
                System.out.println("Error: " + strLine);
            }
            i++;
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

    public static void AdvancedSearchByWord(String word) {
        List<Pair> list = new ArrayList<Pair>();
        slangMap.entrySet().stream().forEach(action -> {
            int levenshtein = Levenshtein.levenshtein(word, action.getKey(), false);
            if (levenshtein < 5) {
                list.add(action.getValue());
                action.getValue().levenshtein = levenshtein;
            }
        });
        list.sort((p1, p2) -> p1.levenshtein - p2.levenshtein);
        List<Pair> result = new ArrayList<Pair>();
        Pair mostSimilar = list.get(0);
        result.add(mostSimilar);
        result.add(slangMap.get(mostSimilar.nextKey));
        result.add(slangMap.get(mostSimilar.previousKey));
        // print out the result
        System.out.println("Did you mean:");
        for (Pair pair : result) {
           if(pair!=null) {System.out.println(pair.word + ": " + pair.meaning);
            history.add(pair);
        }
        }
    }

    public static void save() {
        try {
            // save text
            FileWriter fw = new FileWriter("slang_edited.txt");
            for (Pair pair : listSorted) {
                fw.write(pair.word + "`" + pair.meaning + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}