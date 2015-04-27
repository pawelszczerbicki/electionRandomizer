package com.szczerbicki;

/**
 * Created by pawel on 27.04.15.
 */
public class President {

    private String name;
    private String party;

    public President(String name, String party) {
        this.name = name;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }
}
