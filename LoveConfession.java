import java.util.Scanner;

public class LoveConfession {
    private static final int LENGTH_PER_LETTER = 62;
    private static final int LENGTH_PER_SPACE = 12;
    private static final int MESSAGE_LENGTH = 18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите длину забора в сантиметрах: ");
            int fenceLength = scanner.nextInt();


            int totalLength = (MESSAGE_LENGTH / 3) * LENGTH_PER_LETTER + (MESSAGE_LENGTH % 3) * LENGTH_PER_SPACE;


            if (fenceLength >= totalLength) {
                System.out.println("Сообщение поместится на эту длину забора.");
            } else {
                System.out.println("Сообщение не поместится на эту длину забора.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
