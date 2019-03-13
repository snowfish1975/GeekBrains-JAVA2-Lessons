import java.util.Random;

public class TeamMember {

    String[] names = {"Алексей", "Александр", "Александра", "Анатолий", "Анна", "Алла", "Борис", "Владимир", "Виктория","Вера",
            "Галина","Даниил", "Диана", "Евгений", "Евгения", "Екатерина", "Жанна", "Игорь", "Ирина", "Константин",
            "Леонид", "Людмила", "Матвей", "Марина", "Николай", "Наталья", "Надежда", "Олег", "Ольга", "Петр", "Полина",
            "Роман", "Сергей", "Софья", "Тимур", "Татьяна", "Юрий", "Юлия"};
    private String name;
    private float stamina;      // выносливость, от 0.7 до 1.0
    private int jumpHeight;     // максимальная высота прыжка, см
    private int jumpLength;     // максимальная длина прыжка, см
    private int runSpeed;       // скорость бега, км/ч
    private int swimSpeed;      // скорость плавания, км/ч
    private float result;         // время прохождения полосы препятствий, секунд (0 если не прошел)

    public TeamMember() {
        Random rnd = new Random();
        name = names[rnd.nextInt(names.length)];
        stamina = 1-rnd.nextFloat()/3.333f;
        jumpHeight = rnd.nextInt(100)+50;   // высота прыжка в диапазоне 50-150 см.
        jumpLength = rnd.nextInt(150)+150;  // длина прыжка в диапазоне 150-300 см.
        runSpeed = rnd.nextInt(7)+15;       // скорость бега от 15 до 22 км/ч
        swimSpeed = rnd.nextInt(3)+3;       // скорость плавания от 3 до 6 км/ч
    }

    public String getName() {
        return name;
    }

    public float getStamina() {
        return stamina;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getJumpLength() {
        return jumpLength;
    }

    public int getRunSpeed() {
        return runSpeed;
    }

    public int getSwimSpeed() {
        return swimSpeed;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public float getResult() {
        return result;
    }
}
