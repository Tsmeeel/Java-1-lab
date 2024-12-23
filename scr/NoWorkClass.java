/**
 * Тестовый класс, имплементирующий интерфейс
 * @see NoWorkInterface
 * @autor Алексей Якимов
 */
public class NoWorkClass implements NoWorkInterface{
    @Override
    public void noWork() {
        System.out.println("No work here");
    }
}
