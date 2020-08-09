package Task3;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class ServerConsole
{
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream in;
    DataOutput out;
    Scanner sc;
    final int PORT = 8189;
    public static Logger logger = Logger.getLogger("");
    Handler handler;

    public ServerConsole()
    {
        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return  record.getLevel() + "\t" + record.getMessage() + "\n";
            }
        });
        try
        {
            handler = new FileHandler("loggers.log", true);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);

        try
        {
            serverSocket = new ServerSocket(PORT);
            if(serverSocket != null)
            {
                logger.log(Level.INFO, "Сервер запущен...");
            }
            else
                {
                    logger.log(Level.INFO, "Произошла ошибка...");
                }
            socket = serverSocket.accept();
            if(socket != null)
            {
                logger.log(Level.INFO, "Клиент подключился");
            }
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);
            boolean flag = true;
            while (true)
            {
                if(flag)
                {
                    String var = sc.nextLine();
                    boolean stp = false;
                    if(var.equalsIgnoreCase("/end"))
                    {
                        stp = true;
                    }
                    if(stp)
                    {
                        out.writeUTF("это сервер /end");
                        break;
                    }
                    else
                    {
                        out.writeUTF("это сервер " + var);
                    }
                    flag = false;
                }
                String str;
                str = in.readUTF();
                if (str.equals("это клиент /end"))
                {
                    logger.log(Level.INFO, "Клиент прислал команду на отключение.");
                    out.writeUTF("это сервер /end");
                    break;
                }
                logger.log(Level.INFO, str);
                String var = sc.nextLine();
                boolean stp = false;
                if(var.equalsIgnoreCase("/end"))
                {
                    stp = true;
                }
                if(stp)
                {
                    out.writeUTF("это сервер /end");
                    break;
                }
                else {
                    out.writeUTF("это сервер " + var);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            try
            {
                serverSocket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
