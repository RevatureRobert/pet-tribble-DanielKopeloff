package Model;

public class TribbleXLabs {

    public Tribble tribbleId;
    public Lab labId;

    public TribbleXLabs(Tribble tribbleId, Lab labId) {
        this.tribbleId = tribbleId;
        this.labId = labId;
    }

    public Tribble getTribbleId() {
        return tribbleId;
    }

    public void setTribbleId(Tribble tribbleId) {
        this.tribbleId = tribbleId;
    }

    public Lab getLabId() {
        return labId;
    }

    public void setLabId(Lab labId) {
        this.labId = labId;
    }

    @Override
    public String toString() {
        return "{" +
                tribbleId +
                 labId +
                '}';
    }
}
