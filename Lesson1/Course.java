import java.util.Random;

public class Course {

    private int maxHeight;
    private int maxLength;
    private int swimLength;
    private int runLength;

    public Course() {
        // создание полосы препятствий
        Random rnd = new Random();
        maxHeight = rnd.nextInt(65);       // максимальная высота препятствия на полосе
        maxLength = rnd.nextInt(180);       // максимальная длина препятствия на полосе
        swimLength = rnd.nextInt(100)+250;  // общая дистанция плавания
        runLength = rnd.nextInt(100)+50;    // общая дистанция бега
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getSwimLength() {
        return swimLength;
    }

    public int getRunLength() {
        return runLength;
    }

    public int getLength() {
        return runLength + swimLength;
    }
}
