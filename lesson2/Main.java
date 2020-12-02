package java2.lesson2;

public class Main {

    private static final String[][] correct_array = new String[][] {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
    };

    private static final String[][] error_size = new String[][] {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3"},
            {"1", "2", "3", "4"},
    };

    private static final String[][] error_value = new String[][] {
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"1", "2", "3", "4"},
            {"l", "2", "3", "4"},
    };

    public static void main(String[] args) {
        try {
            int result = checkArray(correct_array);
//            int result = checkArray(error_size);
//            int result = checkArray(error_value);
            System.out.println("Сумма элементов массива равна " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Некорректный размер массива");
        } catch (MyArrayDataException e) {
            System.err.println("Некорректный элемент массива в ячейке " + e.getMessage());
        }

    }

    private static final int array_size = 4;

    private static int checkArray(String[][] array) throws MyArrayDataException, MyArraySizeException {

        if(array.length != array_size) {
            throw new MyArraySizeException();
        }

        for (String[] row : array) {
            if(row.length != array_size) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            String[] row = array[i];
            for (int j = 0; j < row.length; j++) {
                String value = row[j];
                try {
                    sum += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
