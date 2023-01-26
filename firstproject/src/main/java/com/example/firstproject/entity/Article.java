package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자를 추가해주는 어노테이션
@ToString
@Getter
public class Article {
    @Id // 대표값을 지정! like a 주민번호
    @GeneratedValue // 1, 2, 3, ... 자동 생성 어노테이션
    private Long id;
    @Column //DB 안에서의 테이블과 연관되게 만들어 주는 것
    private String title;
    @Column
    private String content;

}