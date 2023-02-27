package com.mybatis.sample.sample.Controller;

import com.mybatis.sample.sample.Service.SampleService;
import com.mybatis.sample.sample.configuration.exception.BaseException;
import com.mybatis.sample.sample.configuration.http.BaseResponse;
import com.mybatis.sample.sample.configuration.http.BaseResponseCode;
import com.mybatis.sample.sample.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/board")
public class SampleRestController {

    @Autowired
    private SampleService service;

    @PostMapping
//    @GetMapping
    public BaseResponse<List<Board>> getList(@RequestParam(name = "ids[]", required = false) List<Integer> ids){
//        return service.getList();
//        model.addAttribute("dataList",ids.toString());
//        model.addAttribute("dataList",service.getList());
        System.out.println("ids = " + ids.getClass());
        System.out.println("ids = " + ids);
        return new BaseResponse(service.getList());
    }

    @GetMapping("/{boardSeq}")
    public BaseResponse<Board> get(@PathVariable("boardSeq")  int seq){
        Board board = service.get(seq);
        // null check
        if ( board == null ){
            throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"게시물"});
        }
        return new BaseResponse<Board>(service.get(seq));
    }
    //    등록 / 수정 처리
    @GetMapping("/save")
    public BaseResponse<Integer> save(Board parameter){
        // 제목 필수 체크
        if (StringUtils.isEmpty(String.valueOf(parameter.getTitle()))){
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "title","제목" });
        }
        // 내용 필수 체크
        if (StringUtils.isEmpty(String.valueOf(parameter.getContents()))){
            throw new BaseException(BaseResponseCode.VALIDATE_REQUIRED, new String[] { "contents","내용" });
        }
        service.save(parameter);

        return new BaseResponse<Integer>(parameter.getBoardSeq());
    }

    @GetMapping("/delete/{boardSeq}")
    public boolean delete(@PathVariable("boardSeq")  int seq){
        Board board = service.get(seq);
        if(board == null){
            return false;
        }
        service.delete(seq);
        return true;
    }
}
