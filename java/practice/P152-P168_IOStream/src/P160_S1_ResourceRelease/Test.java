package P160_S1_ResourceRelease;

public class Test {
    public static void main(String[] args) {
        //try {} catch () {} finally {}: finally always executed, if return occurs, it will executed before return (hence never put return inside finally block)
        division1(2);
        division1(0);
        //HENCE: use try-catch-finally to close stream!!! (see example in FileCopy/Test)
        //!!!a more elegant method: try-with-resource (see example in FileCopy/Test2)
    }

    public static void division1(int i) {
     try {
         System.out.println(10 / i);
         return;
     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         System.out.println("===finally block===");
     }
    }
}
