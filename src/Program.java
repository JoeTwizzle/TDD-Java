

public class Program {
    public static void main(String[] args) {


        boolean a = isWellSorted(new String[] {"A", "B", "D", "C"});

        System.out.println(a);
    }

    public static boolean isWellSorted( String[] sequence ){
        String order[][] = new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }};
        String temp[][] = order;
        String temp2;
        int appearance;

        for (int i = 0; i < sequence.length; i++) {
            appearance = 0;
            for (int j = 0; j < order.length; j++) {

                if (sequence[i] != order[j][1])
                {
                    appearance++;

                }
                if (appearance == temp.length)
                {
                    for (int k = 0; k < temp.length; k++) {
                        if (temp[k][0] == sequence[i]){
                            temp[k][1] = "no";
                        }
                    }

                }

            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i][1] != "no"){
                return false;
            }
        }

        return true;
    }


}
