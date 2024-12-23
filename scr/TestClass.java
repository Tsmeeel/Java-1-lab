/**
 * Тестовый класс со полями <b>someInterface</b>, <b>otherInterface</b> и <b>noWorkInterface</b> для демонстрации рефлексии.
 * @autor Антон Кручинин
 * @see AutoInjectable
 * @see SomeInterface
 * @see OtherInterface
 * @see NoWorkInterface
 */
public class TestClass {
    @AutoInjectable
    private SomeInterface someInterface;

    @AutoInjectable
    private OtherInterface otherInterface;

    @AutoInjectable
    private NoWorkInterface noWorkInterface;

    public void test() {
        someInterface.doWork();
        otherInterface.doWork();
        noWorkInterface.noWork();
    }
}
