package com.gilles.hotelmama;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class UserToDosKey implements Serializable {

    @Column(name = "user_id")
    Long studentId;

    @Column(name = "to_do_id")
    Long courseId;

}
