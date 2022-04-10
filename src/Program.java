

public class Program {
    public static void main(String[] args) {


        boolean a = isWellSorted(new String[]{"A", "B", "C"});

        System.out.println(a);
    }

    public static boolean isWellSorted(String[] sequence) {

        String[][] order = new String[][]{{"A", "C"}, {"C", "D"}, {"B", "C"}};
        boolean legit = true;
        int noAppearance;

        for (int i = 0; i < sequence.length; i++) {

            if (legit == false) {
                return false;
            }

            for (int j = 0; j < order.length; j++) {

                if (sequence[i].equals(order[j][0]) || sequence[i].equals(order[j][1])) {

                    legit = true;
                    break;
                } else {

                    legit = false;

                }
            }

        }
        if (legit == false) {
            return false;
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
