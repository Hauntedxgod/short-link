package ru.maxima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.maxima.dto.UrlRequestDto;
import ru.maxima.dto.UrlResponseDto;
import ru.maxima.model.Url;
import ru.maxima.service.UrlService;

@RestController
@RequestMapping("/api/v1")
public class UrlController {

    private final UrlService service;

    @Autowired
    public UrlController(UrlService service) {
        this.service = service;
    }


    @GetMapping()
    public String getUrl(Model model){
        model.addAttribute("getUrl" , new Url());
        return "view-newUrl";
    }

    @PostMapping()
    public ResponseEntity<UrlResponseDto>  setUrl(@ModelAttribute("getUrl") UrlRequestDto url , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Url save = service.save(url.getUrl());
        UrlResponseDto urlResponseDto = new UrlResponseDto();
        urlResponseDto.setUrl(save.getUrl());
        urlResponseDto.setShortsUrl(save.getShortsUrl());
        urlResponseDto.setClickUrl(save.getClickUrl());
        return ResponseEntity.ok(urlResponseDto);
    }

    @GetMapping("/{shortUrl}")
    private ResponseEntity<UrlResponseDto> getUrl(@PathVariable  String shortUrl){
        Url url = service.findBy(shortUrl);
        UrlResponseDto urlResponseDto = new UrlResponseDto();
        urlResponseDto.setUrl(url.getUrl());
        urlResponseDto.setShortsUrl(url.getShortsUrl());
        urlResponseDto.setClickUrl(url.getClickUrl());
        return ResponseEntity.ok(urlResponseDto);
    }

}
