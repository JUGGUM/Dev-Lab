package hello.springmvc.basic.domain.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    //DB에 데이터 저장
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    //데이터 조회함과 동시에 캐시에 저장
    @Cacheable(value = "movie")
    public Movie get(Long id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new NullPointerException("no book"));
    }
}