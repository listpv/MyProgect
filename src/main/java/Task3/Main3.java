package Task3;

import java.io.IOException;


//    Добавить на серверную сторону сетевого чата логирование событий
//   (сервер запущен, произошла ошибка, клиент подключился, клиент прислал сообщение/команду).

public class Main3
{
    public static void main(String[] args) {
        // write your code here

        // Вывожу логи на консоль и записываю в файл

        new Thread(new Runnable() {
            @Override
            public void run() {
                new ServerConsole();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new ClientConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
