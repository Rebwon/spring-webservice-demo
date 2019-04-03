package ko.maeng.webservice.service;

import ko.maeng.webservice.domain.PostsMainResponseDto;
import ko.maeng.webservice.domain.PostsRepository;
import ko.maeng.webservice.domain.PostsSaveReqDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveReqDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                    .map(PostsMainResponseDto::new)
                    .collect(toList());
    }
}
