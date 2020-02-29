package com.tensquare.base.controller;

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;
    @GetMapping("")
    public Result findAll(){
        List<Label> labelList = labelService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",labelList);
    }
    @GetMapping("/{labelId}")
    public Result findById(@PathVariable String labelId){
        int i=1/0;
        Label label = labelService.findById(labelId);
        return new Result(true,StatusCode.OK,"查询成功",label);
    }
    @PostMapping("")
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,"新增成功");
    }
    @PutMapping("")
    public Result update(@RequestBody Label label){
        labelService.update(label);
        return new Result(true,StatusCode.OK,"更新成功");
    }
    @DeleteMapping("/{labelId}")
    public Result update(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true,StatusCode.OK,"删除成功");
    }
    @PostMapping("/search/{page}/{size}")
    public Result findSearch(@RequestBody(required = false) Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageData =labelService.pageQuery(label,page,size);
        return new Result(true,StatusCode.OK,"查询成功",new PageResult<Label>(pageData.getTotalElements(),pageData.getContent()));
    }
}
