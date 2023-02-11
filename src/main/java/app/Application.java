package app;

import io.github.humbleui.jwm.*;
import io.github.humbleui.jwm.App;
import io.github.humbleui.jwm.Event;
import io.github.humbleui.jwm.Window;

import java.util.function.Consumer;

public class Application implements Consumer<Event> {
    // окно приложения
    private final Window window;

    // конструктор приложения
    public Application() {
        // создаём окно
        window = App.makeWindow();
        // задаём обработчиком событий текущий объект
        window.setEventListener(this);
        // делаем окно видимым
        window.setVisible(true);
    }

    // обработчик событий
    @Override
    public void accept(Event e) {
        // если событие - это закрытие окна
        if (e instanceof EventWindowClose) {
            // завершаем работу приложения
            App.terminate();
        }else if (e instanceof EventWindowCloseRequest) {
            window.close();
        }
    }
}