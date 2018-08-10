package com.shouyubang.web.controller.api;

import com.shouyubang.web.model.*;
import com.shouyubang.web.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.data;


@RestController
@RequestMapping("/api/pay")
public class PayApiController {

    @Autowired
   private PayService payService;

//    @RequestMapping(value = "/wxpay/notify", method = RequestMethod.POST, consumes = "application/xml")
//    public ReturnVO getNotifyMsg(@RequestBody NotifyModel notifyModel) {
//        ReturnVO response = new ReturnVO();
//        response.setReturnCode("SUCCESS");
//        response.setReturnMsg("OK");
//        payService.handleNotifyMsg(notifyModel);
//        payService.updateBillAndCredit(notifyModel.getOut_trade_no(),notifyModel.getTotal_fee());
//        System.out.print(notifyModel.toString());
//        return response;
//    }



//    @RequestMapping(value = "/genOrder")
//    @ResponseBody
//    public Bill genOrder(@RequestParam(value = "own_id") String userId,
//                         @RequestParam(value = "peer_id", required = false) String staffId,
//                         @RequestParam(value = "create_ip") String createIp,
//                         @RequestParam(value = "body", required = false) String body,
//                         @RequestParam(value = "total_fee", required = false) Integer totalFee) {
//        return payService.genOrder(userId, createIp,staffId,body,totalFee);
//    }

    @RequestMapping(value = "/genOrder", method= RequestMethod.POST, consumes="application/json")
    public Response genOrder(@RequestBody Bill bill) {
        Response response = new Response(103,"SUCCESS");
        System.out.print(bill.toString());
        payService.genOrder(bill);
        response.setData(bill.getTradeNo());
        return response;
    }


//    @RequestMapping(value = "/requestWXPay")
//    @ResponseBody
//    public ReturnModel requestWXPay(@RequestParam(value = "tradeNo") String tradeNo,
//                                    @RequestParam(value = "createIp") String createIp) {
//        return payService.wxPrepay(tradeNo, createIp);
//    }
//
    @RequestMapping(value = "/requestWXPay",method= RequestMethod.POST, consumes="application/json")
    public Response requestWXPay(@RequestBody Bill bill) {
        System.out.print(bill.toString());
        payService.genOrder(bill);
        return  payService.wxPrepay(bill.getTradeNo(), bill.getCreateIp());

    }



    @RequestMapping(value = "/checkOrder", method = RequestMethod.GET)
    @ResponseBody
    public Response checkOutOrder(@RequestParam(value = "trade_no") String tradeNo) {
        Response response = new Response(106,"SUCCESS");
         int status=payService.checkOutBill(tradeNo);
         if(status==0){
             response.setMessage("FAIL PAID");
         }
         else if(status==-1)
             response.setMessage("NOT EXIST");
         else {
             response.setMessage("SUCCESS PAID");
         }
        return response;
    }

    @RequestMapping(value = "/wxpay/notify")
    public ReturnVO getNotifyMsg(@RequestBody NotifyModel notifyModel){
        ReturnVO response = new ReturnVO();
        response.setReturnCode("SUCCESS");
        response.setReturnMsg("OK");
        payService.handleNotifyMsg(notifyModel);
        payService.updateBillAndCredit(notifyModel.getOut_trade_no(),notifyModel.getTotal_fee());
        System.out.print(notifyModel.toString());
        return response;
    }



}
