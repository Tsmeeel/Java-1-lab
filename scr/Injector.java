import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Класс-инжектор, который принимает в
 * качестве параметра объект любого класса и, используя
 * механизмы рефлексии, осуществляет поиск полей, помеченных специальной
 * аннотацией и осуществляет инициализацию этих полей
 * экземплярами классов, которые указаны в качестве реализации
 * соответствующего интерфейса в некотором файле
 * настроек.
 * @see AutoInjectable
 * @autor Антон Кручинин
 */
public class Injector {
    private Properties properties = new Properties();

    public Injector() {
        try (FileInputStream inStream = new FileInputStream("E:\\JavaLab\\Reflection\\Reflection\\src\\app.properties")) {
            properties.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public <T> T inject(T obj) {
        Class<?> c = obj.getClass();

        for (Field fields : c.getDeclaredFields()) {
            if (fields.isAnnotationPresent(AutoInjectable.class)) {
                String interfaceName = fields.getType().getName();
                String implClassName = properties.getProperty(interfaceName);

                if (implClassName != null) {
                    try {
                        Class<?> implClass = Class.forName(implClassName);
                        Object implementation = implClass.getDeclaredConstructor().newInstance();

                        fields.setAccessible(true);
                        fields.set(obj, implementation);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }
}
