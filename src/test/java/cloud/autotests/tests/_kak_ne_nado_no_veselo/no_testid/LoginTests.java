package cloud.autotests.tests._kak_ne_nado_no_veselo.no_testid;

import cloud.autotests.tests.TestBase;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.helpers.DriverHelper.byTestId;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests")
@Tag("web")
@Tag("login")
class LoginTests extends TestBase {
    @Test
    @DisplayName("Successful login with web react-native app")
    void successfulLogin() {
        step("Go to login page", ()-> {
            open("");
            $("h2").shouldHave(text("Not authorized"));
        });

        step("Fill the authorization form", ()-> {
            $("form").shouldBe(visible);
            $("input", 0).setValue(DEFAULT_LOGIN);
            $("input", 1).setValue(DEFAULT_PASSWORD);
            $("input[type=checkbox]").click();
            $("button").click();
        });

        step("Verify successful authorization", ()-> {
            $("form").shouldNot(exist);
            $("h2").shouldHave(text("Hello, " + DEFAULT_LOGIN + "!"));
            $$("div div div")
                    .shouldHaveSize(2)
                    .shouldHave(texts("Here is your private content #1",
                            "and private content #2"));
        });
    }

}
