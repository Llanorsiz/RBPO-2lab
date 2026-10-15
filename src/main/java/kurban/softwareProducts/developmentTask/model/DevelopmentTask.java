package kurban.softwareProducts.developmentTask.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "development_tasks")
public class DevelopmentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long assigneeUserId;

    @Column(nullable = false)
    private Long releaseId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DevelopmentTaskProgress progress;
}
