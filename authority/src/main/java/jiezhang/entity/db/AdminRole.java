package jiezhang.entity.db;


import jiezhang.base.annotation.ForeignTableId;
import jiezhang.base.annotation.Id;
import jiezhang.base.annotation.PrimaryTableId;
import jiezhang.base.annotation.TableName;
import jiezhang.base.entity.BaseEntity;
import lombok.Data;

/**
 * 角色用户表实体类
 *
 * @author ZhangJie
 * @date 2017/6/21
 */
@TableName(name = "system_admin_role")
@Data
public class AdminRole extends BaseEntity {
    @Id
    private String adminRoleId;
    @PrimaryTableId
    private String adminId;
    @ForeignTableId
    private String roleId;
}
