package lottery;

import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: chenwei
 * @date: 2021/7/24 1:22
 * @desription:爬取的是事业单位公开招聘
 *
 * http://rlsbj.cq.gov.cn/zwxx_182/sydw/index_24.html
 */
public class CqGovSpiderSydwTest {
    @Test
    public void test()throws IOException {
        String baseUrl = "http://rlsbj.cq.gov.cn/zwxx_182/sydw";
        int pageNum = 23;
//        String url = "http://rlsbj.cq.gov.cn/ywzl/rsks/tzgg_109374/index_9.html";
        String url = "http://rlsbj.cq.gov.cn/zwxx_182/sydw/";
        for (int i=0;i<=pageNum;i++){
            if (i ==0){
                url = url + "index.html";
            }else {
                url = url + "index_" + String.valueOf(i) + ".html";
            }
            System.out.println(url);
            Elements elements= SpiderTool.getCqGovResponse(url).getElementsByClass("tab-item");
            for (int j=0;j<elements.size();j++){
                System.out.println("***********");
                Elements elements1 =elements.get(j).getElementsByClass("clearfix");
                for (int k =0;k<elements1.size();k++){
                    String href = baseUrl + elements1.get(k).getElementsByTag("a").get(0).attributes().get("href").substring(1);
                    String title = elements1.get(k).getElementsByTag("a").get(0).text();
                    String time = elements1.get(k).getElementsByTag("span").get(0).text();
                    String writeData = " url: " + href + " title: " + title + " time: " + time;
                    System.out.println(writeData);
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-HH-dd hh");
                    String format = now.format(dateTimeFormatter);
                    WriteDataToTxt.writeStringDataToTxt(writeData,"src/data/CqGovDataSydw" + format + ".txt");
                }
                System.out.println("***********");
            }
            url = "http://rlsbj.cq.gov.cn/zwxx_182/sydw/";
        }
    }
}
