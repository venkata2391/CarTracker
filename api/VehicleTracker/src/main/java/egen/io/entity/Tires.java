package egen.io.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

/**
 * Created by Ananth on 6/25/2017.
 */
@Entity
public class Tires {

    @Id
    private String id;
    private Integer frontLeft;
    private Integer frontRight;
    private Integer rearLeft;
    private Integer rearRight;

    public  Tires(){
        this.id = UUID.randomUUID().toString();
    }

    public Integer getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(Integer frontLeft) {
        this.frontLeft = frontLeft;
    }

    public Integer getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(Integer frontRight) {
        this.frontRight = frontRight;
    }

    public Integer getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(Integer rearLeft) {
        this.rearLeft = rearLeft;
    }

    public Integer getRearRight() {
        return rearRight;
    }

    public void setRearRight(Integer rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}
