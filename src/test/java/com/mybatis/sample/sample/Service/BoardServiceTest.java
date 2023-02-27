package com.mybatis.sample.sample.Service;

import com.mybatis.sample.sample.domain.Board;
import org.junit.jupiter.api.Test;

class SampleServiceTest {

    @Test
    void getList() {
        Board br = new Board();
        br.setTitle("test");

        System.out.println("br.getTitle() = " + br.getTitle());
    }

    @Test
    void get() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}