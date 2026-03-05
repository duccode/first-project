package main.first_project.modules.bot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import main.first_project.common.BaseEntity;

import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Setter
@Table(name = "bots")
public class Bot extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "admin_id")
    private Long adminId;

    @Column(name = "view_name")
    private String viewName;

    @Column(name = "url_add_friend")
    private String urlAddFriend;

    @Column(name = "plan_type")
    private Integer planType;

    @Column(name = "expired_date")
    private DateTimeFormatter expiredDate;

    @Column(name = "bill_status")
    private Integer billStatus;

}
