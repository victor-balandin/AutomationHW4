import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardDeliveryTests {

    @Test
    void shouldCorrectCardFormTest() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;

        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date]").click();
        $("[data-test-id=date] input").setValue("\b\b\b\b\b\b\b\b");
        $("[data-test-id=date] input").setValue("19.03.2023");
        $("[data-test-id=name] input").setValue("Виктор Баландин");
        $("[data-test-id=phone] input").setValue("+79155555555");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    @Test
    void shouldMinimalDateDeliveryTest() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;
        MinimalDataDelivery data = new MinimalDataDelivery();


        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date]").click();
        $("[data-test-id=date] input").setValue("\b\b\b\b\b\b\b\b");
        $("[data-test-id=date] input").setValue(data.minDataDelivery());
        $("[data-test-id=name] input").setValue("Виктор Баландин");
        $("[data-test-id=phone] input").setValue("+79155555555");
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }
}
