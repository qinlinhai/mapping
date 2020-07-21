package qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ResultCommitController {
    @Autowired
    private IProjectService iProjectService;

    /**
     * @author  qlh
     * @date   2020/7/18
     * @desc
     * 根据 成果名称 项目类型  成果日期
     **/
    @GetMapping("/selectResultCommitByNmeAndTypeAndDate")
    public ResultData selectResultCommitByNmeAndTypeAndDate(@RequestParam("name") String name, @RequestParam("type") String type,
                                                            @RequestParam("date") String date){
      return iProjectService.selectResultCommitByNmeAndTypeAndDate(name,type,date);
    }
}
