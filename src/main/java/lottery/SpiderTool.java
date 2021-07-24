package lottery;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;

/**
 * @author: chenwei
 * @date: 2021/7/20 22:26
 */
public class SpiderTool {
    //?gameNo=85&provinceId=0&pageSize=30&isVerify=1&pageNo=2
    //?gameNo=85&provinceId=0&pageSize=30&isVerify=1&pageNo=1
/**
 * @gameNo : 彩票类型85代表体彩大乐透
 * @provinceId : 省份ID？ 默认为0就好了
 * @pageSize : 页面大小 默认30
 * @isVerify : 必填的 默认1
 * @pageNo : 页码
 * @return : 返回体彩请求链接的返回数据
 *
 */
    public static String getLotteryUrlResponse(String url
            ,String gameNo
            , String provinceId
            ,String pageSize
            ,String isVerify
            ,String pageNo) throws IOException {
        return Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .data("gameNo",gameNo)
                .data("provinceId",provinceId)
                .data("pageSize",pageSize)
                .data("isVerify",isVerify)
                .data("pageNo",pageNo)
                .ignoreContentType(true)
                .timeout(10000)
                .execute().body();
    }
    public static Element getCqGovResponse(String url) throws IOException {
        return Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Content-Type", "application/json;charset=UTF-8")
                .get();
    }
}
