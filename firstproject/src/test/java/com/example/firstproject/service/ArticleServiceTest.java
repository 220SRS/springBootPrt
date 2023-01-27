package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 해당 클래스는 스프링부트와 연동되어 테스팅된다.
class ArticleServiceTest {

    @Autowired ArticleService articleService;

    @Test
    void index() {
        //예상 시나리오
        Article a = new Article(1L, "ㄱㄱㄱㄱ", "111");
        Article b = new Article(2L, "ㄴㄴㄴㄴ", "222");
        Article c = new Article(3L, "ㄷㄷㄷㄷ", "333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        // 실제 결과
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공____존재하는_id_입력() {
     //예상
     Long id = 1L;
     Article expected = new Article(id, "ㄱㄱㄱㄱ", "111");

     //실제
     Article article = articleService.show(id);

     //비교
     assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패____존재하지_않는_id_입력() {
        //예상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공____title과_content만_있는_dto_입력() {
        //예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패____id가_포함된_dto_입력() {
        //예상
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(4L, title, content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void update_성공____존재하는_id와_title_content가_있는_dto_입력(){
        //예상
        String title = "업데이트 테스트";
        String content = "테스트테스트";
        ArticleForm dto = new ArticleForm(1L, title, content);
        Article expected = new Article(1L, title, content);
        //실제
        Article article = articleService.update(1L, dto);
        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void update_성공____존재하는_id와_title만_있는_dto_입력(){
        //예상
        String title = "dddddd";

        ArticleForm dto = new ArticleForm(1L, title, null);
        Article expected = new Article(1L, title, "111");
        //실제
        Article article = articleService.update(1L, dto);
        //비교
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void update_실패____존재하지_않는_id의_dto_입력(){
        //예상
        String title = "dddddd";

        ArticleForm dto = new ArticleForm(-1L, title, "dddd");
        Article expected = null;
        //실제
        Article article = articleService.update(-1L, dto);
        //비교
        assertEquals(expected,article);

    }
    @Test
    @Transactional
    void update_실패____id만_있는_dto_입력(){
        //예상
        ArticleForm dto = new ArticleForm(1L, null, null);
        Article expected = new Article(1L, "ㄱㄱㄱㄱ", "111");
        //실제
        Article article = articleService.update(1L, dto);
        //비교
        assertEquals(expected.toString(),article.toString());
    }

    @Test
    @Transactional
    void delete_성공____존재하는_id_입력(){
        //예상
        Article expected = new Article(1L, "ㄱㄱㄱㄱ", "111");
        //실제
        Article article = articleService.delete(1L);
        //비교
        assertEquals(expected.toString(),article.toString());

    }

    @Test
    @Transactional
    void delete_실패____존재하지_않는_id_입력(){
        //예상
        Article expected = null;
        //실제
        Article article = articleService.delete(5L);
        //비교
        assertEquals(expected,article);
    }

}