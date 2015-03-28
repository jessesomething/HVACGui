package com.jessespalding;

import java.util.Date;

public class Furnace extends ServiceCall {

    private String furnaceType;

    public Furnace(String serviceAddress, String problemDescription, Date date, String furnaceType) {
        super(serviceAddress, problemDescription, date);
        this.furnaceType = furnaceType;
    }

    @Override
    public String toString() {
//        String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
//        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
//        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);

        return "Furnace " + serviceAddress + "\n " +
                "[Description: " + problemDescription  + "]\n " +
                "[Type: " + furnaceType + "]\n " +
                "[Reported: " + reportedDate + "]\n ";
    }
}
