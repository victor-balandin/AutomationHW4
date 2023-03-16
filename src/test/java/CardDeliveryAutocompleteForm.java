import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryAutocompleteForm {
    int weekDelivery;
    LocalDate currentDate = LocalDate.now();
    int currentDay = currentDate.getDayOfMonth();
    int monthLength = currentDate.lengthOfMonth();


    @Test
    void shouldCardDeliveryAutocompleteForm() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        weekDelivery = 7;

        $("[data-test-id=city] input").setValue("Мо");
        $x("//span[contains(text(), 'Москва')]//parent::div").click();
        $x("//span[@class='input__icon']").click();
        if (currentDay + weekDelivery > monthLength) {
            $("[data-step='1']").click();
            int dateDelivery = currentDay + weekDelivery - monthLength;
            $x("//td[contains(text()," + dateDelivery + ")]").click();
        } else {
            int dateDelivery = currentDay + weekDelivery;
            $x("//td[contains(text()," + dateDelivery + ")]").click();
        }
        $("[data-test-id=name] input").setValue("Виктор Баландин");
        $("[data-test-id=phone] input").setValue("+79155555555");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }

    @Test
    void shouldCardAutocompleteFormNextMonth() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        weekDelivery = 20;

        $("[data-test-id=city] input").setValue("Мо");
        $x("//span[contains(text(), 'Москва')]//parent::div").click();
        $x("//span[@class='input__icon']").click();
        if (currentDay + weekDelivery > monthLength) {
            $("[data-step='1']").click();
            int dateDelivery = currentDay + weekDelivery - monthLength;
            $x("//td[contains(text()," + dateDelivery + ")]").click();
        } else {
            int dateDelivery = currentDay + weekDelivery;
            $x("//td[contains(text()," + dateDelivery + ")]").click();
        }
        $("[data-test-id=name] input").setValue("Виктор Баландин");
        $("[data-test-id=phone] input").setValue("+79155555555");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));

    }


}
