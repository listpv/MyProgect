package Task3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientConsole
{
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    final String IP_ADDRESS = "localhost";
    final int PORT = 8189;
    Scanner sc;

    public ClientConsole() throws IOException {
        try
        {
            socket = new Socket(IP_ADDRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            sc = new Scanner(System.in);
            while (true)
            {
                String str = in.readUTF();
                if (str.equals("это сервер /end"))
                {
                    out.writeUTF("это клиент /end");
                    break;
                }
                System.out.println( str);
                String var = sc.nextLine();
                boolean stp = false;
                    if(var.equalsIgnoreCase("/end"))
                    {
                        stp = true;
                    }
                if(stp)
                {
                    out.writeUTF("это клиент /end");
                    break;
                }
                else {
                    out.writeUTF("это клиент " + var);
                }

            }
        }
        catch (IOException e)
        {
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

        }
    }
}
