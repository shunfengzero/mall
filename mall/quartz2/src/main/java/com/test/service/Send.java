package com.test.service;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.test.dao.UserDaop;
import com.test.entity.User1;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

@Component
public class Send implements Job{

    @Resource
    private SendMessage sendMessage;
   @Resource
   private UserDaop ud;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

       // List<User1> allUsers = ud.findAllUsers();
       // for (User1 user : allUsers) {
            //String id = user.getIdentityCard();
           // String phone = user.getPhone();
            //410-323-19950420-4014
          //  String month = id.substring(10, 12);
          //  String day = id.substring(12, 14);
            LocalDate now = LocalDate.now();
            MonthDay birthday = MonthDay.of(12, 4);
            MonthDay today = MonthDay.from(now);
            String phone = "15565605381";
            if (birthday.equals(today)) {


                try {
                    SendSmsResponse response = sendMessage.sendSms(phone);

                    System.out.println("短信接口返回的数据----------------");
                    System.out.println("Code=" + response.getCode());
                    System.out.println("Message=" + response.getMessage());
                    System.out.println("RequestId=" + response.getRequestId());
                    System.out.println("BizId=" + response.getBizId());


                    //Thread.sleep(3000L);
                    //查明细
                    if (response.getCode() != null && response.getCode().equals("OK")) {
                        QuerySendDetailsResponse querySendDetailsResponse = sendMessage.querySendDetails(response.getBizId());
                        System.out.println("短信明细查询接口返回数据----------------");
                        System.out.println("Code=" + querySendDetailsResponse.getCode());
                        System.out.println("Message=" + querySendDetailsResponse.getMessage());
                        int i = 0;
                        for (QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs()) {
                            System.out.println("SmsSendDetailDTO[" + i + "]:");
                            System.out.println("Content=" + smsSendDetailDTO.getContent());
                            System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                            System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                            System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                            System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                            System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                            System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                            System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
                        }
                        System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
                        System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


         //   }
        }

    }


}
