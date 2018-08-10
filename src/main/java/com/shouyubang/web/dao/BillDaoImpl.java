package com.shouyubang.web.dao;

import com.shouyubang.web.model.Bill;
import com.shouyubang.web.model.Response;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import java.util.List;

/**
 * Created by SYL on 2017/10/27.
 */
@Repository("BillDao")

    public class BillDaoImpl extends AbstractDao<Integer, Bill> implements BillDao {
        @Override
        public void saveBill(Bill bill) {
            persist(bill);
        }

//        public List<Bill> getBillsByMobile(String userMobile) {
//            Query query = new Query(Criteria.where(OWN_ID).is(userMobile).and(PAY_STATUS).is(APIConstants.PAY_NO));
////            query.with(new Sort(new Sort.Order(Sort.Direction.DESC, TIME_CREATE)));  //倒序
//            return mongo.find(query, BillModel.class);
//        }

        @Override
        @SuppressWarnings("unchecked")
        public List<Bill> getBillsByOwnId(String ownId) {
            Criteria criteria = createEntityCriteria();
            criteria.add(Restrictions.eq("ownId", ownId));
            return (List<Bill>) criteria.list();
        }

//        @Override
//        public void updateBillStatus(Bill bill) {
//            Response result = new Response(1,"");
//            Query query = new Query();
//            query.addCriteria(Criteria.where(TRADE_NO).is(tradeNo).and(OWN_ID).is(userMobile));
//
//            BillModel bill = mongo.findOne(query, BillModel.class);
//
//            if(null != bill) {
//                Update update = new Update();
//                update.set(PAY_STATUS, APIConstants.PAY_FINISH);
//
//                mongo.updateFirst(query, update, QuestionModel.class);
//                result.setCode(0);
//                result.setMessage("SUCCESS");
//            }
//            else {
//                result.setCode(-1);
//                result.setMessage("该问题不存在");
//            }
//            BillModel updatedBill = mongo.findOne(query, BillModel.class);
//            System.out.println( "updatedBill: " + updatedBill.toString());
//            return result;
//            update(bill);
//        }
    @Override
    public void updateBillStatus(Bill bill) {
        update(bill);

    }

    @Override
    public Bill getBillById(int Id) {
            return getByKey(Id);
        }

    @Override
    public Bill getBillByTradeNo(String tradeNo) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("tradeNo", tradeNo));
        return (Bill) criteria.uniqueResult();
    }

    @Override
    public int getBillStatus(String tradeNo) {
        Bill bill = getBillByTradeNo(tradeNo);
        if(bill==null)
            return -1;
        else
        return bill.getPayStatus();
    }

    }

