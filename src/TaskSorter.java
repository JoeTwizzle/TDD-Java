public class TaskSorter implements ITaskSorter {

    String[][] order;

    public void setOrder(String[][] order) {

        this.order = order;
    }

    public String[][] getOrder() {

        return order;
    }

    public boolean isWellSorted(String[] sequence) {

        int noAppearance;

        if (order == null) {

            return false;
        }

        String[][] order = new String[this.order.length][];
        for (int i = 0; i < order.length; i++) {
            order[i] = new String[this.order[i].length];
            for (int j = 0; j < order[i].length; j++) {
                order[i][j] = this.order[i][j];
            }
        }

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
