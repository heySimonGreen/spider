package lottery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: chenwei
 * @date: 2021/7/20 22:44
 */
public class SpiderTest {
    public static void main(String[] args) throws IOException {
        long startTime=System.currentTimeMillis();
        int pageNo = 72;
        String url = "https://webapi.sporttery.cn/gateway/lottery/getHistoryPageListV1.qry";
        //?gameNo=85&provinceId=0&pageSize=30&isVerify=1&pageNo=2
        String gameNo = "85";
        String provinceId = "0";
        String pageSize = "30";
        String isVerify = "1";
        for (int i = 1; i<=pageNo; i++){
            String response = SpiderTool.getLotteryUrlResponse(url,gameNo,provinceId,pageSize,isVerify,String.valueOf(i));

            JSONObject jsonObjectBody = JSONObject.parseObject(response);
            JSONObject jsonObjectValue = JSONObject.parseObject(jsonObjectBody.get("value").toString());

            JSONArray jsonArray = JSON.parseArray(jsonObjectValue.get("list").toString());
            for (int j=0;j<jsonArray.size();j++){
                JSONObject jsonObjectList = JSONObject.parseObject(jsonArray.get(j).toString());
                /**
                 * @lotteryDrawResult：开奖结果
                 * */
                String lotteryDrawResult = jsonObjectList.get("lotteryDrawResult").toString();
                /**
                 * @lotteryDrawTime：开奖时间
                 * */
                String lotteryDrawTime = jsonObjectList.get("lotteryDrawTime").toString();
                /**
                 * @lotteryDrawNum：期号
                 * */
                String lotteryDrawNum = jsonObjectList.get("lotteryDrawNum").toString();
                /**
                 * @poolBalanceAfterdraw：奖池奖金
                * */
                String poolBalanceAfterdraw = jsonObjectList.get("poolBalanceAfterdraw").toString();
                String data = "lotteryDrawNum : " + lotteryDrawNum +" lotteryDrawTime : "
                        + lotteryDrawTime + " lotteryDrawResult " + lotteryDrawResult+ " poolBalanceAfterdraw : " + poolBalanceAfterdraw;
                WriteDataToTxt.writeStringDataToTxt(data,"src/data/lotteryData.txt");
                System.out.println(data);
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
