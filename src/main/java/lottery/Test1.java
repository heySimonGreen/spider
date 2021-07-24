package lottery;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author: chenwei
 * @date: 2021/7/20 21:59
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        String url = "https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry";
        Connection.Response response = Jsoup.connect(url)
                .data("gameNo","85")
                .data("provinceId","0")
                .data("pageSize","30")
                .data("isVerify","1")
                .data("pageNo","1")
                .ignoreContentType(true)
                .execute();

        System.out.println(response.body());
//        System.out.println("###############");
//        Document doc = Jsoup.connect(url)
//                .data("gameNo","85")
//                .data("provinceId","0")
//                .data("pageSize","30")
//                .data("isVerify","1")
//                .data("pageNo","1")
//                .ignoreContentType(true)
//                .get();
//        System.out.println(doc.text());
    }
}
