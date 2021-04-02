package jiezhang.entity.db;


import jiezhang.annotation.ForeignTableId;
import jiezhang.annotation.Id;
import jiezhang.annotation.PrimaryTableId;
import jiezhang.annotation.TableName;
import jiezhang.entity.BaseEntity;
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
