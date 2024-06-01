public class IntListMethod {
    public class IntList {
        public int first;
        public IntList rest;

        public IntList(int val) {
            first = val;
            rest = null;
        }

        public void addLast(int val) {
            rest = new IntList(val);
        }
    }

    public void skippify(IntList list) {
        IntList temp = list;

        int n = 1;
        while (temp != null) {
            IntList next = temp;
            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            temp.rest = next;

            temp = temp.rest;
            n++;
        }
    }

    public static void removeDuplicates(IntList list) {
        if (list == null) {
            return;
        }

        IntList current = list.rest;
        IntList pre = list;

        while (current != null) {
            if (current.first == pre.first) {
                current = current.rest;
            }
            else {
                pre.rest = current;

                pre = current;
                current = current.rest;
            }
        }
    }
}
