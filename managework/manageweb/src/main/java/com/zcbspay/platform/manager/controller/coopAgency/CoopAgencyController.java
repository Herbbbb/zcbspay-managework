package com.zcbspay.platform.manager.controller.coopAgency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zcbspay.platform.manager.merchant.service.CoopAgencyService;

@Controller
@RequestMapping("/coopAgency")
@SuppressWarnings("all")
public class CoopAgencyController {
	
	@Autowired
	private CoopAgencyService coopAgencyService;

}
