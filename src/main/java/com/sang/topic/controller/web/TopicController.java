package com.sang.topic.controller.web;

import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/t")
public class TopicController {
    @Autowired
    PostService postService;
    @Autowired
    TopicService topicService;

    @GetMapping("/{topicId}")
    public ModelAndView topic(@PathVariable Integer topicId, Page page, Map<String, Object> model)
            throws ResultException {
        model.put("posts", postService.getByTopicId(topicId, page));
        model.put("nav2", topicService.getBrother(topicId));
        model.put("page", page);
        model.put("topicId", topicId);
        return new ModelAndView("topic");
    }
}
