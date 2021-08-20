package lottery;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: chenwei
 * @date: 2021/8/20 17:41
 * @description: 描述
 */
public class TimeTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-HH-dd hh:mm:ss");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);
    }
}
