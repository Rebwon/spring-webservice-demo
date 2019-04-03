package ko.maeng.webservice.web;

import ko.maeng.webservice.domain.PostsRepository;
import ko.maeng.webservice.domain.PostsSaveReqDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private final PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveReqDto dto){
        postsRepository.save(dto.toEntity());
    }
}
