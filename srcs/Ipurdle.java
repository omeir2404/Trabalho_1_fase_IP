/*
 * @authors: Omeir Haroon, Matilde Brandão
 */
public class Ipurdle {
    public static void main(String[] args) {
        System.out.println("Boa sorte!");
        System.out.println(ValidClue(123, 3));
        System.out.println(minClue(4));
        System.out.println(isMaxClue(333, 3));
        System.out.println(nextClue(1323, 4));
    }

    public static boolean ValidClue(int clue, int size) {
        String clueString = String.valueOf(clue);
        if (size <= 0 || clue <= 0 || clueString.length() != size) {
            System.out.println("Invalid clue| clue: " + clueString + " |size: " + size);
            return false;
        }
        for (int i = 0; i < clueString.length(); i++) {
            char digit = clueString.charAt(i);
            if (digit != '1' && digit != '2' && digit != '3') {
                return false;
            }
        }
        return true;
    }

    public static int minClue(int size) {
        if (size <= 0) {
            System.out.println("Invalid size: " + size);
            return 0;
        }
        String clue = "";
        for (int i = 0; i < size; i++) {
            clue += "1";
        }
        return Integer.parseInt(clue);
    }

    public static boolean isMaxClue(int clue, int size) {
        String clueString = String.valueOf(clue);
        if (!ValidClue(clue, size))
            return false;

        for (int i = 0; i < clueString.length(); i++) {
            char digit = clueString.charAt(i);
            if (digit != '3') {
                return false;
            }
        }
        System.out.println("is Max clue: " + clueString);
        return true;
    }

    public static int nextClue(int clue, int size) {
        if (isMaxClue(clue, size))
        {
            System.out.println("is Max clue: " + clue);
            return -1;
        }
        int nextClue = clue + 1;
        System.out.println("next clue start: " + nextClue + "clue start: " + clue);
        while (!ValidClue(nextClue, size)) {
            nextClue++;
        }
    
        return nextClue;
    }
    
}