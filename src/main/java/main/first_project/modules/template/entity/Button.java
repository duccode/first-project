package main.first_project.modules.template.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import main.first_project.common.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "buttons")
public class Button {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "button_id")
    private Long buttonId;

    @Column(name = "button_number")
    private Integer buttonNumber;

    @Column(name = "post_back")
    private Integer postBack;

    @Column(name = "method")
    private Integer method;

    @Column(name = "label")
    private String label;

    @Column(name = "data")
    private String data;

    @Column(name = "scenario")
    private Integer scenario;

    @Column(name = "tag")
    private Integer tag;

    @Column(name = "event_time_id")
    private Integer eventTimeId;


}
