package com.mybatis.sample.sample.Service;

import com.mybatis.sample.sample.domain.Board;
import com.mybatis.sample.sample.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    sample Test
 */
@Service
public class SampleService {

    @Autowired
    private SampleRepository repository;
//    select * from
    public List<Board> getList(){
        return repository.getList();
    }
    // select * from where
    public Board get(int seq){
        return repository.get(seq);
    }
//    insert into table value
    public void save(Board parameter){
        Board board = repository.get(parameter.getBoardSeq());
        System.out.println("board = " + board);
        if(board == null){
            repository.save(parameter);
        } else{
            repository.update(parameter);
        }
    }
//    delete  from table
    public void delete(int seq){
        repository.delete(seq);
    }
}
