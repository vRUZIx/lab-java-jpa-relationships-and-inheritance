package com.example.demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String district;

    @ManyToOne
    @JoinColumn(name = "president_id")
    private Member president;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Member> members = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;

    public Division() {
    }

    public Division(String name, String district) {
        this.name = name;
        this.district = district;
    }

    public void addMember(Member member) {
        members.add(member);
        member.setDivision(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public List<Member> getMembers() {
        return members;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
