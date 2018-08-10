package com.shouyubang.web.service;

import com.shouyubang.web.utils.ApiConstants;
import com.shouyubang.web.utils.Base64Service;
import com.shouyubang.web.utils.HmacSHA1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by KunLiu on 2017/3/7.
 */

@Service
@ComponentScan("com.shouyubang.web.utils")
public class AuthService {

    @Autowired
    Base64Service mBase64Service;

    @Autowired
    HmacSHA1Service mHmacSHA1Service;

    private String appSignBase(long expired, String fileId, String bucketName) {

        long current = System.currentTimeMillis() / 1000;
        int rdm = Math.abs(new Random().nextInt());
        String plainText = "a=" + ApiConstants.COS_APP_ID + "&b=" + bucketName + "&k=" + ApiConstants.SECRET_ID + "&e=" + expired + "&t=" + current + "&r=" + rdm + "&f=" + fileId ;

        byte[] bin = hashHmac(plainText, ApiConstants.SECRET_KEY);

        byte[] all = new byte[0];
        if (bin != null) {
            all = new byte[bin.length + plainText.getBytes().length];
            System.arraycopy(bin, 0, all, 0, bin.length);
            System.arraycopy(plainText.getBytes(), 0, all, bin.length, plainText.getBytes().length);
        }

        return mBase64Service.encode(all);

    }

    public String appSign(long expired, String bucket) {
        return appSignBase(expired, "", bucket);
    }

    public String appSignOnce(String filename, String bucket){
        String fileId = "/"  + ApiConstants.COS_APP_ID + "/" + bucket + filename;
        return appSignBase(0, fileId, bucket);
    }

    private byte[] hashHmac(String plain_text, String accessKey) {

        try {
            return mHmacSHA1Service.getSignature(plain_text, accessKey);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
