package org.example;

import java.util.ArrayList;
import java.util.List;

public class SharedMemory {
    private List<Token> tokens = new ArrayList<>();
    public SharedMemory(int n) {
        //shuffle them
        for (int i = 0; i < n; i++) {
            tokens.add(new Token(i));
        }
        //shuffle
        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (Math.random() * n);
            Token temp = tokens.get(i);
            tokens.set(i, tokens.get(randomIndex));
            tokens.set(randomIndex, temp);
        }
    }
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            //extract a token
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }


}

