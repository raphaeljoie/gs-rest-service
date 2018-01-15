package hello;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class PositiveValueMatcher extends BaseMatcher<Object> {

    @Override
    public boolean matches(Object item) {
        if (item instanceof Number) {
            return ((Number) item).doubleValue() >= 0;
        }
        return false;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Value should be equal or greater than zero");
    }
}