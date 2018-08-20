package com.nsbm.app.components.human;

public abstract class StaffMember extends Person {
    private String staffID;

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffID() {
        return staffID;
    }
}
