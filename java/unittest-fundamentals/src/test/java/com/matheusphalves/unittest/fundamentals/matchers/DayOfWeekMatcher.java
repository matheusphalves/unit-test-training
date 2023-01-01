package com.matheusphalves.unittest.fundamentals.matchers;

import com.matheusphalves.unittest.fundamentals.utils.DateUtil;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.Date;

public class DayOfWeekMatcher extends TypeSafeMatcher<Date> {
    private Integer dayOfWeek;

    public DayOfWeekMatcher(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    protected boolean matchesSafely(Date date) {

        return DateUtil.checkDayOfWeek(date, this.dayOfWeek);
    }

    @Override
    public void describeTo(Description description) {

    }
}
