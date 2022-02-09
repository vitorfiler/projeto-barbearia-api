package com.barbeariaapi.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="plano_beneficio")
public class PlanoBeneficio {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plano_ID")
	private Plano plano;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "beneficio_ID")
	private Beneficio beneficio;
	
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PlanoBeneficio)) return false;
//        PlanoBeneficio that = (PlanoBeneficio) o;
//        return Objects.equals(beneficio.getDsBeneficio(), that.beneficio.getDsBeneficio()) &&
//                Objects.equals(plano.getDsPlano(), that.plano.getDsPlano());
//    }
//    
//    @Override
//    public int hashCode() {
//        return Objects.hash(beneficio.getDsBeneficio(), plano.getDsPlano());
//    }
}