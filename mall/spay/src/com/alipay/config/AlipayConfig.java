package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2017113000269752";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCPX6z5v6lP1wtiLhcbcceRZfW259meHJDg5Htl0WlSBcn0olGBzZpYFBaFcZ3J9RtubKWGF4Yyk18EdeG/fkClrLP08Ci+yRfq25ZZ9jXWIVLHYfQ4zbyM9MELBk8WXXdJEaeb8+b1+MoIVXyAUv7LYXCwCsL6LD2jCoNWhSEyuYHzneR1GBuLsvrDRcNBAc+DJDyZzLaWUJHxjPTR5aHJjPCa+NOtWfoyY5WdAA2b1xC3DwhdMtfz5ApBatQYhhHzzByTwzs6TbYTZjnAZ1/VOHa6GN3IGnowT5HnTq5vhhxBs0wdRQdO7tdfw3RvN8NlrvfFn3HmM3t8qrh2wS8rAgMBAAECggEAKPkVrNX6I+f3x9oWHnC4sLOrsda2WToeqTaCkUl0SM2AtpnAo1DHoA41lXMvvax/Z2JDN3v3jPKSv+qUVi5VeUNOtlv/uO4tGKAiapkzL3ucdYBn0+fvz3SOyoDGD0UstsQF20qroXW0/wa3KtENIcA5/QVGTUphXvu9Jveq0hzEgta10kQL4p8aj5GOVGIsMEOtM+WuiwaA6TGxbaRAK2xksI8d1Or2KZlInrUpmOv+Oq8iuEUFYyCiqOH8SVghAC+eySQQtE7ZyUZD1fGBNxJQ0PvroUn0rZjSi5m6iPK4fLWTf+JjyHQuV/1v3o4rOiQpLKNvzYLaFQycmiwkEQKBgQDjwXuhcB2Qtk6baBEGm+OKH5MugRsZQ4YmLasBt1RBg95yZCBOo2xZ+n44kbzm9ZrdQlB6AhWSog1s2KexNKi/ARz/WPBDSKMFUKMQi9ielMd7GTvOmBBSRKa4xLDYNTPde6gexLF6thTo3rqezRg/Hal1CvJZP8kva/gdLjqKiQKBgQChJ1UkIO7QA92Y4N68NVtHsWXQlGkHLWgFciLI//Ick2vQ2wJCJNu4BX5ag/Ia/SVfTzgNFgXccCszCGO2k0S/+nr3/GpE0zSXlNlC+0SIMOERPAGWU5/zd2aipW91D9XsRwilRLQjyb6Y3h73SRzFtXmGmaT1GUANi9Q497vvEwKBgCaM+HUx+f8lrJaHfeJFfrVBdPM5LTIQiONrdXeb5WoVfRCVvBYzeUKdsMG4gWYCio0LDX4pXidswKL85R2MkUeLU7IxBrIM2HMs2/0P/sGQ41cFxWbJvHGAZ0v9FwXxs2644JMcrgHcUhu8n5ADnSgJyEYkbTMIJfCd8OhXi9cpAoGALN8Ozeh9ll39LbwvSKhyqhuzBcjNFbqG5D1LgjwB5gMGWjkg/9nTdAHTlNB4cRtbdJZSPRKMvzxcSvFjEksfMXVFGBeoX1GPq0U+2W+tPV6ezHWw23KdbuUoJtF5n1axcgC1X48puW1LLLVsWd55rHNDSz8stzI4q4zropEYOxECgYBmoZGG/5/I5LEdp0ZwmHcQhvvHQB84vOifR3/FtNjwUFMAvR9LTiDCLDzLgjN2H58zuutwj0Gh/CwQJqgw9zx5LbauHZ0Cv+HMI4b9tIjj7ZSbPhXr6NaT9d3tH1vf0cER61zVxafFPBqnZTwXG4j5nEoGTCXaKoDFryk/om4MEA==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvdK5+ivFK9+cdIyVDiutfzXEq8BsNSaIoJjmOn0tY3G4ZfEUfqt3MCNaGu0CuFl4qqScQpVaW7fHa5S1tqJrckv9JqzeG1WNtYNLvyP/ghpE8dbsnB/Jtvdi9Jl3hsyQZIoEc/Cvhhevq+yxwOWxGKK9XGgJF8xqCORHCye0Rl+weORi/1iBsy2Vq47WNqE6y/C5YqpZGvnpjQ/fpp9OkeXPAM+vRQjO7lE1rAEVkvm7y/V7Ek3MO7+pPHAvlQ8oetJSVYSFdtC/2bmpB94o2UwtjQzEntr9WZJalKYjURfOfS/1acWoBI7to3/vci0pE02Zd6psZXwffMFeRjUNQwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

