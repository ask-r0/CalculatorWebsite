package no.ntnu.dev.CalculatorAPI.model;

public class Answer {
    private String value;

    public Answer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
