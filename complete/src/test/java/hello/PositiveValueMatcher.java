package hello;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class PositiveValueMatcher extends BaseMatcher<Object> {

    @Override
    public boolean matches(Object item) {
        return item instanceof Number && ((Number) item).doubleValue() >= 0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Value should be equal or greater than zero");
    }
}