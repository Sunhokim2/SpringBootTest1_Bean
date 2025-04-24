package org.example.basic.controller;

import java.util.List;

import org.example.basic.entity.TableExam1;
import org.example.basic.respository.TableExam1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlController {
    @Autowired
    TableExam1Repository tableExam1Repository;

    @GetMapping("/html/table1")
    @ResponseBody
    public List<TableExam1> table1() {
        List<TableExam1> list = tableExam1Repository.findAll();

        return list;
    }

    @GetMapping("/html/table1/add")
    @ResponseBody
    public TableExam1 addTable1(
            @ModelAttribute TableExam1 tableExam1) {
        TableExam1 result = tableExam1Repository.save(tableExam1);
        return result;
    }

    @GetMapping("/html/string")
    public String getHtmlString() {
        return "string";
    }
}