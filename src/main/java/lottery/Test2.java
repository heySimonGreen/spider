package lottery;

import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * @author: chenwei
 * @date: 2021/7/20 21:21
 */
public class Test2 {
    private static final Logger logger = LogManager.getLogger("HelloWorld");
    public static void main(String[] args) throws IOException {
        int pageNo = 72;
        String url = "https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry";
        //?gameNo=85&provinceId=0&pageSize=30&isVerify=1&pageNo=2
        String gameNo = "85";
        String provinceId = "0";
        String pageSize = "30";
        String isVerify = "1";
        String response = SpiderTool.getLotteryUrlResponse(url,gameNo,provinceId,pageSize,isVerify,String.valueOf(73));
        JSONObject jsonObjectBody = JSONObject.parseObject(response);
        JSONObject jsonObjectValue = JSONObject.parseObject(jsonObjectBody.get("value").toString());
        System.out.println(jsonObjectValue);
        logger.info("hello world");
        logger.info("hello world");
    }
}
