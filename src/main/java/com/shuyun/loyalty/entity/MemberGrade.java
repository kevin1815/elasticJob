package com.shuyun.loyalty.entity;

public class MemberGrade {
    private final Long id;
    private final Long gradeId;

    public MemberGrade(Long id, Long gradeId) {
        this.id = id;
        this.gradeId = gradeId;
    }

    public Long getId() {
        return id;
    }

    public Long getGradeId() {
        return gradeId;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", gradeId=" + gradeId +
                '}';
    }
}
