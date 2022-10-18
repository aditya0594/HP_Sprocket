package base;

import static base.TestBase.driver;

public class ScreenBase extends TestBase {

    public ScreenBase() {

    }

    public void hideKeyboard() {

        driver.hideKeyboard();
    }

}
