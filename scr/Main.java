public class Main {
    public static void main(String[] args) {
        Injector injector = new Injector();
        TestClass testClass = new TestClass();

        injector.inject(testClass);
        testClass.test();
    }
}
