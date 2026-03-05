package main.first_project.modules.bot.mapper;

import main.first_project.modules.bot.dto.BotRequest;
import main.first_project.modules.bot.dto.BotResponse;
import main.first_project.modules.bot.entity.Bot;

public class BotMapper {
    public static Bot toEntity(BotRequest request){
        Bot bot = new Bot();
        bot.setAdminId(request.getAdminId());
        bot.setViewName(request.getViewName());
        bot.setUrlAddFriend(request.getUrlAddFriend());
        bot.setPlanType(request.getPlanType());
        bot.setExpiredDate(request.getExpiredDate());
        bot.setBillStatus(request.getBillStatus());
        return bot;
    }

    public static BotResponse toDTO(Bot bot){
        BotResponse res = new BotResponse();
        res.setId(bot.getId());
        res.setAdminId(bot.getAdminId());
        res.setViewName(bot.getViewName());
        res.setUrlAddFriend(bot.getUrlAddFriend());
        res.setPlanType(bot.getPlanType());
        res.setExpiredDate(bot.getExpiredDate());
        res.setBillStatus(bot.getBillStatus());
        return res;
    }
}
