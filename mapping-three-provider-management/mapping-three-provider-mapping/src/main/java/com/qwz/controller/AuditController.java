package com.qwz.controller;

import com.qwz.base.BaseController;
import com.qwz.model.Audit;
import com.qwz.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuditController extends BaseController{

    @Autowired
    private AuditService auditService;
}
