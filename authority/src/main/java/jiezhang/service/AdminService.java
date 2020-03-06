package jiezhang.service;


import jiezhang.entity.db.Admin;
import jiezhang.base.service.BaseService;

import java.util.List;

/**
 * 管理员服务接口
 *
 * @author jiezhang
 * @date 2015/3/10
 */
public interface AdminService extends BaseService<Admin, Exception> {
    /**
     * 登入
     *
     * @param admin
     * @return
     * @throws Exception
     */
    public Admin login(Admin admin) throws Exception;

    /**
     * 查询所有的管理员
     *
     * @return
     * @throws Exception
     */
    public List<Admin> findAll() throws Exception;
}
