package utils;


public class ReverseCharacters {

    public static String withParenthesis(String word){
       int firstParentesis = word.lastIndexOf("(");
       int lastParentesis = word.indexOf(")", firstParentesis);
        while (firstParentesis != -1 && lastParentesis != -1) {
            String wordGet = word.substring(firstParentesis + 1, lastParentesis);
            String reverseWordGet = new StringBuilder(wordGet).reverse().toString();
            String firstWord = word.substring(0, firstParentesis);
            String lastWord = word.substring(lastParentesis + 1);
            word = firstWord + reverseWordGet + lastWord;
            firstParentesis = word.lastIndexOf("(");
            lastParentesis = word.indexOf(")", firstParentesis);
        }
       return word;
    }
}
