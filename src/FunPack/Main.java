package FunPack;
public class Main {
    public static void main(String[] args){
        Sort One  = new Sort();
        One.input = new int[]{11, -30, 17, 5, -10, 11, -3, 2};
        System.out.println(One.MaxSubArrSearch(0, One.input.length - 1));
    }
}
