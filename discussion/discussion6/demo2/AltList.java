//package demo2;
//
//public class AltList<X, Y> {
//    private X item;
//    private AltList<Y, X> next;
//
//    public AltList(X item, AltList<Y, X> next) {
//        this.item = item;
//        this.next = next;
//    }
//
//    public AltList<Y, X> pairSwapped() {
//        if (next == null) {
//            return null;
//        }
//
//        AltList<Y, X> swappedList = new AltList<>(next.next, new AltList<>(item, next.next != null ? next.next.pairSwapped() : null));
//        return swappedList;
//    }
//}
