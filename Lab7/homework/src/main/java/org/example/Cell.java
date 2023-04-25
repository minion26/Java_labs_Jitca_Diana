package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell
{
    //cell is the same thing as a list of tokens
    private List<Token> tokens = new ArrayList<>();
    private boolean visited = false;
    public Cell()
    {
        this.tokens = new ArrayList<>();
    }


    public void setTokens(List<Token> tokens)
    {
        //add all the tokens from the list
       this.tokens = tokens;

    }

    public boolean isVisited()
    {
        return visited;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public List<Token> getTokens()
    {
        return tokens;
    }

    public void removeAll()
    {
        this.tokens.clear();
    }

}
