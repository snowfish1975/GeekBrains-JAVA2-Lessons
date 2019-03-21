public class Lesson2Task {

    private static final int MATRIX_SIZE = 4;
    private static String[][] matrix = {

//  Наборы данных для тестирования работы программы:

//  Корректная матрица для суммирования
//            {"7",  "55", "29", "46"},
//            {"14", "8",  "5",  "9"},
//            {"6",  "1",  "99", "-4"},
//            {"9",  "8",  "66", "140"}
//  Матрица с некорректным размером
//            {"7",     "55",     "29",    "46",        "extra element"},
//            {"14",    "8",      "wrong", "9"},
//            {"error", "1",      "99",    "-4"},
//            {"9",     "plus 8", "66",    "The number"},
//            {"9",     "plus 8", "66" }
//  Матрица с ошибками данных
            {"7",     "55",     "29",    "46"},
            {"14",    "8",      "wrong", "9"},
            {"error", "1",      "99",    "-4"},
            {"9",     "plus 8", "66",    "The number"}
    };

    public static void main(String[] args) {
        try {
            System.out.println("Сумма матрицы = " + calculateSum(matrix));
        } catch (MyArraySizeException sizeException){
            System.out.println("Матрица не соответствует заданному размеру. Пожалуйста, приведите её к формату 4 х 4 элемента.");
        } catch (MyArrayDataException dataException){
            System.out.println("Суммирование матрицы невозможно, т.к. в ячейке [" +
                    dataException.getX() + ", " +
                    dataException.getY() + "] находится нечисловое значение \"" +
                    matrix[dataException.getX()][dataException.getY()] + "\".");
            System.out.println("Проверьте элементы на соответсвие целочисленному типу данных.");
        }
    }

    private static int calculateSum(String[][] m) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        // проверка матрицы на размеры
        if (m.length != MATRIX_SIZE) throw (new MyArraySizeException());
        for (String[] ml : m) {
            if (ml.length != MATRIX_SIZE) throw (new MyArraySizeException());
        }
        // попытка представить каждый элемент матрицы как int просуммировать элементы
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                try {
                    sum += Integer.valueOf(m[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }

}
