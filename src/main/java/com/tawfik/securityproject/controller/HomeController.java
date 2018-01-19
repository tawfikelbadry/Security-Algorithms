/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tawfik.securityproject.controller;

import com.tawfik.securityproject.algorithms.Combination.Combination;
import com.tawfik.securityproject.domain.domain;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author tawfik
 */
@Controller
public class HomeController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

}
