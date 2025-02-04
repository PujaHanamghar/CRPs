package in.crm.main.master;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "appraisals")
public class AppraisalsMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Primary Key with auto-increment
    private Integer appraisalsId;

    private String appraisalsMonth;
    private Double overAllRating;
    private String performanceCategory;
    private BigDecimal salaryIncrement;
    private BigDecimal bonusAmount;
    private String promotionStatus;
    private String comments;

    // Getters and Setters
    public Integer getAppraisalsId() {
        return appraisalsId;
    }

    public void setAppraisalsId(Integer appraisalsId) {
        this.appraisalsId = appraisalsId;
    }

    public String getAppraisalsMonth() {
        return appraisalsMonth;
    }

    public void setAppraisalsMonth(String appraisalsMonth) {
        this.appraisalsMonth = appraisalsMonth;
    }

    public Double getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(Double overAllRating) {
        this.overAllRating = overAllRating;
    }

    public String getPerformanceCategory() {
        return performanceCategory;
    }

    public void setPerformanceCategory(String performanceCategory) {
        this.performanceCategory = performanceCategory;
    }

    public BigDecimal getSalaryIncrement() {
        return salaryIncrement;
    }

    public void setSalaryIncrement(BigDecimal salaryIncrement) {
        this.salaryIncrement = salaryIncrement;
    }

    public BigDecimal getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(BigDecimal bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getPromotionStatus() {
        return promotionStatus;
    }

    public void setPromotionStatus(String promotionStatus) {
        this.promotionStatus = promotionStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
