import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Аннотация для полей класса, которые можно заполнить автоматчиески с помощью файла
 * .properties.
 * @autor Антон Кручинин
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInjectable {
}