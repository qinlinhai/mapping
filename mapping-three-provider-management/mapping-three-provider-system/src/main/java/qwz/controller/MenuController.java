package qwz.controller;

import com.qwz.base.BaseService;
import com.qwz.base.ResultData;
import com.qwz.model.Menu;
import com.qwz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qwz.base.CommonController;

/**
 * @author WCX
 * @data 2020/7/16 8:54
 * @describe
 */
@RestController
public class MenuController extends CommonController<Menu> {
    @Autowired
    private MenuService menuService;
    @Override
    public BaseService<Menu> getBaseService() {
        return menuService;
    }
    /**
     * 查询所有菜单信息
     */
    @GetMapping("/allMenu")
    public ResultData allMenu(){
        return menuService.allMenu();
    }
}
