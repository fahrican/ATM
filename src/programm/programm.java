package programm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class programm {

    public static void main(String[] args) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
