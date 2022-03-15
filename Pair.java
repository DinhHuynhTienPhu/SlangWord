public class Pair {
    public String word;
    public String meaning;
    public int levenshtein; // find similar words by levenshtein distance
    public String previousKey; //this to find similar word by index in document
    public String nextKey; // this to find similar word by index in document
}
