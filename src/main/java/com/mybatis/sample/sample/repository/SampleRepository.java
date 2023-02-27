package com.mybatis.sample.sample.repository;

import com.mybatis.sample.sample.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository {
    // 다건
    List<Board> getList();
    //단건
    Board get(int boardSeq);

    void save(Board board);

    void update(Board board);

    void delete (int boardSeq);
}
