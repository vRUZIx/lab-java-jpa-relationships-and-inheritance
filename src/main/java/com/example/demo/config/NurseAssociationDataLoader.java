package com.example.demo.config;

import com.example.demo.Entity.Association;
import com.example.demo.Entity.Division;
import com.example.demo.Entity.Member;
import com.example.demo.Entity.MemberStatus;
import com.example.demo.repository.AssociationRepository;
import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NurseAssociationDataLoader {

    @Bean
    CommandLineRunner seedNurseAssociationData(AssociationRepository associationRepository) {
        return args -> {
            if (associationRepository.count() > 0) {
                return;
            }

            Association association = new Association("Nurse Association of Spain");

            addDivisionWithMembers(
                association,
                "Emergency Nursing",
                "Madrid",
                "Ana Garcia",
                "Luis Romero"
            );
            addDivisionWithMembers(
                association,
                "Pediatric Nursing",
                "Barcelona",
                "Lucia Torres",
                "Mateo Diaz"
            );
            addDivisionWithMembers(
                association,
                "Surgical Nursing",
                "Valencia",
                "Sofia Martin",
                "Pablo Navarro"
            );
            addDivisionWithMembers(
                association,
                "Oncology Nursing",
                "Seville",
                "Carmen Perez",
                "Javier Ruiz"
            );
            addDivisionWithMembers(
                association,
                "Geriatric Nursing",
                "Bilbao",
                "Elena Santos",
                "Diego Vega"
            );
            addDivisionWithMembers(
                association,
                "Community Health Nursing",
                "Malaga",
                "Marta Lozano",
                "Nora Castillo"
            );
            addDivisionWithMembers(
                association,
                "Critical Care Nursing",
                "Zaragoza",
                "Irene Fuentes",
                "Alvaro Mendez"
            );

            associationRepository.save(association);
        };
    }

    private static void addDivisionWithMembers(
        Association association,
        String divisionName,
        String district,
        String presidentName,
        String memberName
    ) {
        Division division = new Division(divisionName, district);

        Member president = new Member(presidentName, MemberStatus.ACTIVE, LocalDate.now().plusMonths(12));
        Member member = new Member(memberName, MemberStatus.LAPSED, LocalDate.now().minusMonths(2));

        division.addMember(president);
        division.addMember(member);
        division.setPresident(president);

        association.addDivision(division);
    }
}
