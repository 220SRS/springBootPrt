package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //JPA와 연동한 테스트
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1: 4번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 4L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Comment a = new Comment(1L, article, "Park", "굳 윌 헌팅");
            Comment b = new Comment(2L, article, "Kim", "아이 엠 샘");
            Comment c = new Comment(3L, article, "Choi", "쇼생크의 탈출");

            List<Comment> expected = new ArrayList<>(Arrays.asList(a,b,c));
            // 검증
            assertEquals(expected.toString(), comments.toString(), "4번 글의 모든 댓글을 출력!");
        }
        /* Case 2: 1번 게시글의 모든 댓글 조회 */
        {
            // 입력 데이터 준비
            Long articleId = 1L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            List<Comment> expected = new ArrayList<>(Arrays.asList());
            // 검증
            assertEquals(expected.toString(), comments.toString(), "1번 글은 댓글이 없음");
        }

        /* Case 3: 9번 게시글의 모든 댓글 조회 */
        {
            //입력 데이터 준비
            Long articleId = 9L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            List<Comment> expected = new ArrayList<>();
            //검증
            assertEquals(expected.toString(), comments.toString(), "9번 글이 없음");

        }
        /* Case 4: 9999번 게시글의 모든 댓글 조회 */
        {
            //입력 데이터 준비
            Long articleId = 9999L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            List<Comment> expected = new ArrayList<>();
            //검증
            assertEquals(expected.toString(), comments.toString(), "9999번 글이 없음");
        }
        /* Case 5: -1번 게시글의 모든 댓글 조회 */
        {
            //입력 데이터 준비
            Long articleId = -1L;
            //실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            //예상하기
            List<Comment> expected = new ArrayList<>();
            //검증
            assertEquals(expected.toString(), comments.toString(), "-1번 글이 없음");
        }
    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            String nickname = "Park";

            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상하기

            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Article article1 = new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ");
            Article article2 = new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ");

            Comment a = new Comment(1L, article, nickname, "굳 윌 헌팅");
            Comment b = new Comment(4L, article1, nickname, "치킨");
            Comment c = new Comment(7L, article2, nickname, "조깅");

            List<Comment> expected = new ArrayList<>(Arrays.asList(a,b,c));

            //검증
            assertEquals(expected.toString(), comments.toString(), "Park의 모든 댓글을 출력!");
        }

        /* Case 2: "Kim"의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            String nickname = "Kim";

            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상하기

            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 ㄱ");
            Article article1 = new Article(5L, "당신의 소울 푸드는?", "댓글 ㄱㄱ");
            Article article2 = new Article(6L, "당신의 취미는?", "댓글 ㄱㄱㄱ");

            Comment a = new Comment(2L, article, nickname, "아이 엠 샘");
            Comment b = new Comment(5L, article1, nickname, "샤브샤브");
            Comment c = new Comment(8L, article2, nickname, "유튜브");

            List<Comment> expected = new ArrayList<>(Arrays.asList(a,b,c));

            //검증
            assertEquals(expected.toString(), comments.toString(), "Kim의 모든 댓글을 출력!");
        }
        /* Case 3: null 의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            String nickname = null;

            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상하기
            List<Comment> expected = new ArrayList<>();

            //검증
            assertEquals(expected.toString(), comments.toString(), "nickname이 null일 때 모든 댓글을 출력!");
        }
        /* Case 4: ""의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            String nickname = "";

            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상하기
            List<Comment> expected = new ArrayList<>();

            //검증
            assertEquals(expected.toString(), comments.toString(), "nickname이 null일 때 모든 댓글을 출력!");
        }
        /* Case 5: "i"의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            String nickname = "i";

            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);

            //예상하기
            List<Comment> expected = new ArrayList<>();

            //검증
            assertEquals(expected.toString(), comments.toString(), "nickname이 null일 때 모든 댓글을 출력!");
        }
    }
}