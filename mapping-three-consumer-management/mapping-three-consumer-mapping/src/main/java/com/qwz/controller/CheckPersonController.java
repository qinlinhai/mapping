package com.qwz.controller;

import com.qwz.base.ResultData;
import com.qwz.model.CheckPerson;
import com.qwz.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @description:
 * @author: Bing
 * @time: 2020/7/17 20:04
 */
@RestController
public class CheckPersonController{

   @Autowired
   private IProjectService iProjectService;

//    @PostMapping("/selectCheckPerson")
//    public ResultData selectCheckPerson(@RequestParam HashMap hashMap){
//        ResultData resultData = iProjectService.selectCheckPerson(hashMap);
//        return resultData;
//    }
//
//    @PostMapping("/insertCheckPerson")
//    public ResultData insertCheckPerson(@RequestBody CheckPerson checkPerson){
//        ResultData resultData = iProjectService.insertCheckPerson(checkPerson);
//        return resultData;
//    }
//
//    @PostMapping("/updateCheckPerson")
//    public ResultData updateCheckPerson(@RequestBody CheckPerson checkPerson){
//
//        ResultData resultData = iProjectService.updateCheckPerson(checkPerson);
//        return resultData;
//    }
//
//    @PostMapping("/delectOneCheckPerson")
//    public ResultData delectOneCheckPerson(@RequestParam String id){
//        ResultData resultData = iProjectService.delectOneCheckPerson(id);
//        return resultData;
//    }
}
