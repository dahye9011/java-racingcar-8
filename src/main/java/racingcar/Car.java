package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // input == 무작위 값
    public void move(int input) {
        if (input >= 4) {
            this.position++;
        }
    }

    // 값을 가져와서 활용할 건데, 그렇더라도 굳이 그 값을 그대로 가져올 필요는 없음
    public int getPosition() {
        return position;
    }
}
