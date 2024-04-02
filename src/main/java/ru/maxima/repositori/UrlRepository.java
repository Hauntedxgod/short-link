package ru.maxima.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.maxima.model.Url;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<Url , Long> {

    Optional<Url> findByShortsUrl(String shortUrl);

}
