package main.first_project.modules.bot.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BotRequest {

    private Long adminId;
    private String viewName;
    private String urlAddFriend;
    private Integer planType;
    private LocalDateTime expiredDate;
    private Integer billStatus;
}
