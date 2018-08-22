package com.nsbm.app.components.human;

import com.nsbm.app.components.misc.ALResult;

public class UndergraduateStudent extends Student {
    private ALResult[] alResults;

    @Override
    public void removeFromDatabase() {

    }

    public void setAlResults(ALResult ...alResults) {
        this.alResults = alResults;
    }

    public ALResult[] getAlResults() {
        return alResults;
    }
}
