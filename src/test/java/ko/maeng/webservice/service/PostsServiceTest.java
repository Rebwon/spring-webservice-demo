package ko.maeng.webservice.service;

import ko.maeng.webservice.domain.Posts;
import ko.maeng.webservice.domain.PostsRepository;
import ko.maeng.webservice.domain.PostsSaveReqDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_Posts테이블에_저장된다(){
        //given
        PostsSaveReqDto dto = PostsSaveReqDto.builder()
                                .title("테스트 타이틀")
                                .content("테스트")
                                .author("msolo021015@naver.com")
                                .build();

        //when
        postsService.save(dto);

        //then
        Posts posts = postsRepository.findAll().get(0);
        assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
    }
}