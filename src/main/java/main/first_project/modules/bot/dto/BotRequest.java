package main.first_project.modules.bot.dto;

import lombok.Data;

import java.time.format.DateTimeFormatter;

@Data
public class BotRequest {

    private Long adminId;
    private String viewName;
    private String urlAddFriend;
    private Integer planType;
    private DateTimeFormatter expiredDate;
    private Integer billStatus;
}
