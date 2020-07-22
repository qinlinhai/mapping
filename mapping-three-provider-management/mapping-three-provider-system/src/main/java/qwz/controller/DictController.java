package qwz.controller;

import com.github.pagehelper.PageInfo;
import com.qwz.base.BaseService;
import com.qwz.base.ResultData;
import com.qwz.model.Dict;
import com.qwz.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qwz.base.CommonController;

import java.util.List;
import java.util.Map;

/**
 * @author WCX
 * @data 2020/7/17 11:07
 * @describe
 */
@RestController
public class DictController extends CommonController<Dict> {
    @Autowired
    private DictService dictService;
    @Override
    public BaseService<Dict> getBaseService() {
        return dictService;
    }
    /**
     * 分页展示字典中的数据
     */
    @GetMapping("/allDict")
    public ResultData allDict(@RequestParam Map map){
        PageInfo<Dict> dictPageInfo = dictService.allDict(map);
        if (dictPageInfo.getSize()>0&&dictPageInfo!=null){
            return super.selectSuccess(dictPageInfo);
        }
        return super.selectFailed();
    }
    /**
     * 增加字典数据
     */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict){
        Integer integer = dictService.insertSelective(dict);
        return super.addInfo(integer);
    }
    /**
     * 修改字典中的数据
     */
    @PostMapping("/updateDict")
    public ResultData updateDict(@RequestBody Dict dict){
        Integer update = dictService.update(dict);
        return super.updateInfo(update);
    }
    /**
     * 删除字典中的数据
     */
    @PostMapping("/deleteDict")
    public ResultData deleteDict(@RequestBody List<Integer> ids){
        Integer integer = dictService.deleteByIds(ids);
        return super.deleteInfo(integer);
    }


}
