/**
 * Тестовый класс, имплементирующий интерфейс
 * @see NoWorkInterface
 * @autor Антон Кручинин
 */
public class NoWorkClass implements NoWorkInterface{
    @Override
    public void noWork() {
        System.out.println("No work here");
    }
}
