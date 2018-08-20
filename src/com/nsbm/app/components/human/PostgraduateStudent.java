package com.nsbm.app.components.human;

import com.nsbm.app.components.misc.PostQualification;
import com.nsbm.app.database.Insertable;

public class PostgraduateStudent extends Student {
    private PostQualification[] postQualifications;

    @Override
    public void insertToDatabase() {

    }

    @Override
    public void removeFromDatabase() {

    }

    @Override
    public PostgraduateStudent retrieveFromDatabase() {
        return null;
    }

    public void setPostQualifications(PostQualification ...postQualifications) {
        this.postQualifications = postQualifications;
    }

    public PostQualification[] getPostQualifications() {
        return postQualifications;
    }
}
