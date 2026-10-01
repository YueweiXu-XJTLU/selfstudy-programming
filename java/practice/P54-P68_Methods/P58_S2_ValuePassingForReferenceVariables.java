package S4_Methods;

public class P58_S2_ValuePassingForReferenceVariables {
    public static void main(String[] args) {
        int[] array1 = {10, 20, 30};
        valueElement(array1); //passing a copy of the VALUE OF ARGUMENT to parameter: the ADDRESS
        System.out.println("--------------------");
        System.out.println("Element value of array1 after the method is: " + array1[0]);
    }

    public static int[] valueElement(int[] array2) { //parameter c (defined in the beginning of a method): a formal parameter/a parameter 形参 (形式参数)
        System.out.println("The origin element value is " + array2[0]);
        array2[0] = 666;
        System.out.println("Change element value of the parameter to " + array2[0]); //using the same address, the element value in the stack(堆r) is changed
        return array2;
    }

}
