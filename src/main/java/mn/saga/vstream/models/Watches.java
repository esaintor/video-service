package mn.saga.vstream.models;

import javax.persistence.*;


@Entity
@Table(name="watches")
public class Watches {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "watch_id")
    private Long watchId;

    public Watches() {
    }

    @Column(name = "started_date")
    private String startedDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "spent_seconds")
    private Long spentSeconds;

    public Long getWatchId() {
        return watchId;
    }

    public void setWatchId(Long watchId) {
        this.watchId = watchId;
    }

    public String getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(String startedDate) {
        this.startedDate = startedDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getSpentSeconds() {
        return spentSeconds;
    }

    public void setSpentSeconds(Long spentSeconds) {
        this.spentSeconds = spentSeconds;
    }
}
