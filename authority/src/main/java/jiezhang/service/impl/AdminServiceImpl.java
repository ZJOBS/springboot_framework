package jiezhang.service.impl;

import jiezhang.entity.db.Admin;
import jiezhang.mapper.AdminMapper;
import jiezhang.service.AdminService;
import jiezhang.base.entity.DataTablePage;
import jiezhang.base.service.AbstractService;
import jiezhang.base.utils.EncryptAndDecryptUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 管理员服务实现类
 *
 * @author jiezhang
 * @date 2015/3/10
 */
@Service
public class AdminServiceImpl extends AbstractService<Admin, AdminMapper> implements AdminService {

    @Override
    public int createEntity(Admin entity) throws Exception {
        long a = sequenceService.getSequence();
        entity.setAdminId(String.valueOf(a));
        String encryptPassword = EncryptAndDecryptUtil.encrypt("111111");
        entity.setPassword(encryptPassword);
        entity.setCreateUserName(entity.getName());
        entity.setUpdateUserName(entity.getName());
        Admin odlUser = mapper.selectEntity(entity.toMap());
        if (odlUser == null) {
            int isInsert = mapper.insertEntity(entity);
            if (isInsert == 1) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public Admin login(Admin admin) throws Exception {
        String encryptPassword = EncryptAndDecryptUtil.encrypt(admin.getPassword());
        admin.setPassword(encryptPassword);
        admin = mapper.selectEntity(admin.toMap());
        if (admin != null) {
            admin.setPassword(null);
        }
        return admin;
    }

    @Override
    public List<Admin> findAll() throws Exception {
        return mapper.selectAll();
    }

    @Override
    public DataTablePage queryPage(Map parameters, DataTablePage page) throws Exception {
        page.setParams(parameters);
        List<Admin> list = mapper.queryDataTablePage(page);
        page.setAaData(list);
        return page;
    }
}
