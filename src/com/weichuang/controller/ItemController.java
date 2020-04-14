package com.weichuang.controller;

import com.weichuang.pojo.Item;
import com.weichuang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 1、将我们这个类配置进入到spring容器中进行初始化
 * 2、标记此类为controller层的类，只有标记了这个@Controller的类才会被前端控制器扫描
 */
@Controller
//@RequestMapping("item")
public class ItemController {

    @Autowired
    ItemService itemService;
    @RequestMapping("/itemList.do")
    public ModelAndView getItemList(HttpServletRequest request , HttpSession session){
        List<Item> itemList = itemService.getItemList();
        System.out.println("itemList = " + itemList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList",itemList);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    @RequestMapping("/editItem.do")
    public ModelAndView editItem(@RequestParam(value = "id" , required = true) int idxx  , Model model){
        Item item = itemService.getItemById(idxx);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("item",item);
        modelAndView.setViewName("editItem");

        return modelAndView;
    }

    /**
     * 将页面修改后的商品信息保存到数据库中。
     */
    @RequestMapping("/updateItem.do")
    public String updateItem(Item item , Model model){
        int rows = itemService.updateItem(item);
        if(rows > 0){
            List<Item> itemList = itemService.getItemList();
            model.addAttribute("itemList" , itemList);
            return "itemList";
        }else{
            return "editItem";
        }
    }

    @RequestMapping(value = "/json.do" , method = {RequestMethod.POST , RequestMethod.GET})
    @ResponseBody
    public Item jsonTest(Item item){
        System.out.println("item  = " + item);
        item.setDetail("  @ResponseBody 处理后的对象");
        return item;
    }
}
