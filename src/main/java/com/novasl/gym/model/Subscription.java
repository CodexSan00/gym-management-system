package com.novasl.gym.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "subscriptions")

public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plain_id", nullable = false)
    private Plan plan;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "paid_amount", nullable = false)
    private BigDecimal paidAmount;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    public Subscription() {}
    public Subscription(Member member, Plan plan,
                        LocalDate startDate, LocalDate endDate,
                        BigDecimal totalAmount, BigDecimal paidAmount){
        this.member = member;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
        this.paidAmount = paidAmount;
        this.active = true;
    }

    //Method to verify if a member owes money
    public BigDecimal getRemainingDebt(){
        return totalAmount.subtract(paidAmount);
    }

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() { return member; }
    public void setMember(Member member) {
        this.member = member;
    }

    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public LocalDate getStartDate() { return startDate;}
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPaidAmount() { return paidAmount; }
    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public boolean isActive() { return active; }
    public void setActive(boolean active) {
        this.active = active;
    }
}
