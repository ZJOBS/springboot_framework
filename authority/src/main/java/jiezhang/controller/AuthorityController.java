package jiezhang.controller;

import jiezhang.entity.UAI;
import jiezhang.base.constant.BaseConstants;
import jiezhang.base.controller.BaseController;
import org.springframework.stereotype.Controller;

/**
 * Created by ZhangJie on 2016/4/13.
 */
@Controller
public class AuthorityController extends BaseController {

    protected UAI getUAI() {
        return (UAI) getSession().getAttribute(BaseConstants.UAI);
    }

    protected String getUai() {
        UAI u = getUAI();
        return u == null ? "" : u.getAdminName();
    }

}
