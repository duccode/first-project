package main.first_project.modules.bot.repository;

import main.first_project.modules.bot.entity.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot, Long> {

}
