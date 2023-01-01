package com.matheusphalves.unittest.fundamentals.matchers;

public class CustomMatchers {

    public static DayOfWeekMatcher checkDayOfWeekMatcher(Integer dayOfWeek){
        return new DayOfWeekMatcher(dayOfWeek);
    }

}
