package P177_P178_ThreadSafety;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        //when multiple threads modifying on shared resources: thread safety issues

        //issue simulating
        //1.shared resource
        Account account = new Account(100000.00);
        //2.multiple threads
        AccountThread user1 = new AccountThread(account, "user1");
        AccountThread user2 = new AccountThread(account, "user2");
        //3.start threads
        user1.start();
        user2.start();

        //to solving thread safety issues: thread synchronization 线程同步
        //method1: synchronization-code-block:
          //synchronized(LockObject) {codes of shared-resource manipulation}
          //LockObject can be ANY Object, but must be the SAME Object for threads which will cause safety issues
          //LockObject recommendation: "Shared-Resource-Object"("this") for instance methods; "ClassName.class"(this unique .class file) fot static methods

        //method2: synchronization-method:
          //public synchronized void methodName()  {codes of shared-resource manipulation}
          //have hidden-automatically LockObject

        //method3: ReentrantLock implements Lock
          //private final Lock rl = new ReentrantLock(); //use "final" to make sure the Lock object is unchangeable
          //rl.lock
          //try {
          //    codes of shared-resource manipulation
          //} catch (Exception e) {
          //    e.printStackTrace();
          // } finally {
          //    rl.unlock(); //use "finally" to make sure even if error occurs, current thread can unlock
          //}
    }
}
