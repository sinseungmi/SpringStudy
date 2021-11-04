package com.kgitbank.practice;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgitbank.model.Market;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
   
   @Autowired
   private Market market;
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      log.info("Welcome home!");
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      model.addAttribute("market", market );
      
      //완전한 인스턴스라고 보기엔 어렵고 스테틱하다
      market.getFruit().setName("apple"); 
      System.out.println(market);
      
      
      return "home";
    //리턴을할 때 포워드 됨
   }
   
}