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

    // 값을 가져와서 활용할 건데, 그렇더라도 굳이 그 값을 그대로 가져올 필요는 없음
    public int getPosition() {
        return position;
    }

    // 리팩터링 필요
    public String getName() {
        return name;
    }

    public String toResultString() {
        return name + " : " + positionToHyphen();
    }

    private String positionToHyphen() {
        if (this.position <= 0) {
            return "";
        }
        return "-".repeat(this.position);
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
