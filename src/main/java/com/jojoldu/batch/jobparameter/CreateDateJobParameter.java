package com.jojoldu.batch.jobparameter;

import com.jojoldu.batch.reader.jpa.ProductStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Getter
@NoArgsConstructor
public class CreateDateJobParameter {

//    @Value("#{ T(java.time.LocalDate).parse(jobParameters[createDate], T(java.time.format.DateTimeFormatter).ofPattern('yyyy-MM-dd'))}")

//    @Value("#{ T(java.time.LocalDate).parse(jobParameters[createDate])}")
//    @Value("#{ T(com.jojoldu.batch.jobparameter.LocalDateConverter).convert(jobParameters[createDate])}")
    private LocalDate createDate;

    @Value("#{jobParameters[status]}")
    private ProductStatus status;

    @Value("#{jobParameters[createDate]}")
    public void setCreateDate(String createDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.createDate = LocalDate.parse(createDate, formatter);
    }

//    public CreateDateJobParameter(String createDateStr, ProductStatus status) {
//        this.createDate = LocalDate.parse(createDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        this.status = status;
//    }
}