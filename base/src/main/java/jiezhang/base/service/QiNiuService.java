package jiezhang.base.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by ZhangJie on 2017/3/9.
 */
public interface QiNiuService {


    /**
     * @param multipartFile 文件
     * @return long
     * @throws Exception
     */
    public long uploadFile(MultipartFile multipartFile) throws Exception;

    /**
     * @param file 文件
     * @return long
     * @throws Exception
     */
    public long uploadFile(File file) throws Exception;
}
