package com.shouyubang.web.dao;

import com.shouyubang.web.model.Bill;
import com.shouyubang.web.model.Response;

import java.util.List;

/**
 * Created by SYL on 2017/10/27.
 */
public interface BillDao {

    Bill getBillById(int id);

    void saveBill(Bill bill);

    List<Bill> getBillsByOwnId(String ownId);

    void updateBillStatus(Bill bill);

    Bill getBillByTradeNo(String tradeNo);

    int getBillStatus(String tradeNo);
}
