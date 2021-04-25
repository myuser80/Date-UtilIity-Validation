package com.date.validation.utils;
public enum Months {
	JAN (1, "JANUARY"),
    FEB (2, "FEBRUARY"), 
    MAR (3, "MARCH"), 
    APR (4, "APRIL"),
    MAY (5, "MAY"), 
    JUN (6, "JUNE"), 
    JUL (7, "JULY"),
    AUG (8, "AUGUST"), 
    SEP (9, "SEPTEMBER"), 
    OCT (10, "OCTOBER"),
    NOV (11, "NOVEMBERY"), 
    DEC (12, "DECEMBER"); 
 
    private final int seq;
    private final String name;
     
    Months(int seq, String name){
        this.seq = seq;
        this.name = name;
    }
    
    public static Months getMonthBySequence(int i) {
    	String monthCaptured= Months.values()[i-1].toString();
    	System.out.println(monthCaptured);
    	return Months.values()[i-1];
    }

    public static void main(String[] args) {
		System.out.println( Months.getMonthBySequence( 3 ) );
	}
}

