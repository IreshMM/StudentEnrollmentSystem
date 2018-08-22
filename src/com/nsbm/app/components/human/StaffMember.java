package com.nsbm.app.components.human;

public abstract class StaffMember extends Person {
    private int staffID;

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getStaffID() {
        return staffID;
    }
}
