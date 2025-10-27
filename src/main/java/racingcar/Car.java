package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_TO_MOVE = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        validateName();
        this.position = 0;
    }

    public void move(int input) {
        if (input >= MINIMUM_TO_MOVE) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public String toResultString() {
        return name + " : " + positionToHyphen();
    }

    public boolean isFurtherThan(Car other) {
        return this.position > other.position;
    }

    public boolean isWinnerPositionSameAs(Car other) {
        return this.position == other.position;
    }

    private String positionToHyphen() {
        if (position <= 0) {
            return "";
        }
        return "-".repeat(position);
    }

    private void validateName() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
