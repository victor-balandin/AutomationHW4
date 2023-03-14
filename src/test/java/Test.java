import org.junit.jupiter.api.Assertions;

public class Test {
    @org.junit.jupiter.api.Test

    public void DataTest() {
        MinimalDataDelivery data = new MinimalDataDelivery();
        String actual = data.minDataDelivery();
        String expected = "17.03.2023";

        Assertions.assertEquals(expected, actual);
    }
}
