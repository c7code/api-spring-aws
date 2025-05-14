package com.crud.event.api.service;


import com.crud.event.api.domain.event.Event;
import com.crud.event.api.domain.event.EventRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class EventService {

    public Event createEvent(EventRequestDto data) {
        String imgUrl = null;

        if (data.img() != null) {
            imgUrl = this.uploadImg(data.img());
        }

        Event event = new Event();
        event.setTitle(data.title());
        event.setDescription(data.description());
        event.setEventurl(data.event_url());
        event.setDate(new Date(data.date()));
        event.setImgUrl(imgUrl);

        return event;
    }


    private String uploadImg(MultipartFile file) {

        return null;

    }


}
