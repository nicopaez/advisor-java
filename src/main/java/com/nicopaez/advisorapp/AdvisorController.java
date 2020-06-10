package com.nicopaez.advisorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdvisorController {

    @Autowired
    BuildProperties buildProperties;

    @RequestMapping(value="/", method= RequestMethod.GET)
    public Map<String, Object> index() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("version", buildProperties.getVersion());
        return map;
    }

}
