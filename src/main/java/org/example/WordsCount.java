package org.example;


import java.util.*;

/*Given two words, beginWord and endWord, and a dictionary of words,
find the shortest transformation sequence from beginWord to endWord
 beginWord = "hit", endWord = "cog", wordList = ["hot", "dot", "dog", "lot", "log", "cog"]
 hit" -> "hot" -> "dot" -> "dog" -> "cog"*/
public class WordsCount {

    public static int wordCount(List<String> wordList, String beginWord, String endWord){
        if(!wordList.contains(endWord))
            return 0;

        //Lookup
        Set<String> wordSet=new HashSet<>(wordList);

        //BFS
        Queue<String> queue=new LinkedList<>();

        queue.offer(beginWord);

        //to keep record of word
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);

        int lev=1;

        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                String currentWord= queue.poll();

                for(int j=0;j<currentWord.length();j++){
                    char[] wordChar=currentWord.toCharArray();

                    for(char c='a';c<='z';c++){
                        wordChar[j]=c;
                        String newWord=new String(wordChar);

                        if(newWord.equals(endWord))
                            return lev+1;

                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
            lev++;
        }
      return 0;
    }


    public static void main(String[] args) {
        List<String> wordList=Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(wordCount(wordList,"hit","cog"));

    }
}
