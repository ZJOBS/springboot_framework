package jiezhang.base.utils;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 文件工具
 *
 * @author jiezhang
 */
public class FileUtils {

    /**
     * MultipartFile 转换成File
     *
     * @param multfile 原文件类型
     * @return File
     * @throws IOException
     */
    public static File multipartToFile(MultipartFile multfile) throws IOException {
        CommonsMultipartFile cf = (CommonsMultipartFile) multfile;
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        File file = fi.getStoreLocation();
        return file;
    }


    /**
     * 删除文件
     *
     * @param filepath
     * @throws IOException
     */
    public static void del(String filepath) throws IOException {
        // 定义文件路径
        File f = new File(filepath);
        if (f.exists()) {
            // 判断是否存在
            if (f.isDirectory()) {
                //如果是文件夹
                if (f.listFiles().length == 0) {
                    // 若目录下没有文件则直接删除
                    f.delete();
                } else {
                    // 若有则把文件放进数组，并判断是否有下级目录
                    File delFile[] = f.listFiles();
                    int i = f.listFiles().length;
                    for (int j = 0; j < i; j++) {
                        if (delFile[j].isDirectory()) {
                            // 递归调用del方法并取得子目录路径
                            del(delFile[j].getAbsolutePath());
                        }
                        // 删除文件
                        delFile[j].delete();
                    }
                }
            } else {
                f.delete();
            }
        }
    }

    /**
     * 复制文件
     *
     * @param sourceFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        if (sourceFile.exists()) {
            BufferedInputStream inBuff = null;
            BufferedOutputStream outBuff = null;
            try {
                // 新建文件输入流并对它进行缓冲
                inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
                // 新建文件输出流并对它进行缓冲
                outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
                // 缓冲数组
                byte[] b = new byte[1024 * 5];
                int len;
                while ((len = inBuff.read(b)) != -1) {
                    outBuff.write(b, 0, len);
                }
                // 刷新此缓冲的输出流
                outBuff.flush();
            } finally {
                // 关闭流
                if (inBuff != null) {
                    inBuff.close();
                }
                if (outBuff != null) {
                    outBuff.close();
                }
            }
        }
    }

    /**
     * 向客户端下载文件,弹出下载框.
     */
    public static void exportFile(HttpServletResponse response, File file, boolean isDel) throws IOException {
        OutputStream out = null;
        InputStream in = null;
        // 获得文件名
        String filename = URLEncoder.encode(file.getName(), "UTF-8");
        // 定义输出类型(下载)
        response.setContentType("application/force-download");
        response.setHeader("Location", filename);
        // 定义输出文件头
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        out = response.getOutputStream();
        in = new FileInputStream(file.getPath());
        byte[] buffer = new byte[1024];
        int i = -1;
        while ((i = in.read(buffer)) != -1) {
            out.write(buffer, 0, i);
        }
        in.close();
        out.close();
        if (isDel) {
            //删除文件,删除前关闭所有的Stream.
            file.delete();
        }
    }

    /**
     * 产生临时文件
     *
     * @return
     * @throws IOException
     */
    public static File getTempFile(String fieldName) throws IOException {
        // 创建文件
        File f = new File(fieldName + ".xls");
        f.createNewFile();
        return f;
    }
}
