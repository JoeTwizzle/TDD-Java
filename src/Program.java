

public class Program {
    public static void main(String[] args) {


        boolean a = isWellSorted(new String[] {"A", "C", "D"});

        System.out.println(a);
    }

    public static boolean isWellSorted( String[] sequence ) {

        String order[][] = new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }};
        String temp[][] = order;
        int noAppearance;

        for (int i = 0; i < sequence.length; i++) {

            noAppearance = 0;

            for (int j = 0; j < order.length; j++) {

                if (sequence[i] != order[j][1]) {

                    noAppearance++;
                }
                if (noAppearance == temp.length) {

                    for (int k = 0; k < temp.length; k++) {

                        if (temp[k][0] == sequence[i]) {
                            temp[k][1] = null;
                        }
                    }
                }
            }
            if (noAppearance != temp.length) {
                return false;
            }
        }

        return true;
    }


}
