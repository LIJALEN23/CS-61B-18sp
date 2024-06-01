package project1b;

public class OffByN implements CharacterComparator{
    public int num;

    public OffByN(int num) {
        this.num = num;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return (x == y - num || x - num == y);
    }
}
