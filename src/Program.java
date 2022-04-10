
public class Program {
    public static void main(String[] args) {

    }

    public static boolean isWellSorted(String[] sequence) {

        String[][] order = new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}};
        boolean legit = true;
        int noAppearance;

        for (String s : sequence) {

            boolean isContained = false;

            for (int i = 0; i < order.length; i++) {

                for (int j = 0; j < order[i].length; j++) {

                    isContained |= order[i][j].equals(s);
                }
            }
            if (!isContained) {

                return false;
            }
        }


        for (int i = 0; i < sequence.length; i++) {

            noAppearance = 0;

            for (int j = 0; j < order.length; j++) {

                if (!sequence[i].equals(order[j][1])) {

                    noAppearance++;
                }
                if (noAppearance == order.length) {

                    for (int k = 0; k < order.length; k++) {

                        if (order[k][0].equals(sequence[i])) {
                            order[k][1] = null;
                        }
                    }
                }
            }
            if (noAppearance != order.length) {
                return false;
            }
        }

        return true;
    }


}
