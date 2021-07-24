package lottery;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import javax.swing.text.Element;
import java.io.IOException;

/**
 * @author: chenwei
 * @date: 2021/7/23 23:50
 * @description: 爬取的是通知公告 https://rlsbj.cq.gov.cn/ywzl/rsks/  tzgg_109374/202102/t20210205_8873854.html
 */
public class CqGovSpiderTest {
    @Test
    public void Test() throws IOException {
        String baseUrl = "https://rlsbj.cq.gov.cn/ywzl/rsks/tzgg_109374";
        int pageNum = 22;
//        String url = "http://rlsbj.cq.gov.cn/ywzl/rsks/tzgg_109374/index_9.html";
        String url = "http://rlsbj.cq.gov.cn/ywzl/rsks/tzgg_109374/";
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
                    WriteDataToTxt.writeStringDataToTxt(writeData,"src/data/CqGovData.txt");
                }
                System.out.println("***********");
            }
            url = "http://rlsbj.cq.gov.cn/ywzl/rsks/tzgg_109374/";
        }
    }
}
