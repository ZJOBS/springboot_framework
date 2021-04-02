package jiezhang.service.impl;


import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import jiezhang.service.QiNiuService;
import jiezhang.service.SequenceService;
import jiezhang.utils.FileUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;

/**
 * 七牛网服务
 * Created by ZhangJie on 2017/3/9.
 */
@Service
public class QiNiuServiceImpl implements QiNiuService {
    @Value("${properties.qiNiu_AccessKey}")
    private String ak;
    @Value("${properties.qiNiu_SecretKey}")
    private String sk;
    private String bucketname = "image";//七牛的空间，可在七年网站上做管理，是否需要

    @Autowired
    @Qualifier("snowflakeSequenceImpl")
    private SequenceService sequenceService;

    private String getUpToken() {
        Auth auth = Auth.create(ak, sk);
        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
    }

    @Override
    public long uploadFile(MultipartFile file) throws Exception {
        File file1 = FileUtils.multipartToFile(file);
        return uploadFile(file1);

    }


    /*上传图片到七牛云*/
    @Override
    public long uploadFile(File file) throws Exception {
        FileInputStream fis = null;
        int l = (int) (file.length());
        byte[] src = new byte[l];
        fis = new FileInputStream(file);
        fis.read(src);
        String file64 = Base64.encodeToString(src, 0);
        long sequence = sequenceService.getSequence();
        String key = String.valueOf(sequence);
        String url = "http://upload.qiniu.com/putb64/" + l + "/key/" + UrlSafeBase64.encodeToString(key);
        //非华东空间需要根据注意事项 1 修改上传域名
        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder().
                url(url).
                addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        //需要做错误处理
        System.out.println("需要做异常处理" + response);
        return sequence;
    }
}
