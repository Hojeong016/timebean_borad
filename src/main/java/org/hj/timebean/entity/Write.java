package org.hj.timebean.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hj.timebean.tsid.TSID;
import org.hj.timebean.tsid.TSIDListener;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(TSIDListener.class)
public class Write {

    @Id
    @TSID
    private String id;

    @Column(name = "accountId")
    private String accountId;
    @Column(name = "content")
    private String content;

    @Lob
    @Column(name = "image")
    private byte[] image;


}
