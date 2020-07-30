package easy;

public class FirstPosition {

    public int firstPosition(int[] array, int target) {
        if (array == null) {
            return -1;
        }
        int index = array.length / 2;
        int min = -1;
        if (array[index] == target) {
            return min;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new String("456") == new String("456"));
        System.out.println(new String("456").intern() == new String("456").intern());
        System.out.println(new String("456").intern().hashCode() + "// " + new String("456").intern().hashCode());
        System.out.println(System.identityHashCode(new String("456").intern()) + "// " + System.identityHashCode(new String("456").intern()));
        System.out.println(System.identityHashCode(new String("456")) + "// " + System.identityHashCode(new String("456")));
    }
}
