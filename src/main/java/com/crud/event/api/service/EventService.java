package com.crud.event.api.service;


import com.amazonaws.services.s3.AmazonS3;
import com.crud.event.api.domain.event.Event;
import com.crud.event.api.domain.event.EventRequestDto;
import com.crud.event.api.repositories.EventRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.UUID;

@Service
public class EventService {


    @Value("${aws.bucket.name}")
    private String bucketName;

    @Autowired
    EventRepositories eventRepositories;

    private AmazonS3 s3client;

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
        event.setRemote(data.remote());

        eventRepositories.save(event);

        return event;
    }


    private String uploadImg(MultipartFile mltfile) {

        String imgName = UUID.randomUUID()+"_"+ mltfile.getOriginalFilename();

        try {
            File file = this.convertMultipartToFile(mltfile);
            s3client.putObject(bucketName, imgName, file);
            file.delete();
            return s3client.getUrl(bucketName, imgName).toString();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    private File convertMultipartToFile(MultipartFile mltfile) throws Exception {

        File convFile = new File(mltfile.getOriginalFilename());

        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(mltfile.getBytes());
        fos.close();

        return convFile;
    }

}
