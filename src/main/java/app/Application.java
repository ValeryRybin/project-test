package app;

import io.github.humbleui.jwm.*;
import io.github.humbleui.jwm.App;
import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.Window;

import java.util.function.Consumer;

/**
 * Класс окна приложения
 */
public class Application implements Consumer<Event> {
    /**
     * окно приложения
     */
    private final Window window;

    /**
     * Конструктор окна приложения
     */
    public Application() {
        // создаём окно
        window = App.makeWindow();
        // задаём обработчиком событий текущий объект
        window.setEventListener(this);

        // задаём размер окна
        window.setWindowSize(900, 900);
        // задаём его положение
        window.setWindowPosition(100, 100);

        // делаем окно видимым
        window.setVisible(true);
        // создаем название окна
        window.setTitle("Java 2D");
    }

    /**
     * Обработчик событий
     *
     * @param e событие
     */
    @Override
    public void accept(Event e) {
        // если событие - это закрытие окна
        if (e instanceof EventWindowClose) {
            // завершаем работу приложения
            App.terminate();
        } else if (e instanceof EventWindowCloseRequest) {
            window.close();
        }
    }
}
