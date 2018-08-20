package com.nsbm.app.components.human;

import com.nsbm.app.components.misc.ALResult;

public class UndergraduateStudent extends Student {
    private ALResult[] alResults;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public UndergraduateStudent retrieveFromDatabase() {
        return null;
    }

    public void setAlResults(ALResult ...alResults) {
        this.alResults = alResults;
    }

    public ALResult[] getAlResults() {
        return alResults;
    }
}
