package com.mysiteforme.admin.controller.photos;

import com.mysiteforme.admin.base.BaseController;
import com.mysiteforme.admin.entity.BlogChannel;
import com.xiaoleilu.hutool.log.Log;
import com.xiaoleilu.hutool.log.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("showPhotos")
@Controller
public class PhotoPageController extends BaseController {

    private static Log log = LogFactory.get();

    @GetMapping(value = {"index","","/"})
    public String index(HttpServletRequest httpServletRequest, Model model){
        String href = httpServletRequest.getRequestURI();
        href = href.replaceFirst("/showPhotos","");
        BlogChannel blogChannel = blogChannelService.getChannelByHref(href);
        model.addAttribute("channel",blogChannel);
        return "photos/index";
    }
}
