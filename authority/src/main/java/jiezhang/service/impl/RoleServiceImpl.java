package jiezhang.service.impl;

import jiezhang.entity.db.Role;
import jiezhang.mapper.RoleMapper;
import jiezhang.service.RoleService;
import jiezhang.base.service.AbstractService;
import org.springframework.stereotype.Service;

/**
 * 角色服务实现类
 *
 * @author jiezhang
 * @date 2017/6/15
 */
@Service
public class RoleServiceImpl extends AbstractService<Role, RoleMapper> implements RoleService {
    //@Override
//    public DataTablePage queryBindPage(Map parameters, DataTablePage page) throws Exception {
//        page.setParams(parameters);
//        List<Role> list = dao.queryDataTablePage(page);
//        page.setAaData(list);
//        return null;
//    }

    //@Override
//    public DataTablePage queryUnbindPage(Map parameters, DataTablePage page) throws Exception {
//        return null;
//    }
}
