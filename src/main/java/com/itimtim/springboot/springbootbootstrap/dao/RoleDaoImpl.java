package com.itimtim.springboot.springbootbootstrap.dao;

import com.itimtim.springboot.springbootbootstrap.model.Role;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Component
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getRolesByIds(List<Long> ids) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.id IN :ids", Role.class).setParameter("ids", ids);
        return Set.copyOf(query.getResultList());
    }
}
